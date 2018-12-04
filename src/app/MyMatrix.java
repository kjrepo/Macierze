package app;

import java.io.PrintWriter;

//TODO compareTo(T,double){return 1 or return 0}
//TODO opposite(T){return-T}

public class MyMatrix<T> {

	private int height;
	private int width; 
	
	//// nowy poczatek
	public T[][] tab;
	public T[][] vector; 
	public T[][] wynik;
	public T[][] temp;
	public T[][] tempV;

	public T[][] wynikH;
	public T[][] tempH;
	public T[][] tempVH;
	public T[][] vectorH; 

	
	public T[][] wynikF;
	public T[][] tempF;
	public T[][] tempVF;
	public T[][] vectorF; 

	
	private final Class<T> type;
	final int zakres= 65536;

	
	/////

	@SuppressWarnings("unchecked")
	public void chceck() {
		T wyniczek = (T) new Object();
		for(int i = 0 ; i < width ; i++) {
			if (i==0)
				wyniczek = mul(temp[0][0],vector[0][0]);
			else
				wyniczek = add(wyniczek,mul(temp[0][i],vector[i][0]));
		}
		System.out.println(abs(sub(tempV[0][0],wyniczek)));
	}

	@SuppressWarnings("unchecked")
	public void chceckf() {
		T wyniczekf = (T) new Object();
		for(int i = 0 ; i < width ; i++) {
			if (i==0)
				wyniczekf = mul(tempF[0][0],vectorF[0][0]);
			else
				wyniczekf = add(wyniczekf,mul(tempF[0][i],vectorF[i][0]));
		}
		System.out.println(abs(sub(tempVF[0][0],wyniczekf)));
	}
	
	@SuppressWarnings("unchecked")
	public void chceckh() {
		T wyniczekh = (T) new Object();
		for(int i = 0 ; i < width ; i++) {
			if (i==0)
				wyniczekh = mul(tempH[0][0],vectorH[0][0]);
			else
				wyniczekh = add(wyniczekh,mul(tempH[0][i],vectorH[i][0]));
		}
		System.out.println(abs(sub(tempVH[0][0],wyniczekh)));
	}
	
