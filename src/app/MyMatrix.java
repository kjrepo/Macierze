package app;

import java.util.Random;
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
	
	public void populate(Function<Random, T> creator) {
		Random rand = new Random();
		for(int i = 0; i<lenght; i++)
			for(int j = 0; j < width; j++) {
				 T t = creator.apply(rand);
				 matrix[i][j] = t;
			}
	}
	
	public void test() {
		for(int i = 0; i<lenght; i++) {
				System.out.println("\n");
			for(int j = 0; j < width; j++) {
				
				System.out.print(matrix[i][j] + " ");
			}
		}
	}
	
	
	
	
}
