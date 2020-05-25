package main;

import machnine.Machine;
import user.User;

/*
 * 	generate a random price in a random currency
 * 	tell the least amount of coins/bills by which you can pay the price accurately
 * 		(!be careful: there are different coins and bills for every currency,
 * 			 for example in Hungarian Forints you cannot pay exactly 21)
 * 
 *	use at least two currencies: HUF and EUR
 *		but the program should be easily extensible
 *	
 *	measure the time of calculation
 *	save the time, the price and the currency of these calculation results into files, using the name of the user as file name.
 *
 *
 */

public class Main {

	public static void main(String[] args) {
		
 		User anna = User.getUserInstance("anna"); 
		Machine.startMachine(anna).persist();
	
	}
}
