package machnine;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import currency.Money;
import currency.Money.Currency;
import data.CurrencyChangeData;
import user.User;
import util.CurrencyFormatter;
import util.PriceFormatter;
import writer.CMWritable;

public class Machine {
	
	private Machine() {}
	
	private static Currency currency = getRandomCurrency();
	private static Money money = MoneyStrategy.getMoney(currency);
	
	public static CMWritable startMachine(User user) {
		
		int price = PriceFormatter.getPriceoutOfCurrency(currency);
		
		long startTime = System.nanoTime();
		
		int res = ChangeSolver.solveChange(
				CurrencyFormatter.getFormatedCoinsAndBills(
						money.getCoinsAndBills(), 
						money.isThereSmallerThanOne()), price);
		
		long endTime = System.nanoTime();

		float duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		
		CurrencyChangeData data = new CurrencyChangeData.CurrencyChangeDataBuilder()
				.setCurrency(currency)
				.setPrice(PriceFormatter.PRICE)
				.setTime(duration)
				.setResult(res).build();
		
		user.setData(data);
		
		return user;

	}	
	
	//helper method for random currency 
	private static Currency getRandomCurrency() {
		Random random = new Random();
		Currency[] currencys = Currency.values();
		return currencys[random.nextInt(currencys.length)];
	}
	
	} 
	

