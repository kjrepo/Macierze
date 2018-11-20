package app;

//TODO compareTo(T,double){return 1 or return 0}
//TODO opposite(T){return-T}

public class MyMatrix<T> {

	private int height;
	private int width; 
	
	//// nowy poczatek
	private T[][] tab;
	private final Class<T> type;
	final int zakres= 65536;
	
	/////

	
	
	
	@SuppressWarnings("unchecked")
	public MyMatrix(int height, int width, Class<T> type) {	
		tab = (T[][]) new Object[width][height];
		this.height = height;
		this.width = width;
		
		this.type = type;
	}
	
	public int getLenght()
	{
		return height;
	}
	
	public T getPartitionOfMatrix(int i, int j)
	{
		return tab[i][j];
	}
	
	@SuppressWarnings("unchecked")
	public void pop() {
		
		
		TC rand = new TC();
		if(type == Float.class) {
			for(int i = 0; i<width; i++)
				for(int j = 0; j < height; j++) {
					Object o = ((float) rand.nextInt(zakres*2) - zakres)/zakres;
					tab[i][j] = (T) o;
				}
			
		}else if(type == Double.class){
			for(int i = 0; i<width; i++)
				for(int j = 0; j < height; j++) {
					Object o = ((double) rand.nextInt(zakres*2) - zakres)/zakres;
					tab[i][j] = (T) o;
				}
		}else if(type == TC.class){
			for(int i = 0; i<width; i++)
				for(int j = 0; j < height; j++) {
					Object o = rand.nextTC();
					tab[i][j] = (T) o;
				}
		}
		
	}
	
		

	
	public void test() {	
		for(int i = 0; i<width; i++) {
				System.out.println("\n");
			for(int j = 0; j < height; j++) {
				
				System.out.print(tab[i][j].toString() + " ");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T add(T one, T two) {
		if(type == Float.class) {
			return (T) (Object) ((float) one + (float) two);
		}else if(type == Double.class) {
			return (T) (Object) ((double) one + (double) two);

		}else if(type == TC.class) {
			
			return (T) TC.add((TC)one,(TC)two);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T sub(T one, T two) {
		if(type == Float.class) {
			return (T) (Object) ((float) one - (float) two);
		}else if(type == Double.class) {
			return (T) (Object) ((double) one - (double) two);

		}else if(type == TC.class) {
			
			return (T) TC.sub((TC)one,(TC)two);
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public T div(T one, T two) {
		if(type == Float.class) {
			return (T) (Object) ((float) one / (float) two);
		}else if(type == Double.class) {
			return (T) (Object) ((double) one / (double) two);

		}else if(type == TC.class) {
			
			return (T) TC.div((TC)one,(TC)two);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T mul(T one, T two) {
		if(type == Float.class) {
			return (T) (Object) ((float) one * (float) two);
		}else if(type == Double.class) {
			return (T) (Object) ((double) one * (double) two);

		}else if(type == TC.class) {
			
			return (T) TC.mul((TC)one,(TC)two);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T abs(T one) {
		if(type == Float.class) {
			return (T) (Object) Math.abs((float)one);
		}else if(type == Double.class) {
			return (T) (Object) Math.abs((double)one);

		}else if(type == TC.class) {
			
			return (T) TC.abs((TC) one);
		}
		return null;
	}
	
	public void swap(int height1, int width1, int height2, int width2) {
		
		T temp = tab[height1][width1];
		tab[height1][width1] = tab[height2][width2];
		tab[height2][width2] = temp;
	}
	
	public int cmp(T one, double two) {
		if(type == TC.class) {
			TC val = (TC) one;
			if(val.aprox > two) {
				return 1;
			}else if(val.aprox < two) {
				return -1;
			}else {
				return 0;
			}
		

		}else if(type == Double.class || type == Float.class){
			
			double val = (double) one;
			if(val > two) {
				return 1;
			}else if(val < two) {
				return -1;
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T neg(T one) {
		
		
		if(type == Float.class) {
			return (T) (Object) ((float) (one) * -1);
		}else if(type == Double.class) {
			return (T) (Object) ((double) (one) * -1);

		}else if(type == TC.class) {
			TC val = (TC) one;
			val.top.negate();
			return (T) val;
		}
		
		
		
		
		
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public T biggestInRow(int rowNumber) {
		if(type == Float.class) {
			T biggest = tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((float)tab[rowNumber][i] > (float)biggest) {
					biggest = tab[rowNumber][i];
				}
				
			}
			return biggest;
		}else if(type == Double.class) {
			T biggest = tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((double)tab[rowNumber][i] > (double)biggest) {
					biggest = tab[rowNumber][i];
				}
			}
			return biggest;

		}else if(type == TC.class) {
			TC biggest = (TC) tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				TC current = (TC) tab[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) tab[rowNumber][i];
				}
			}
			return (T) biggest;
		}
		return null;
	}
	
	
	
	
	@SuppressWarnings({ "unchecked"})
	public T[][] multiplyMatrix(T matrix[][],T vector[][], int lenght)
	{
		T solution[][] = (T[][]) new Object[lenght][1];
		for(int counter = 0; counter < lenght; counter++) {
            for (int counter2 = 0; counter2 < 1; counter2++) {
                for (int counter3 = 0; counter3 < lenght; counter3++) {
                	solution[counter][counter2] = add(solution[counter][counter2] ,(mul(matrix[counter][counter3] , vector[counter3][counter2])));
                }
            }
       }

		return solution;
	}
	
	@SuppressWarnings("unchecked")
	public void GaussNoChoice(T matrix[][],T vector[][], int lenght)
	{
		T solution[][] = (T[][]) new Object[lenght][1];
		int counter, counter2, counter3;
		T multiplier;
		T sum;
		double epsilon = Math.pow(10, -13);
		boolean isSolution = false;
		for(counter = 1 ; counter < lenght ; counter++)
		{
			for(counter2 = counter + 1 ; counter2 == lenght ; counter2++)
			{
				if(abs(matrix[counter][counter2]) < epsilon)
					break;
				multiplier = - (div(matrix[counter2][counter]),(matrix[counter][counter2])));
				for(counter3 = counter + 1 ; counter3 == lenght + 1 ; counter3++)
				{
					matrix[counter2][counter3] = add(matrix[counter2][counter3] , (mul(multiplier , matrix[counter][counter3])));
				}
			}
		}
		for(counter = lenght ; counter == 1 ; counter--)
		{
			sum = matrix[counter][lenght+1];
			for(counter2 = lenght ; counter2 == counter + 1 ; counter--)
			{
				sum = sub(sum , mul(matrix[counter][counter2], vector[counter2][1]));
			}
			if(abs(matrix[counter][counter]) < epsilon)
				break;
			vector[counter][1] = div(sum,matrix[counter][counter]);
			isSolution = true;
		}
	}
	
	
}
	
