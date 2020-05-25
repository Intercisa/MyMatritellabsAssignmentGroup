package currency;

public class CurrencyBean implements Money {

	private Currency currency;
	private double[] coinsAndBills;
	
	private CurrencyBean(double[] coinsAndBills, Currency currency) {
		this.coinsAndBills = coinsAndBills;
		this.currency = currency;
	}
	
	
	public static CurrencyBean getCurrencyBeanInstance(double[] coinsAndBills, Currency currency) { 
		return new CurrencyBean(coinsAndBills, currency);
	}
	
	@Override
	public boolean isThereSmallerThanOne() {
		return coinsAndBills[0] < 1;
	}

	@Override
	public double getSmallestCoin() {
		return coinsAndBills[0];
	}

	@Override
	public double[] getCoinsAndBills() {
		return coinsAndBills;
	}

	@Override
	public Currency getCurrency() {
		return currency;
	}

}
