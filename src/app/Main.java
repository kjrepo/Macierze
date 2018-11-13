package app;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/// Generowanie double
		
		final int zakres= 65536;

		System.out.println("Double");

		System.out.println("");


		MyMatrix<Double> doubleTest = new MyMatrix<Double>(6,6);
		doubleTest.populate(rand ->  Double.valueOf(rand.nextInt(131072) - Math.pow(2, 16))/Math.pow(2, 16));
		doubleTest.test();
		System.out.println("!!!!!!!");
		doubleTest.populateL(rand ->  Double.valueOf(rand.nextInt(131072) - Math.pow(2, 16))/Math.pow(2, 16));
		doubleTest.testL();
		
		
		//Generowanie float
		System.out.println("\n\n\n");
		System.out.println("Floaty");
		System.out.println("");

		
		MyMatrix<Float> floatTest = new MyMatrix<Float>(6,6);
		floatTest.populateL(rand -> ((float) rand.nextInt(zakres*2) - zakres)/zakres);
		floatTest.testL();
		floatTest.GaussEliminationFloat();
		System.out.println("???????????????????");
		floatTest.testL();
		
		
		System.out.println("\n\n\n");
		System.out.println("Stworzona liczba");
		System.out.println("");
		
		TC liczba = new TC();
		liczba.nextTC();
		System.out.println("Licznik "+liczba.top);
		System.out.println("Mianownik "+liczba.bot);
		System.out.println("W zapisie dziesietnym "+liczba.top.divide(liczba.bot));
		
		// Generowanie TC
		
		MyMatrix<TC> TCTest = new MyMatrix<TC>(6,6);
		TCTest.populate(rand -> rand.nextTC());
		TCTest.testG(t -> t.top.toString()+"/"+t.bot.toString());
		
		
	}

}
