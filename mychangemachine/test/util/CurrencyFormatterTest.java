package util;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import currency.Money;
import currency.Money.Currency;
import machnine.MoneyStrategy;

class CurrencyFormatterTest {

	private Money money;
	
	@Test
	void test() {
		money = MoneyStrategy.getMoney(Currency.USD);
		double[] usdCurrArr = money.getCoinsAndBills();
		int[] expected = new int[] {1,5,10,25,50,100,200,500,1000,2000,5000,10000,50000,100000,500000,1000000};
		int[] actuals= CurrencyFormatter.getFormatedCoinsAndBills(usdCurrArr, money.isThereSmallerThanOne()); 
		
		assertArrayEquals(expected, actuals);
		
	}

}
