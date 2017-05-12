A package to calculate the Estrada Index of an adjacency matrix.

# Intro #

I was conducting research into spectral analysis of argumentation frameworks at the University of Liverpool and I noticed that the only packages to calculate the Estrada Index of a graph were intended for undirected graphs only. Interestingly, the eigenvalues of directed graphs can be complex so the normal equation for the Estrada Index has to be modified to account for this. 

With some simple modifications it turns out that for each eigenvalue, if it is real, it contributes to the sum in the normal way +exp(lambda) where as if lambda is complex it contributes in this way: +2*exp(a)*cos(b), where a and b are the real and imaginary parts of the complex number respectively. A corollary of this is that the Estrada Index is always real, even for directed graphs. I have included a picture of my original proof to make this more clear and information about the Estrada Index can be found at: https://en.wikipedia.org/wiki/Estrada_index

Once this has been realised, construction of an algorithm is trivial, it just checks to see whether the eigenvalue is complex or not and then contributes to the overall sum in the appropriate way.

This program was used to generate a subset of the results in this paper: https://livrepository.liverpool.ac.uk/3002656/1/29_comma2016_Butterworth.pdf

# Usage #

This is a very simple package, it only consists of 1 class that sits on top of the linear algebra library Jama: 
http://math.nist.gov/javanumerics/jama/

So you just give it the adjacency matrix and it does all the eigendecomposition for you.

I have included a Test.java file to show how to call the class.

The only problem I encounted was with regard to compiling and running with the correct classpath (if you are a Java pro, this won't be a problem for you.. or just have some experience with classpaths).

Once downloaded, navigate into the master directory. 

To compile:

javac -cp "Jama-1.0.3.jar" Test.java EstradaIndex.java

To run:

java -cp "Jama-1.0.3.jar:." Test

And then just use the Estrada Index package like it was used in Test in your own code and you are good to go.

If you have any questions, I am happy to answer them at: J.Butterworth2@liv.ac.uk
