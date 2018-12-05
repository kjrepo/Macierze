package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		
		MyMatrix<Float> testF = new MyMatrix<>(10, 10, Float.class);
		MyMatrix<Double> testD = new MyMatrix<>(10, 10, Double.class);
		MyMatrix<TC> testTC = new MyMatrix<>(10, 10, TC.class);
		
		
		PrintWriter zapis = null;
		try {
			zapis = new PrintWriter("dane.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zapis.print("");
	
		for(int i = 0; i < 101; i++) {
			

		
		testF.pop();
		testF.popVector();
		testF.GaussNoChoice();
		testF.GaussHalfChoice();
		testF.GaussFullChoice();
		testF.chceck();
		testF.chceckh();
		testF.chceckf();
		zapis.print(testF.chceck()+",");
		zapis.print(testF.chceckh()+",");
		zapis.println(testF.chceckf());

		

		testD.pop();
		testD.popVector();
		testD.GaussNoChoice();
		testD.GaussHalfChoice();
		testD.GaussFullChoice();
		testD.chceck();
		testD.chceckh();
		testD.chceckf();
		zapis.print(testD.chceck()+",");
		zapis.print(testD.chceckh()+",");
		zapis.println(testD.chceckf());
		
		testTC.pop();
		testTC.popVector();
	//	testTC.GaussNoChoice();
	//	testTC.GaussHalfChoice();
	//	testTC.GaussFullChoice();
	//	testTC.chceck();
//		testTC.chceckh();
//		testTC.chceckf();
	//	zapis.println(testTC.chceck());

//		
		}
		zapis.close();
		
		long time1 = System.currentTimeMillis();
		long time2 = System.currentTimeMillis();
		
		MyMatrix<Float> testF500 = new MyMatrix<>(500, 500, Float.class);
		MyMatrix<Double> testD500 = new MyMatrix<>(500, 500, Double.class);
		MyMatrix<TC> testTC500 = new MyMatrix<>(500, 500, TC.class);
		
		testF500.pop();
		testF500.popVector();
		time1 = System.currentTimeMillis();
		testF500.GaussNoChoice();
		time2 = System.currentTimeMillis();
		System.out.println("Float, NoChoice (ms)=" + (time2-time1));
		
		time1 = System.currentTimeMillis();
		testF500.GaussHalfChoice();
		time2 = System.currentTimeMillis();
		System.out.println("Float, HalfChoice (ms)=" + (time2-time1));
		
		time1 = System.currentTimeMillis();
		testF500.GaussFullChoice();
		time2 = System.currentTimeMillis();
		System.out.println("Float, FullChoice (ms)=" + (time2-time1));
		
		///
		
		testD500.pop();
		testD500.popVector();
		time1 = System.currentTimeMillis();
		testD500.GaussNoChoice();
		time2 = System.currentTimeMillis();
		System.out.println("Double, NoChoice (ms)=" + (time2-time1));
		
		time1 = System.currentTimeMillis();
		testD500.GaussHalfChoice();
		time2 = System.currentTimeMillis();
		System.out.println("Double, HalfChoice (ms)=" + (time2-time1));
		
		time1 = System.currentTimeMillis();
		testD500.GaussFullChoice();
		time2 = System.currentTimeMillis();
		System.out.println("Double, FullChoice (ms)=" + (time2-time1));
		
		///
		
		testTC500.pop();
		testTC500.popVector();
		time1 = System.currentTimeMillis();
		testTC500.GaussNoChoice();
		time2 = System.currentTimeMillis();
		System.out.println("TC, NoChoice (ms)=" + (time2-time1));
		
		time1 = System.currentTimeMillis();
		testTC500.GaussHalfChoice();
		time2 = System.currentTimeMillis();
		System.out.println("TC, HalfChoice (ms)=" + (time2-time1));
		
		time1 = System.currentTimeMillis();
		testTC500.GaussFullChoice();
		time2 = System.currentTimeMillis();
		System.out.println("TC, FullChoice (ms)=" + (time2-time1));
		
	}

}
