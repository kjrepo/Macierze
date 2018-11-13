package app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyMatrix<T> {

	private int lenght;
	private int width; 
	private Object[][] matrix;
	private List<T> list = new ArrayList<T>();
	private List<T> vector = new ArrayList<T>();
	private List<List<T>> lol = new ArrayList<List<T>>();
	public MyMatrix(int lenght, int width) {
		matrix = new Object[lenght][width];
		
		this.lenght = lenght;
		this.width = width;
	}
	
	public int getLenght()
	{
		return lenght;
	}
	
	public Object getPartitionOfMatrix(int i, int j)
	{
		return matrix[i][j];
	}
	
	public void populate(Function<TC, T> creator) {	//Function pozwala wklejac kawalki kody z poziomy wyzej, korzystam z tego w main 
		TC rand = new TC();
		for(int i = 0; i<lenght; i++)
			for(int j = 0; j < width; j++) {
				 T t = creator.apply(rand);
				 matrix[i][j] = t;
			}
	}
	
	
	public void populateL(Function<TC, T> creator) {	//Function pozwala wklejac kawalki kody z poziomy wyzej, korzystam z tego w main 
		TC rand = new TC();
		for(int i = 0; i<lenght; i++) {
			for(int j = 0; j < width; j++) {
				 T t = creator.apply(rand);
				 //matrix[i][j] = t;
				 
				 list.add(t);
				 
				 
			}
		lol.add(list);
		list = new ArrayList<T>();
		}
	}
	
	
	public void populateVector(Function<TC, T> creator) {	//Function pozwala wklejac kawalki kody z poziomy wyzej, korzystam z tego w main 
		TC rand = new TC();
		for(int i = 0; i<lenght; i++) {

				 T t = creator.apply(rand);
				 //matrix[i][j] = t;
				 vector.add(t); 
			

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
	
	public void testL() {	// nalezy uzywac tego nizej 
		for(int i = 0; i<lenght; i++) {
				System.out.println("\n");
				
			for(int j = 0; j < width; j++) {
				
				//System.out.print(matrix[i][j] + " ");
				System.out.print(lol.get(i).get(j));
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
	
	public void GaussEliminationFloat()
	{
		int counter, counter2, counter3;
		double multiplier;
		float sum;
		double epsilon = Math.pow(10, -13);
		boolean isSolution = false;
		
		for(counter = 1 ; counter <= lenght - 1 ; counter++)
		{
			for(counter2 = counter + 1 ; counter2 <= lenght ; counter2++) // nigdy nie wchodzi w petle... 
			{
				if(Math.abs((float) lol.get(counter).get(counter2)) < epsilon)
					break;
				multiplier = - ((float)(lol.get(counter2).get(counter))/ (float) lol.get(counter).get(counter2));
				for(counter3 = counter + 1 ; counter3 <= lenght + 1 ; counter3++)
				{
					//matrix[counter2][counter3] = matrix[counter2][counter3] + (multiplier * matrix[counter][counter3]);
					Object o = ((float)lol.get(counter).get(counter2) + (float)(multiplier * (float)lol.get(counter).get(counter3)));
					T a = (T) o;
					lol.get(counter2).set(counter3, a);
			}
		}
		for(counter = lenght ; counter >= 1 ; counter--)
		{
			sum = (float) lol.get(counter).get(lenght+1);
			for(counter2 = lenght ; counter2 >= counter + 1 ; counter--)
			{
				sum = sum - (float)((float)lol.get(counter).get(counter2) * (float) vector.get(counter2));
			}
			if(Math.abs((float)lol.get(counter).get(counter)) < epsilon)
				break;
			isSolution = true;
		}
	}
	
	
	}
}
	
