package app;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/// Generowanie double


		System.out.println("Double");

		System.out.println("");
		
		float a = 11; 
		float b = 2;
		double c = 3;
		
		
//		MyMatrix<Double> DoubleTest = new MyMatrix<>(5, 5, Double.class);
//		DoubleTest.pop();
//		DoubleTest.popVector();
//		DoubleTest.GaussFullChoice(DoubleTest.tab, DoubleTest.vector, 5);
		
		
		MyMatrix<Float> test = new MyMatrix<>(5, 5, Float.class);
		
		
		test.pop();
		test.popVector();
		test.multiplyMatrix();
		System.out.println("XD");
		test.zeroVector();
		test.GaussNoChoice();
		test.test();
		test.chceck();
		
		
//		System.out.println(test.add(Float.valueOf(2),Float.valueOf(2)));
//		
//		System.out.println("\n\n//////////////////////////////");
//		
//		MyMatrix<TC> testTC = new MyMatrix<>(6, 6, TC.class);
//		testTC.pop();
//		testTC.test();
////		testTC.GaussFullChoice(testTC.tab, testTC.vector, 6);
//		
//		TC one = new TC(BigInteger.valueOf(1),BigInteger.valueOf(2));
//		TC two = new TC(BigInteger.valueOf(1),BigInteger.valueOf(4));
//		
//		System.out.println(testTC.add(one, two).toString());
//		System.out.println(testTC.sub(one, two).toString());
//		System.out.println(testTC.mul(one, two).toString());
//		System.out.println(testTC.div(one, two).toString());

//		MyMatrix<Double> doubleTest = new MyMatrix<Double>(6,6);
//		doubleTest.populate(rand ->  Double.valueOf(rand.nextInt(131072) - Math.pow(2, 16))/Math.pow(2, 16));
//		doubleTest.test();
//		System.out.println("!!!!!!!");
//		doubleTest.populateL(rand ->  Double.valueOf(rand.nextInt(131072) - Math.pow(2, 16))/Math.pow(2, 16));
//		doubleTest.testL();
//		
//		
//		//Generowanie float
//		System.out.println("\n\n\n");
//		System.out.println("Floaty");
//		System.out.println("");
//
//		
//		MyMatrix<Float> floatTest = new MyMatrix<Float>(6,6);
//		floatTest.populateL(rand -> ((float) rand.nextInt(zakres*2) - zakres)/zakres);
//		floatTest.testL();
//		floatTest.GaussEliminationFloat();
//		System.out.println("???????????????????");
//		floatTest.testL();
//		
//		
//		System.out.println("\n\n\n");
//		System.out.println("Stworzona liczba");
//		System.out.println("");
//		
//		TC liczba = new TC();
//		liczba.nextTC();
//		System.out.println("Licznik "+liczba.top);
//		System.out.println("Mianownik "+liczba.bot);
//		System.out.println("W zapisie dziesietnym "+liczba.top.divide(liczba.bot));
//		
//		// Generowanie TC
//		
//		MyMatrix<TC> TCTest = new MyMatrix<TC>(6,6);
//		TCTest.populate(rand -> rand.nextTC());
//		TCTest.testG(t -> t.top.toString()+"/"+t.bot.toString());
//		
		
	}

}
