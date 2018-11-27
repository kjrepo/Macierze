package app;

//TODO compareTo(T,double){return 1 or return 0}
//TODO opposite(T){return-T}

public class MyMatrix<T> {

	private int height;
	private int width; 
	
	//// nowy poczatek
	public T[][] tab;
	public T[][] vector; 
	private final Class<T> type;
	final int zakres= 65536;

	
	/////

	
	
	
	@SuppressWarnings("unchecked")
	public MyMatrix(int height, int width, Class<T> type) {	
		tab = (T[][]) new Object[width][height];
		vector = (T[][]) new Object[width][1];
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
	
	public void popVector() {
		
		
		TC rand = new TC();
		if(type == Float.class) {
			for(int i = 0; i<width; i++) {
				
					Object o = ((float) rand.nextInt(zakres*2) - zakres)/zakres;
					vector[i][0] = (T) o;
			}
			
		}else if(type == Double.class){
			for(int i = 0; i<width; i++)
				 {
					Object o = ((double) rand.nextInt(zakres*2) - zakres)/zakres;
					vector[i][0] = (T) o;
				}
		}else if(type == TC.class){
			for(int i = 0; i<width; i++)
				 {
					Object o = rand.nextTC();
					vector[i][0] = (T) o;
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
		

		}else if(type == Double.class){
			
			double val = (double)  one;
			if(val > two) {
				return 1;
			}else if(val < two) {
				return -1;
			}else {
				return 0;
			}
		}else if( type == Float.class) {
			float val = (float)  one;
			if(val > two) {
				return 1;
			}else if(val < two) {
				return -1;
			}else {
				return 0;
			}
			
		} 
		return 0;
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
	public int biggestInRowInt(int rowNumber) {
		int ret = 0;
		if(type == Float.class) {
			T biggest = tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((float)tab[rowNumber][i] > (float)biggest) {
					biggest = tab[rowNumber][i];
					ret = i;
				}
				
			}
			return ret;
		}else if(type == Double.class) {
			T biggest = tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((double)tab[rowNumber][i] > (double)biggest) {
					biggest = tab[rowNumber][i];
					ret = i;
				}
			}
			return ret;

		}else if(type == TC.class) {
			TC biggest = (TC) tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				TC current = (TC) tab[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) tab[rowNumber][i];
					ret = i;
				}
			}
			return ret;
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public int biggestInRow(int rowNumber) {
		int res=0;
		if(type == Float.class) {
			T biggest = tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((float)tab[rowNumber][i] > (float)biggest) {
					biggest = tab[rowNumber][i];
					res=i;
				}
				
			}
			return res;
		}else if(type == Double.class) {
			T biggest = tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((double)tab[rowNumber][i] > (double)biggest) {
					biggest = tab[rowNumber][i];
					res=i;
				}
			}
			return res;

		}else if(type == TC.class) {
			TC biggest = (TC) tab[rowNumber][0];
			for(int i = 1; i < height; i++) {
				TC current = (TC) tab[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) tab[rowNumber][i];
					res=i;
				}
			}
			return res;
		}
		return 0;
	}
	
	public void swapRowes(int row1, int row2) {
		T[][] temp = (T[][]) new Object[width][1];
		for(int i = 0; i <width; i++) {
			temp[i][0] = tab[i][row1];
			tab[i][row1] = tab[i][row2];
			tab[i][row2] = temp[i][0];
		}
		
	}
	
	public void swapColumns(int col1, int col2) {
		T[][] temp = (T[][]) new Object[1][width];
		for(int i = 0; i <width; i++) {
			temp[0][i] = tab[col1][i];
			tab[col1][i] = tab[col2][i];
			tab[col2][i] = temp[0][i];
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public int[] biggestInRowColumn(int rowNumber) {
		int[] res = new int[2];
		if(type == Float.class) {
			T biggest = tab[rowNumber][rowNumber];
			for(int i = rowNumber; i < height; i++) {
				if((float)tab[rowNumber][i] > (float)biggest) {
					biggest = tab[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
					}
			}
			for(int i = rowNumber; i< height; i++) {
				if((float)tab[i][rowNumber] > (float)biggest) {
					biggest = tab[i][rowNumber];
					res[0] = i;
					res[1] = rowNumber;
					}
				}
				
			
			return res;
		}else if(type == Double.class) {
			T biggest = tab[rowNumber][rowNumber];
			for(int i = rowNumber; i < height; i++) {
				if((double)tab[rowNumber][i] > (double)biggest) {
					biggest = tab[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
					}
			}
			for(int i = rowNumber; i< height; i++) {
				if((double)tab[i][rowNumber] > (double)biggest) {
					biggest = tab[i][rowNumber];
					res[0] = i;
					res[1] = rowNumber;
					}
			}
			return res;

		}else if(type == TC.class) {
			TC biggest = (TC) tab[rowNumber][0];
			for(int i = rowNumber; i < height; i++) {
				TC current = (TC) tab[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) tab[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
				}
			}
			
			for(int i = rowNumber; i < height; i++) {
				TC current = (TC) tab[i][rowNumber];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) tab[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
				}
			}
			return res;
		}
		return null;
	}
	
	
	
	
	
	
	
	public T[][] multiplyMatrix(T matrix[][],T vector[][], int lenght) // <- potrzebne?
	{
		@SuppressWarnings("unchecked")
		T solution[][] = (T[][]) new Object[lenght][1];
		for(int i = 0; i < width; i++) {
			solution[i][0] = (T) Float.valueOf(0);
		}
		
		for(int counter = 0; counter < lenght; counter++) {
            for (int counter2 = 0; counter2 < 1; counter2++) {
                for (int counter3 = 0; counter3 < lenght; counter3++) {
                	solution[counter][counter2] = add(solution[counter][counter2] ,(mul(matrix[counter][counter3] , vector[counter3][counter2])));
                }
            }
       }

		return solution;
	}
	
//	@SuppressWarnings("unchecked")
//	public T[][] multiplyMatrixTEST()
//	{
//		@SuppressWarnings("unchecked")
//		T solution[][] = (T[][]) new Object[width][1];
//		for(int i = 0; i < width; i++) {
//			solution[i][0] = (T) Float.valueOf(0);
//		}
//		
//		
//		for(int counter = 0; counter < width; counter++) {
//            for (int counter2 = 0; counter2 < 1; counter2++) {
//                for (int counter3 = 0; counter3 < width; counter3++) {
//                	solution[counter][counter2] = add(solution[counter][counter2] ,(mul(tab[counter][counter3] , vector[counter3][counter2])));
//                }
//            }
//       }
//
//		return solution;
//	}
	
	
//	public void GaussNoChoiceTEST() <- To dzia³a (w miare)
//	{
//		int counter, counter2, counter3;
//		T multiplier;
//		T sum;
//		double epsilon = Math.pow(10, -13);
//		boolean isSolution = false;
//		for(counter = 0 ; counter <= width - 2 ; counter++)
//		{
//			for(counter2 = counter + 1 ; counter2 <= width - 1 ; counter2++)
//			{
//				if(cmp(abs(tab[counter][counter2]) , epsilon) == -1)
//					break;
//				multiplier = neg(div((tab[counter2][counter]),(tab[counter][counter2])));
//				for(counter3 = counter + 1 ; counter3 <= width; counter3++)
//				{
//					tab[counter2][counter3] = add(tab[counter2][counter3] , (mul(multiplier , tab[counter][counter3])));
//				}
//			}
//		}
//		for(counter = width - 1 ; counter > 0; counter--)
//		{
//			sum = tab[counter][width];
//			for(counter2 = width - 1 ; counter2 > counter +1  ; counter2--)
//			{
//				sum = sub(sum , mul(tab[counter][counter2], vector[counter2][0]));
//			}
//			if(cmp(abs(tab[counter][counter]) , epsilon) == -1)
//				break;
//			vector[counter][0] = div(sum,tab[counter][counter]);
//			isSolution = true;
//		}
//	}

	public void GaussNoChoice(T matrix[][],T vector[][], int lenght)
	{
		int counter, counter2, counter3;
		T multiplier;
		T sum;
		double epsilon = Math.pow(10, -13);
		boolean isSolution = false;
		for(counter = 0 ; counter <= lenght - 2 ; counter++)
		{
			for(counter2 = counter + 1 ; counter2 <= lenght - 1 ; counter2++)
			{
				if(cmp(abs(matrix[counter][counter2]) , epsilon) == -1)
					break;
				multiplier = neg(div((matrix[counter2][counter]),(matrix[counter][counter2])));
				for(counter3 = counter + 1 ; counter3 <= lenght; counter3++)
				{
					matrix[counter2][counter3] = add(matrix[counter2][counter3] , (mul(multiplier , matrix[counter][counter3])));
				}
			}
		}
		for(counter = lenght - 1 ; counter >= 0; counter--)
		{
			sum = matrix[counter][lenght+1];
			for(counter2 = lenght - 1 ; counter2 >= counter + 1 ; counter--)
			{
				sum = sub(sum , mul(matrix[counter][counter2], vector[counter2][1]));
			}
			if(cmp(abs(matrix[counter][counter]) , epsilon) == -1)
				break;
			vector[counter][1] = div(sum,matrix[counter][counter]);
			isSolution = true;
		}
	}
	
	public void GaussHalfChoice(T matrix[][],T vector[][], int lenght)
	{
		int counter, counter2, counter3;
		T multiplier;
		T sum;
		double epsilon = Math.pow(10, -13);
		boolean isSolution = false;
		int biggestInRow;
		for(counter = 0 ; counter <= lenght - 2 ; counter++)
		{

			for(counter2 = counter + 1 ; counter2 <= lenght - 1 ; counter2++)
			{
				if(cmp(abs(matrix[counter][counter2]) , epsilon) == -1)
					break;
				biggestInRow=biggestInRow(counter);	
				swapRowes(biggestInRow, counter2);
				multiplier = neg(div((matrix[counter2][counter]),(matrix[counter][counter2])));
				for(counter3 = counter + 1 ; counter3 <= lenght; counter3++)
				{
					matrix[counter2][counter3] = add(matrix[counter2][counter3] , (mul(multiplier , matrix[counter][counter3])));
				}
			}
		}
		for(counter = lenght - 1 ; counter >= 0; counter--)
		{
			sum = matrix[counter][lenght+1];
			for(counter2 = lenght - 1 ; counter2 >= counter + 1 ; counter--)
			{
				sum = sub(sum , mul(matrix[counter][counter2], vector[counter2][1]));
			}
			if(cmp(abs(matrix[counter][counter]) , epsilon) == -1)
				break;
			vector[counter][1] = div(sum,matrix[counter][counter]);
			isSolution = true;
		}
	}
	
	public void GaussFullChoice(T matrix[][],T vector[][], int lenght)
	{
		int counter, counter2, counter3;
		T multiplier;
		T sum;
		double epsilon = Math.pow(10, -13);
		boolean isSolution = false;
		int biggestInRowColumn[];
		for(counter = 0 ; counter <= lenght - 2 ; counter++)
		{

			for(counter2 = counter + 1 ; counter2 <= lenght - 1 ; counter2++)
			{
				if(cmp(abs(matrix[counter][counter2]) , epsilon) == -1)
					break;
				biggestInRowColumn=biggestInRowColumn(counter);	
				swapRowes(biggestInRowColumn[0], counter2);
				swapColumns(biggestInRowColumn[1], counter);
				multiplier = neg(div((matrix[counter2][counter]),(matrix[counter][counter2])));
				for(counter3 = counter + 1 ; counter3 <= lenght; counter3++)
				{
					matrix[counter2][counter3] = add(matrix[counter2][counter3] , (mul(multiplier , matrix[counter][counter3])));
				}
			}
		}
		for(counter = lenght - 1 ; counter >= 0; counter--)
		{
			sum = matrix[counter][lenght+1];
			for(counter2 = lenght - 1 ; counter2 >= counter + 1 ; counter--)
			{
				sum = sub(sum , mul(matrix[counter][counter2], vector[counter2][1]));
			}
			if(cmp(abs(matrix[counter][counter]) , epsilon) == -1)
				break;
			vector[counter][1] = div(sum,matrix[counter][counter]);
			isSolution = true;
		}
	}
	
}
	
