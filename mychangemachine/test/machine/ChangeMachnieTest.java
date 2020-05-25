package machine;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import currency.Money;
import currency.Money.Currency;
import machnine.ChangeSolver;
import machnine.MoneyStrategy;
import util.CurrencyFormatter;

class ChangeMachnieTest {
	
	private Money money;
	
	
	@Test
	void test_1() {
		
		
		money = MoneyStrategy.getMoney(Currency.HUF);
		int[] arr = CurrencyFormatter.getFormatedCoinsAndBills(
				money.getCoinsAndBills(), money.isThereSmallerThanOne());
		
		assertEquals(2, ChangeSolver.solveChange(arr, 2200));
	}
	
	@Test
	void test_2() {
		money = MoneyStrategy.getMoney(Currency.EUR);
		int[] arr = CurrencyFormatter.getFormatedCoinsAndBills(
				money.getCoinsAndBills(), money.isThereSmallerThanOne());
		assertEquals(5, ChangeSolver.solveChange(arr, 533));
	}
	
	@Test
	void test_3() {
		money = MoneyStrategy.getMoney(Currency.EUR);
		int[] arr = CurrencyFormatter.getFormatedCoinsAndBills(
				money.getCoinsAndBills(), money.isThereSmallerThanOne());
		assertEquals(6, ChangeSolver.solveChange(arr, 279));
	}
	
	@Test
	void test_4() {
		money = MoneyStrategy.getMoney(Currency.EUR);
		int[] arr = CurrencyFormatter.getFormatedCoinsAndBills(
				money.getCoinsAndBills(), money.isThereSmallerThanOne());
		assertEquals(6, ChangeSolver.solveChange(arr, 444));
	}
	
}
