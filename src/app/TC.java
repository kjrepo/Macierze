package app;

import java.math.BigInteger;
import java.util.Random;

public class TC extends Random {

	static final long serialVersionUID = 1L;
	
	public BigInteger top;
	public BigInteger bot;
	Random rnd; 
	/////
	BigInteger RangeBot;
	BigInteger RangeTop;
	
	public void nextTC() {
		rnd = new Random();
		top=BigInteger.valueOf(2);
		
		int aaa = rnd.nextInt(55); /// losuje ile bitow ma mianownik
		top= top.pow(rnd.nextInt(63)+1); /// losuje jaka wartosc odejme od wylosowanej liczby (aby powstaly l ujemne)
		
		this.bot = new BigInteger(aaa+9, rnd).subtract(top); //los
		RangeTop= bot.multiply(BigInteger.valueOf(65535));	// wyznaczam przedzial w kotrych musi sie miescic licznik zeby ulamek byl od -2^16 do2^16-1
		RangeBot= bot.multiply(BigInteger.valueOf(-65536));
		BigInteger sum = RangeBot.subtract(RangeTop).abs();	// badam jaka dlugosc ma ten przedzial 
		int cmp;
		do {
			this.top = new BigInteger(RangeTop.bitLength(), rnd); //losuje liczbe w miare z przedzialu
			cmp = top.compareTo(sum);
		}while(cmp != -1 ); //gdyby jednak nie byla z przedzialu to powtarzam
		top = top.subtract(RangeTop.abs()); // wracam do wartosci sprzed badania dlugosci przedzialu
	}
	
	
	
}
