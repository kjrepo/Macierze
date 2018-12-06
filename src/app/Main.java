package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		
		MyMatrix<Float> testF = new MyMatrix<>(10, 10, Float.class);
		MyMatrix<Double> testD = new MyMatrix<>(10, 10, Double.class);
		MyMatrix<TC> testTC = new MyMatrix<>(10, 10, TC.class);
		
		
		PrintWriter zapisF = null;
		PrintWriter zapisD = null;
		PrintWriter zapisTC = null;
		PrintWriter zapisNo = null;
		PrintWriter zapisHalf = null;
		PrintWriter zapisFull = null;

		try {
			zapisF = new PrintWriter("float.txt");
			zapisD = new PrintWriter("double.txt");
			zapisTC = new PrintWriter("tc.txt");
			zapisNo = new PrintWriter("noChoice.txt");
			zapisHalf = new PrintWriter("Half.txt");
			zapisFull = new PrintWriter("full.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		for(int i = 0; i < 101; i++) {
			

		
		testF.pop();
		testF.popVector();
		testF.GaussNoChoice();
		testF.GaussHalfChoice();
		testF.GaussFullChoice();
		testF.chceck();
		testF.chceckh();
		testF.chceckf();
		zapisF.print(testF.chceck()+";");
		zapisF.print(testF.chceckh()+";");
		zapisF.print(testF.chceckf()+";");
		zapisNo.print(testF.chceck()+";");
		zapisHalf.print(testF.chceckh()+";");
		zapisFull.print(testF.chceckf()+";");

		

		testD.pop();
		testD.popVector();
		testD.GaussNoChoice();
		testD.GaussHalfChoice();
		testD.GaussFullChoice();
		testD.chceck();
		testD.chceckh();
		testD.chceckf();
		zapisD.print(testD.chceck()+";");
		zapisD.print(testD.chceckh()+";");
		zapisD.print(testD.chceckf()+";");
		zapisNo.print(testD.chceck()+";");
		zapisHalf.print(testD.chceckh()+";");
		zapisFull.print(testD.chceckf()+";");
		
		testTC.pop();
		testTC.popVector();
		
		zapisTC.print(testTC.chceck());
		zapisNo.print(testTC.chceck());
	//	testTC.GaussNoChoice();
	//	testTC.GaussHalfChoice();
	//	testTC.GaussFullChoice();
	//	testTC.chceck();
//		testTC.chceckh();
//		testTC.chceckf();
	//	zapis.println(testTC.chceck());

//		
		}
		zapisF.close();
		zapisD.close();
		zapisTC.close();
		zapisNo.close();
		zapisHalf.close();
		zapisFull.close();

		
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
