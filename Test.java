class Test {
	

	public static void main(String[] args) {

		int[][] adj = {{1,0,1},{0,1,0},{0,0,1}};

		EstradaIndex ee = new EstradaIndex(adj);
		double ind = ee.getEstradaIndex();
		System.out.println(ind);

	}

}