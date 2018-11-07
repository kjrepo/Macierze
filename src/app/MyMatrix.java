package app;

import java.util.function.Function;

public class MyMatrix<T> {

	private int lenght;
	private int width; 
	private Object[][] matrix;
	
	public MyMatrix(int lenght, int width) {
		matrix = new Object[lenght][width];
		this.lenght = lenght;
		this.width = width;
	}
	
	public void populate(Function<TC, T> creator) {	//Function pozwala wklejac kawalki kody z poziomy wyzej, korzystam z tego w main 
		TC rand = new TC();
		for(int i = 0; i<lenght; i++)
			for(int j = 0; j < width; j++) {
				 T t = creator.apply(rand);
				 matrix[i][j] = t;
			}
	}
	
	public void test() {	// nalezy uzywac tego nizej 
		for(int i = 0; i<lenght; i++) {
				System.out.println("\n");
			for(int j = 0; j < width; j++) {
				
				System.out.print(matrix[i][j] + " ");
			}
		}
	}
	
	
	public void testG(Function<T, String> creator) {   // Domyslny test 
		for(int i = 0; i<lenght; i++) {
				System.out.println("\n");
			for(int j = 0; j < width; j++) {
				T t = (T) matrix[i][j];				//zawsze ok? 
				String s = creator.apply(t);
				System.out.print(s);
				
			}
		}
	}
	
	
	
}
