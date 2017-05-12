import java.lang.Math;
import Jama.Matrix;
import Jama.EigenvalueDecomposition;

/**
	A class that calculates and returns the Estrada Index
	of some matrix; can be both a symmetric or non-symmetric matrix.
*/
public class EstradaIndex {
	
	private double[][] adjMatrix;
	private double estradaIndex;
	private double[] realEig;
	private double[] imagEig;

	/**
		Takes a matrix of integers as input. It is
		often the case that this matrix is the adjacency
		matrix describing a particular graph structure.
		@param adj The adjacency matrix.
	*/
	public EstradaIndex(int[][] adj) {

		adjMatrix = convertMatrixToDouble(adj);

		calculateEigenvalues();
		calculateEstradaIndex();
	}

	/**
		Returns the generated Estrada Index.
		@return The Estrada Index.
	*/
	public double getEstradaIndex(){

		return estradaIndex;

	}

	/**
		Calculates the Estrada Index.
	*/
	private void calculateEstradaIndex() {

		double runningEE = 0;
		int i = 0;

		while(i < realEig.length) {

			if((imagEig[i] < 0) || (imagEig[i] > 0)){

				double a = realEig[i];
				double b = imagEig[i];

				runningEE += 2 * Math.exp(a) * Math.cos(b);

				i += 2;

			} else {

				double a = realEig[i];

				runningEE += Math.exp(a);

				i += 1;

			}	

		}

		estradaIndex = runningEE;

	}

	/**
		Calls upon the JAMA package to calculate all the
		eigenvalues, which will be used in the calculation 
		of the Estrada Index.
	*/
	private void calculateEigenvalues() {

		Matrix adjM = new Matrix(adjMatrix);
		EigenvalueDecomposition eigD = adjM.eig();
		realEig = eigD.getRealEigenvalues();
		imagEig = eigD.getImagEigenvalues(); 

	}

	/**
		Converts the adjancency matrix into a matrix of doubles,
		this makes it easier to work with in the calcualtion
		of EE.
		@return The adjancency matrix converted to a double matrix.
	*/
	private double[][] convertMatrixToDouble(int[][] m) {

		double[][] d = new double[m.length][m.length];

		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				d[i][j] = (double)m[i][j];
			}
		}

		return d;
	}

}