	@SuppressWarnings("unchecked")
	public MyMatrix(int height, int width, Class<T> type) {	
		tab = (T[][]) new Object[width][height];
		temp = (T[][]) new Object[width][height];
		tempV = (T[][]) new Object[width][1];
		vector = (T[][]) new Object[width][1];
		wynik = (T[][]) new Object[width][height+1];
		
		tempVH = (T[][]) new Object[width][1];
		tempH = (T[][]) new Object[width][height];
		wynikH = (T[][]) new Object[width][height+1];
		vectorH = (T[][]) new Object[width][1];

		
		tempVF = (T[][]) new Object[width][1];
		tempF = (T[][]) new Object[width][height];
		wynikF = (T[][]) new Object[width][height+1];
		vectorF = (T[][]) new Object[width][1];

		
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
					wynik[i][j] = (T) o;
					temp[i][j] = (T) o;
					
					wynikH[i][j] = (T) o;
					tempH[i][j] = (T) o;
					
					wynikF[i][j] = (T) o;
					tempF[i][j] = (T) o;

				}
			
		}else if(type == Double.class){
			for(int i = 0; i<width; i++)
				for(int j = 0; j < height; j++) {
					Object o = ((double) rand.nextInt(zakres*2) - zakres)/zakres;
					tab[i][j] = (T) o;
					wynik[i][j] = (T) o;
					temp[i][j] = (T) o;
					
					wynikH[i][j] = (T) o;
					tempH[i][j] = (T) o;
					
					wynikF[i][j] = (T) o;
					tempF[i][j] = (T) o;

				}
		}else if(type == TC.class){
			for(int i = 0; i<width; i++)
				for(int j = 0; j < height; j++) {
					Object o = rand.nextTC();
					tab[i][j] = (T) o;
					wynik[i][j] = (T) o;
					temp[i][j] = (T) o;

					wynikH[i][j] = (T) o;
					tempH[i][j] = (T) o;
					
					wynikF[i][j] = (T) o;
					tempF[i][j] = (T) o;
					
				}
		}
		
		
	}
	
	public void popTest() {
				double a = -2;
				temp[0][0] = (T) (Object) (float) 4.0;
				temp[0][1] = (T) (Object) (float)a;
				temp[0][2] = (T) (Object) (float)4.0;
				temp[0][3] = (T) (Object)(float) (-2.0);
				tempV[0][0] = (T) (Object) (float)8.0;
	
				temp[1][0] = (T) (Object)(float) 3.0;
				temp[1][1] = (T) (Object) (float)1.0;
				temp[1][2] = (T) (Object) (float)4.0;
				temp[1][3] = (T) (Object) (float)2.0;
				tempV[1][0] = (T) (Object) (float)7.0;
				
				temp[2][0] = (T) (Object)(float) 2.0;
				temp[2][1] = (T) (Object)(float) 4.0;
				temp[2][2] = (T) (Object)(float) 2.0;
				temp[2][3] = (T) (Object)(float) 1.0;
				tempV[2][0] = (T) (Object) (float)10.0;
				
				temp[3][0] = (T) (Object)(float) 2.0;
				temp[3][1] = (T) (Object)(float) (-2.0);
				temp[3][2] = (T) (Object)(float) 4.0;
				temp[3][3] = (T) (Object)(float) 2.0;
				tempV[3][0] = (T) (Object)(float) 2.0;
				
				
				
				///
				
				wynik[0][0] = (T) (Object) (float) 4.0;
				wynik[0][1] = (T) (Object) (float)a;
				wynik[0][2] = (T) (Object) (float)4.0;
				wynik[0][3] = (T) (Object)(float) (-2.0);
				wynik[0][4] = (T) (Object) (float)8.0;
	
				wynik[1][0] = (T) (Object)(float) 3.0;
				wynik[1][1] = (T) (Object) (float)1.0;
				wynik[1][2] = (T) (Object) (float)4.0;
				wynik[1][3] = (T) (Object) (float)2.0;
				wynik[1][4] = (T) (Object) (float)7.0;
				
				wynik[2][0] = (T) (Object)(float) 2.0;
				wynik[2][1] = (T) (Object)(float) 4.0;
				wynik[2][2] = (T) (Object)(float) 2.0;
				wynik[2][3] = (T) (Object)(float) 1.0;
				wynik[2][4] = (T) (Object) (float)10.0;
				
				wynik[3][0] = (T) (Object)(float) 2.0;
				wynik[3][1] = (T) (Object)(float) (-2.0);
				wynik[3][2] = (T) (Object)(float) 4.0;
				wynik[3][3] = (T) (Object)(float) 2.0;
				wynik[3][4] = (T) (Object)(float) 2.0;
	}
	
	
	
	public void popVector() {
		
		
		TC rand = new TC();
		if(type == Float.class) {
			for(int i = 0; i<width; i++) {
				
					Object o = ((float) rand.nextInt(zakres*2) - zakres)/zakres;
					vector[i][0] = (T) o;
					wynik[i][width] = (T) o;
					wynikF[i][width] = (T) o;

					wynikH[i][width] = (T) o;

					tempV[i][0] = (T) o;

					tempVH[i][0] = (T) o;
					
					tempVF[i][0] = (T) o;


			}
			
		}else if(type == Double.class){
			for(int i = 0; i<width; i++)
				 {
					Object o = ((double) rand.nextInt(zakres*2) - zakres)/zakres;
					vector[i][0] = (T) o;
					wynik[i][width] = (T) o;
					wynikF[i][width] = (T) o;

					wynikH[i][width] = (T) o;
					tempV[i][0] = (T) o;
					tempVH[i][0] = (T) o;
					
					tempVF[i][0] = (T) o;

				}
		}else if(type == TC.class){
			for(int i = 0; i<width; i++)
				 {
					Object o = rand.nextTC();
					vector[i][0] = (T) o;
					wynik[i][width] = (T) o;
					wynikF[i][width] = (T) o;

					wynikH[i][width] = (T) o;
					tempV[i][0] = (T) o;
					tempVH[i][0] = (T) o;
					
					tempVF[i][0] = (T) o;
				}
		}
		
		
	}
	
	public void zeroVector() {
		
		
		TC rand = new TC();
		if(type == Float.class) {
			for(int i = 0; i<width; i++) {
				
					Object o = (float) 0;
					vector[i][0] = (T) o;
			}
			
		}else if(type == Double.class){
			for(int i = 0; i<width; i++)
				 {
					Object o = (double) 0;
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
	public int biggestInRowIntH(int rowNumber) {
		int ret = 0;
		if(type == Float.class) {
			T biggest = wynikH[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((float)wynikH[rowNumber][i] > (float)biggest) {
					biggest = wynikH[rowNumber][i];
					ret = i;
				}
				
			}
			return ret;
		}else if(type == Double.class) {
			T biggest = wynikH[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((double)wynikH[rowNumber][i] > (double)biggest) {
					biggest = wynikH[rowNumber][i];
					ret = i;
				}
			}
			return ret;

		}else if(type == TC.class) {
			TC biggest = (TC) wynikH[rowNumber][0];
			for(int i = 1; i < height; i++) {
				TC current = (TC) wynikH[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikH[rowNumber][i];
					ret = i;
				}
			}
			return ret;
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public int biggestInRowH(int rowNumber) {
		int res=0;
		if(type == Float.class) {
			T biggest = wynikH[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((float)wynikH[rowNumber][i] > (float)biggest) {
					biggest = wynikH[rowNumber][i];
					res=i;
				}
				
			}
			return res;
		}else if(type == Double.class) {
			T biggest = wynikH[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((double)wynikH[rowNumber][i] > (double)biggest) {
					biggest = wynikH[rowNumber][i];
					res=i;
				}
			}
			return res;

		}else if(type == TC.class) {
			TC biggest = (TC) wynikH[rowNumber][0];
			for(int i = 1; i < height; i++) {
				TC current = (TC) wynikH[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikH[rowNumber][i];
					res=i;
				}
			}
			return res;
		}
		return 0;
	}
	
	public void swapColumnsH(int row1, int row2) {
		T[][] temp = (T[][]) new Object[width][1];
		for(int i = 0; i <width; i++) {
			temp[i][0] = wynikH[i][row1];
			wynikH[i][row1] = wynikH[i][row2];
			wynikH[i][row2] = temp[i][0];
			
			//
			

		}
		
	}
	
	
	
	public void swapRowesH(int col1, int col2) {
		T[][] temp = (T[][]) new Object[1][width+1];
		for(int i = 0; i <width+1; i++) {
			temp[0][i] = wynikH[col1][i];
			wynikH[col1][i] = wynikH[col2][i];
			wynikH[col2][i] = temp[0][i];
			
			//swap tablicy sprawdzjacej
		}
		for(int i = 0; i <width; i++) {
			temp[0][i] = tempH[col1][i];
			tempH[col1][i] = tempH[col2][i];
			tempH[col2][i] = temp[0][i];
		}
		temp[0][0] = tempVH[col1][0];
		tempVH[col1][0] = tempVH[col2][0];
		tempVH[col2][0] = temp[0][0];
		
		
	}
	
	@SuppressWarnings("unchecked")
	public int[] biggestInRowColumnH(int rowNumber) {
		int[] res = new int[2];
		if(type == Float.class) {
			T biggest = wynikH[rowNumber][rowNumber];
			for(int i = rowNumber; i < height; i++) {
				if((float)wynikH[rowNumber][i] > (float)biggest) {
					biggest = wynikH[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
					}
			}
			for(int i = rowNumber; i< height; i++) {
				if((float)wynikH[i][rowNumber] > (float)biggest) {
					biggest = wynikH[i][rowNumber];
					res[0] = i;
					res[1] = rowNumber;
					}
				}
				
			
			return res;
		}else if(type == Double.class) {
			T biggest = wynikH[rowNumber][rowNumber];
			for(int i = rowNumber; i < height; i++) {
				if((double)wynikH[rowNumber][i] > (double)biggest) {
					biggest = wynikH[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
					}
			}
			for(int i = rowNumber; i< height; i++) {
				if((double)wynikH[i][rowNumber] > (double)biggest) {
					biggest = wynikH[i][rowNumber];
					res[0] = i;
					res[1] = rowNumber;
					}
			}
			return res;

		}else if(type == TC.class) {
			TC biggest = (TC) wynikH[rowNumber][0];
			for(int i = rowNumber; i < height; i++) {
				TC current = (TC) wynikH[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikH[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
				}
			}
			
			for(int i = rowNumber; i < height; i++) {
				TC current = (TC) wynikH[i][rowNumber];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikH[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
				}
			}
			return res;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public int biggestInRowInt(int rowNumber) {
		int ret = 0;
		if(type == Float.class) {
			T biggest = wynikF[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((float)wynikF[rowNumber][i] > (float)biggest) {
					biggest = wynikF[rowNumber][i];
					ret = i;
				}
				
			}
			return ret;
		}else if(type == Double.class) {
			T biggest = wynikF[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((double)wynikF[rowNumber][i] > (double)biggest) {
					biggest = wynikF[rowNumber][i];
					ret = i;
				}
			}
			return ret;

		}else if(type == TC.class) {
			TC biggest = (TC) wynikF[rowNumber][0];
			for(int i = 1; i < height; i++) {
				TC current = (TC) wynikF[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikF[rowNumber][i];
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
			T biggest = wynikF[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((float)wynikF[rowNumber][i] > (float)biggest) {
					biggest = wynikF[rowNumber][i];
					res=i;
				}
				
			}
			return res;
		}else if(type == Double.class) {
			T biggest = wynikF[rowNumber][0];
			for(int i = 1; i < height; i++) {
				if((double)wynikF[rowNumber][i] > (double)biggest) {
					biggest = wynikF[rowNumber][i];
					res=i;
				}
			}
			return res;

		}else if(type == TC.class) {
			TC biggest = (TC) wynikF[rowNumber][0];
			for(int i = 1; i < height; i++) {
				TC current = (TC) wynikF[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikF[rowNumber][i];
					res=i;
				}
			}
			return res;
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public int biggestInColumnH(int rowNumber) {
		int res=0;
		if(type == Float.class) {
			T biggest = wynikH[0][rowNumber];
			for(int i = 0; i < height; i++) {
				if((float)wynikH[i][rowNumber] > (float)biggest) {
					biggest = wynikH[i][rowNumber];
					res=i;
				}
				
			}
			return res;
		}else if(type == Double.class) {
			T biggest = wynikH[0][rowNumber];
			for(int i = 0; i < height; i++) {
				if((double)wynikH[i][rowNumber] > (double)biggest) {
					biggest = wynikH[i][rowNumber];
					res=i;
				}
			}
			return res;

		}else if(type == TC.class) {
			TC biggest = (TC) wynikH[0][rowNumber];
			for(int i = 1; i < height; i++) {
				TC current = (TC) wynikH[i][rowNumber];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikH[i][rowNumber];
					res=i;
				}
			}
			return res;
		}
		return 0;
	}
	
	public void swapRowes(int row1, int row2) {
		T[][] temp = (T[][]) new Object[1][width+1];
		for(int i = 0; i <width+1; i++) {
			temp[0][i] = wynikF[row1][i];
			wynikF[row1][i] = wynikF[row2][i];
			wynikF[row2][i] = temp[0][i];
			
			//
			

		}
		for(int i = 0; i <width; i++) {
			temp[0][i] = tempF[row1][i];
			tempF[row1][i] = tempF[row2][i];
			tempF[row2][i] = temp[0][i];
		}
		
		temp[0][0] = tempVF[row1][0];
		tempVF[row1][0] = tempVF[row2][0];
		tempVF[row2][0] = temp[0][0];
	}
	
	public void swapColumns(int col1, int col2) {
		T[][] temp = (T[][]) new Object[width][1];
		for(int i = 0; i <width; i++) {
			temp[i][0] = wynikF[i][col1];
			wynikF[i][col1] = wynikF[i][col2];
			wynikF[i][col2] = temp[i][0];
			
			temp[i][0] = tempF[i][col1];
			tempF[i][col1] = tempF[i][col2];
			tempF[i][col2] = temp[i][0];
			
		}
		
	}
	

	
	
	
	@SuppressWarnings("unchecked")
	public int[] biggestInRowColumn(int rowNumber) {
		int[] res = new int[2];
		if(type == Float.class) {
			T biggest = wynikF[rowNumber][rowNumber];
			res[0]=rowNumber;
			res[1]=rowNumber;
			for(int i = rowNumber; i < height; i++) {
				if((float)wynikF[rowNumber][i] > (float)biggest) {
					biggest = wynikF[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
					}
			}
			for(int i = rowNumber; i< height; i++) {
				if((float)wynikF[i][rowNumber] > (float)biggest) {
					biggest = wynikF[i][rowNumber];
					res[0] = i;
					res[1] = rowNumber;
					}
				}
				
			
			return res;
		}else if(type == Double.class) {
			T biggest = wynikF[rowNumber][rowNumber];
			res[0]=rowNumber;
			res[1]=rowNumber;
			for(int i = rowNumber; i < height; i++) {
				if((double)wynikF[rowNumber][i] > (double)biggest) {
					biggest = wynikF[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
					}
			}
			for(int i = rowNumber; i< height; i++) {
				if((double)wynikF[i][rowNumber] > (double)biggest) {
					biggest = wynikF[i][rowNumber];
					res[0] = i;
					res[1] = rowNumber;
					}
			}
			return res;

		}else if(type == TC.class) {
			TC biggest = (TC) wynikF[rowNumber][rowNumber];
			res[0]=rowNumber;
			res[1]=rowNumber;
			for(int i = rowNumber; i < height; i++) {
				TC current = (TC) wynikF[rowNumber][i];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikF[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
				}
			}
			
			for(int i = rowNumber; i < height; i++) {
				TC current = (TC) wynikF[i][rowNumber];
				
				if(current.aprox > biggest.aprox) {
					biggest = (TC) wynikF[rowNumber][i];
					res[0] = rowNumber;
					res[1] = i;
				}
			}
			return res;
		}
		return null;
	}
	
	
	

	
	
	
	public void multiplyMatrix() // <- potrzebne?
	{
		@SuppressWarnings("unchecked")
		T solution[][] = (T[][]) new Object[width][1];
		for(int i = 0; i < width; i++) {
			solution[i][0] = (T) Float.valueOf(0);
		}
		
		for(int counter = 0; counter < width; counter++) {
            for (int counter2 = 0; counter2 < 1; counter2++) {
                for (int counter3 = 0; counter3 < width; counter3++) {
                	solution[counter][counter2] = add(solution[counter][counter2] ,(mul(tab[counter][counter3] , vector[counter3][counter2])));
                }
            }
       }

		for(int i = 0; i < width ; i++) {
			for(int j = 0; j < width +1 ; j++) {
				if(j < width) {
				wynik[i][j] = tab[i][j];
				}else {
					wynik[i][j] = solution[i][0];
				}
			}
		}
	}
	


	public void GaussNoChoice()
	{
		int counter, counter2, counter3;
		T multiplier;
		T sum;
		double epsilon = Math.pow(10, -14);
		boolean isSolution = false;
		for(counter = 0 ; counter <= width - 2 ; counter++)
		{
			for(counter2 = counter + 1 ; counter2 <= width -1 ; counter2++)
			{
				if(cmp(abs(wynik[counter][counter]) , epsilon) == -1)
					break;
				multiplier = neg(div((wynik[counter2][counter]),(wynik[counter][counter])));
				for(counter3 = counter + 1 ; counter3 <= width ; counter3++)
				{
					wynik[counter2][counter3] = add(wynik[counter2][counter3] , (mul(multiplier , wynik[counter][counter3])));
				}
			}
		}
		for(counter = width - 1 ; counter >= 0; counter--)
		{
			sum = wynik[counter][width];
			for(counter2 = width - 1 ; counter2 >= counter + 1 ; counter2--)
			{
				sum = sub(sum , mul(wynik[counter][counter2], vector[counter2][0]));
			}
			if(cmp(abs(wynik[counter][counter]) , epsilon) == -1)
				break;
			vector[counter][0] = div(sum,wynik[counter][counter]);
			isSolution = true;
		}
	}
	
	public void GaussHalfChoice()
	{
		int counter, counter2, counter3;
		T multiplier;
		T sum;
		double epsilon = Math.pow(10, -14);
		boolean isSolution = false;
		int biggestInColumn;
		for(counter = 0 ; counter <= width - 2 ; counter++)
		{
			biggestInColumn=biggestInColumnH(counter);	
			swapRowesH(biggestInColumn, counter);
			
			for(counter2 = counter + 1 ; counter2 <= width -1 ; counter2++)
			{
				if(cmp(abs(wynikH[counter][counter]) , epsilon) == -1)
					break;
				multiplier = neg(div((wynikH[counter2][counter]),(wynikH[counter][counter])));
				for(counter3 = counter + 1 ; counter3 <= width ; counter3++)
				{
					wynikH[counter2][counter3] = add(wynikH[counter2][counter3] , (mul(multiplier , wynikH[counter][counter3])));
				}
			}
		}
		for(counter = width - 1 ; counter >= 0; counter--)
		{
			sum = wynikH[counter][width];
			for(counter2 = width - 1 ; counter2 >= counter + 1 ; counter2--)
			{
				sum = sub(sum , mul(wynikH[counter][counter2], vectorH[counter2][0]));
			}
			if(cmp(abs(wynikH[counter][counter]) , epsilon) == -1)
				break;
			vectorH[counter][0] = div(sum,wynikH[counter][counter]);
			isSolution = true;
		}
	}
	public void GaussFullChoice()
	{
		int counter, counter2, counter3;
		T multiplier;
		T sum;
		double epsilon = Math.pow(10, -14);
		boolean isSolution = false;
		int biggestInRowColumn[];
		for(counter = 0 ; counter <= width - 2 ; counter++)
		{

			biggestInRowColumn=biggestInRowColumn(counter);	
			swapRowes(biggestInRowColumn[0], counter);
			swapColumns(biggestInRowColumn[1], counter);
			for(counter2 = counter + 1 ; counter2 <= width -1 ; counter2++)
			{
				if(cmp(abs(wynikF[counter][counter]) , epsilon) == -1)
					break;
				multiplier = neg(div((wynikF[counter2][counter]),(wynikF[counter][counter])));
				for(counter3 = counter + 1 ; counter3 <= width ; counter3++)
				{
					wynikF[counter2][counter3] = add(wynikF[counter2][counter3] , (mul(multiplier , wynikF[counter][counter3])));
				}
			}
		}
		for(counter = width - 1 ; counter >= 0; counter--)
		{
			sum = wynikF[counter][width];
			for(counter2 = width - 1 ; counter2 >= counter + 1 ; counter2--)
			{
				sum = sub(sum , mul(wynikF[counter][counter2], vectorF[counter2][0]));
			}
			if(cmp(abs(wynikF[counter][counter]) , epsilon) == -1)
				break;
			vectorF[counter][0] = div(sum,wynikF[counter][counter]);
			isSolution = true;
		}
	}
}
	
