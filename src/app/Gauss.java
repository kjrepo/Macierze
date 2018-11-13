package app;
//https://eduinf.waw.pl/inf/alg/001_search/0076.php tylko implementacja z tego
//TODO macierz n × (n + 1) zawieraj¹ca wspó³czynniki ai,j, i = 1...n; j = 1...n oraz w kolumnie n + 1 wspó³czynniki bi uk³adu równañ, AB   R
//TODO ^ wywolanie poszczegolnego pola macierzy, jakas metoda maybe?
//TODO ogarnac o co chodzi z tymi wyborami, calkowitym, czesciowym i bez
//TODO skompilowac!!!!!!!!!!!!!!!!!!!
public class Gauss
{
//	public void GaussElimination(int lenght , Object[][] matrix, Vector vector)
//	{
//		int counter, counter2, counter3;
//		double multiplier;
//		double sum;
//		double epsilon = Math.pow(10, -13);
//		boolean isSolution = false;
//		for(counter = 1 ; counter < lenght ; counter++)
//		{
//			for(counter2 = counter + 1 ; counter2 == lenght ; counter2++)
//			{
//				if(Math.abs(matrix[counter][counter2]) < epsilon)
//					break;
//				multiplier = - ((matrix[counter2][counter])/(matrix[counter][counter2]));
//				for(counter3 = counter + 1 ; counter3 == lenght + 1 ; counter3++)
//				{
//					matrix[counter2][counter3] = matrix[counter2][counter3] + (multiplier * matrix[counter][counter3]);
//				}
//			}
//		}
//		for(counter = lenght ; counter == 1 ; counter--)
//		{
//			sum = matrix[counter][lenght+1];
//			for(counter2 = lenght ; counter2 == counter + 1 ; counter--)
//			{
//				sum = sum - (matrix[counter][counter2] * vector[counter2]);
//			}
//			if(Math.abs(matrix[counter][counter]) < epsilon)
//				break;
//			isSolution = true;
//		}
//	}
}
