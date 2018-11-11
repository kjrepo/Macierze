package app;

public class Calculations {
	public int NWD(int i, int j) //algorytm euklidesa dla liczb naturalnych
	{
		while(i != j)
		{
			if(i < j)
				j = j - i;
			else
				i = i - j;
		}
		return i;
	}
	
//TODO ogarnac mnozenie	
	public Object multiplyMatrix(Object matrix, Vector vector)
	{
		Object solution = matrix;
		
		return solution;
	}
}
