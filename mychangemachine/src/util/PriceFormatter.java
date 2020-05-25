package util;

import java.util.Random;

import currency.Money;
import currency.Money.Currency;
import machnine.MoneyStrategy;

/*
 * Util class for things like getting the random PRICE for the specific Currency. 
 * 
 */


public class PriceFormatter {
private static Random random;
	
	public static double PRICE;
	static {
		final int lower = 0;
		final int upper = 50000;
		final double diff = upper - lower;
		random =  new Random();
		PRICE = random.nextDouble() * diff;
		PRICE = Math.round(PRICE * 100d) / 100d; //set to two decimal 
	}
	
	private static long multiplyUp(double num) {
		return Math.round(num*100);
	}
	
	private static long formatPrice(long smallest) {
		return Math.round((PRICE/smallest))*smallest;
	}
	
	public static int[] getFormatedCoinsAndBills(double[] arr, boolean isSmaller) {
		int[] res = new int[arr.length];
		int m = isSmaller?100:1;
 		
		for (int i = 0; i < arr.length; i++) 
			res[i] = (int)(arr[i]*m);
		
		return res;
	}
	
	public static int getPriceoutOfCurrency(Currency currency){
		
		Money money =  MoneyStrategy.getMoney(currency);
		long smallest;
		if(money.isThereSmallerThanOne()) {
			smallest = multiplyUp(money.getSmallestCoin());
			long priceInLong = multiplyUp(PRICE);
			priceInLong = formatPrice(smallest);
			
			return (int)priceInLong;
		}
			
			smallest = (long) money.getSmallestCoin();
			PRICE = (int)formatPrice(smallest);
			return (int)formatPrice(smallest);
	}
}
