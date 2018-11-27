package app;

import java.math.BigInteger;
import java.util.Random;


public class TC extends Random{ // Czy dziedziczenie po Random jest ok? Jest niezbyt eleganckie, trzeba sie zastanowic czy moga za to zostac uciete punkty

	static final long serialVersionUID = 1L;
	
	public BigInteger top;
	public BigInteger bot;
	public double aprox;

	public TC(BigInteger top, BigInteger bot, double aprox) {
	super();
	this.top = top;
	this.bot = bot;
	this.aprox = aprox;
}
	
	public TC(BigInteger top, BigInteger bot) {
		super();
		this.top = top;
		this.bot = bot;
	}

	public TC() {
	}
	
	
	public static double getTop (TC number) {
		
		return number.aprox;
	}
	
//	public void aprox(TC number) {
//		this.aprox = number.top.doubleValue() / number.bot.doubleValue();
//	}
	
	

	public TC nextTC() {
		Random rnd; 
//		BigInteger RangeBot;
//		BigInteger RangeTop;
//		
		rnd = new Random();
//		RangeTop=BigInteger.valueOf(2);
		
		int aaa = rnd.nextInt(55); /// losuje ile bitow ma mianownik
//	RangeTop= RangeTop.pow(rnd.nextInt(63)+1); /// losuje jaka wartosc odejme od wylosowanej liczby (aby powstaly l ujemne)
		
		this.top = new BigInteger(aaa+8, rnd);
//		RangeTop= bot.multiply(BigInteger.valueOf(65535));	// wyznaczam przedzial w kotrych musi sie miescic licznik zeby ulamek byl od -2^16 do2^16-1
//		RangeBot= bot.multiply(BigInteger.valueOf(-65536));
//		BigInteger sum = RangeBot.subtract(RangeTop).abs();	// badam jaka dlugosc ma ten przedzial 
		int cmp;
		do {
//			this.top = new BigInteger(RangeTop.bitLength(), rnd); //losuje liczbe w miare z przedzialu
			this.bot = new BigInteger(aaa+9, rnd); //los

			cmp = top.compareTo(bot);
		}while(cmp != -1 ); //gdyby jednak nie byla z przedzialu to powtarzam
//		top = top.subtract(RangeTop.abs()); // wracam do wartosci sprzed badania dlugosci przedzialu
		
		if(rnd.nextBoolean())
			bot = bot.not();
		if(rnd.nextBoolean())
			top = top.not();
		
		BigInteger nwd = nwd(bot,top);
		top = top.divide(nwd);
		bot = bot.divide(nwd);
		this.aprox = top.doubleValue() / bot.doubleValue();
		
		
		TC answ = new TC(top, bot, aprox);
		return answ;
//	
		
		
		
		
		}
	
	public String toString() {
		return String.valueOf(aprox);
	}
	
	static public TC add(TC one, TC two) {
		TC temp = new TC(one.top, one.bot);
		one.bot = one.bot.multiply(two.bot);
		one.top = one.top.multiply(two.bot);
		two.bot = two.bot.multiply(temp.bot);
		two.top = two.top.multiply(temp.bot);
		
		temp = new TC(two.top.add(one.top), one.bot);
		BigInteger nwd = nwd(temp.top, temp.bot);
		temp.top = temp.top.divide(nwd);
		temp.bot = temp.bot.divide(nwd);
		return temp ;

	}
	
	static public TC sub(TC one, TC two) {
		TC temp = new TC(one.top, one.bot);
		one.bot = one.bot.multiply(two.bot);
		one.top = one.top.multiply(two.bot);
		two.bot = two.bot.multiply(temp.bot);
		two.top = two.top.multiply(temp.bot);
		
		temp = new TC(one.top.subtract(two.top), one.bot);
		BigInteger nwd = nwd(temp.top, temp.bot);
		temp.top = temp.top.divide(nwd);
		temp.bot = temp.bot.divide(nwd);
		return temp ;

	}
	
	static public TC mul(TC one, TC two) {
		TC temp = new TC();
		temp.bot = one.bot.multiply(two.bot);
		temp.top = one.top.multiply(two.top);

		
		temp = new TC(temp.top, temp.bot);
		BigInteger nwd = nwd(temp.top, temp.bot);
		temp.top = temp.top.divide(nwd);
		temp.bot = temp.bot.divide(nwd);
		return temp ;

	}
	
	static public TC div(TC one, TC two) {
		BigInteger temp;
		temp = two.bot;
		two.bot = two.top;
		two.top = temp;
		
		
		
		return mul(one,two) ;

	}
	
	static public TC abs(TC one) {
		one.bot = one.bot.abs();
		one.top = one.top.abs();
		return one;
	}
	
	
	
	
	
	
	private static BigInteger nwd(BigInteger one, BigInteger two) {
		one = one.abs();
		two  = two.abs();
		while(one.compareTo(two)!=0){
			if(one.compareTo(two)==-1) {
				two = two.subtract(one);
			}else {
				one = one.subtract(two);
			}
		}
		return one;
	}
	
	
}
