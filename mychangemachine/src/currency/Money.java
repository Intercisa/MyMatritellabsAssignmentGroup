package currency;

public interface Money {	
	
	public enum Currency {
		HUF, EUR, USD
	}
	
	public boolean isThereSmallerThanOne();
	public double getSmallestCoin();
 	public double[] getCoinsAndBills();
 	public Currency getCurrency();
}
