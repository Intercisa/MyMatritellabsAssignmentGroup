package util;

/*
 * Util class for  
 * 
 */

public class CurrencyFormatter {
	
	public static int[] getFormatedCoinsAndBills(double[] arr, boolean isSmaller) {
		int[] res = new int[arr.length];
		int m = isSmaller?100:1;
 		
		for (int i = 0; i < arr.length; i++) 
			res[i] = (int)(arr[i]*m);
		
		return res;
	}
}
