package app;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		
		MyMatrix<Float> testF = new MyMatrix<>(10, 10, Float.class);
		MyMatrix<Double> testD = new MyMatrix<>(10, 10, Double.class);
		MyMatrix<TC> testTC = new MyMatrix<>(3, 3, TC.class);
		
		testF.pop();
		testF.popVector();
		testF.GaussNoChoice();
		testF.GaussHalfChoice();
		testF.GaussFullChoice();
		testF.chceck();
		testF.chceckf();
		testF.chceckh();

		testD.pop();
		testD.popVector();
		testD.GaussNoChoice();
		testD.GaussHalfChoice();
		testD.GaussFullChoice();
		testD.chceck();
		testD.chceckf();
		testD.chceckh();
		
		testTC.pop();
		testTC.popVector();
		testTC.GaussNoChoice();
		testTC.GaussHalfChoice();
		testTC.GaussFullChoice();
		testTC.chceck();
//		testTC.chceckf();
//		testTC.chceckh();
		
	
	}

}
