package machnine;

public class ChangeSolver {

	//Dynamic Programming Algorithm to solve the coin change problem 

	public static int solveChange(int[] coinsAndBills, int price) {
		int[] dpTable = new int[price + 1];

		dpTable[0] = 0;

		for (int i = 1; i <= price; i++) {
			dpTable[i] = Integer.MAX_VALUE;

			for (int j = 0; j < coinsAndBills.length; j++) {
				
				if (coinsAndBills[j] <= i) {
					dpTable[i] = Math.min(dpTable[i - coinsAndBills[j]] + 1, dpTable[i]);
				}
			}
		}
		return dpTable[price];
	}

}
