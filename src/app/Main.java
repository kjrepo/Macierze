package app;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/// Generowanie double
		
		final int zakres= 65536;

		System.out.println("Double");

		System.out.println("");


		MyMatrix<Double> doubleTest = new MyMatrix(6,6);
		doubleTest.populate(rand ->  Double.valueOf(rand.nextInt(131072) - Math.pow(2, 16))/Math.pow(2, 16));
		doubleTest.test();
		
		//Generowanie float
		System.out.println("\n\n\n");
		System.out.println("Floaty");
		System.out.println("");

		
		MyMatrix<Float> floatTest = new MyMatrix(6,6);
		floatTest.populate(rand -> ((float) rand.nextInt(zakres*2) - zakres)/zakres);
		floatTest.test();
		
		System.out.println("\n\n\n");
		System.out.println("Stworzona liczba");
		System.out.println("");
		
		TC liczba = new TC();
		liczba.nextTC();
		System.out.println("Licznik "+liczba.top);
		System.out.println("Mianownik "+liczba.bot);
		System.out.println("W zapisie dziesietnym "+liczba.top.divide(liczba.bot));
		
	}

}
