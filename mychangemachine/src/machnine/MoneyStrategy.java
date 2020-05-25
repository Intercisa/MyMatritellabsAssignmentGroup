package machnine;


import java.util.HashMap;

import currency.CurrencyBean;
import currency.Money;
import currency.Money.Currency;

public class MoneyStrategy {

	public static Money getMoney(Currency currency) {
		
		try {
			return BeanInitializer.initBean(currency);
		} catch (Exception e) {
			throw new NoSuchCurrencyExists("There is no such currency.");
		}
	}
	
	
	private static class BeanInitializer {
		private static Money money;
		private static HashMap<Currency, double[]>  currencyMap; 
		static{
			currencyMap = new HashMap<Money.Currency, double[]>();
			double[] hufArr  = new double[] { 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000};
			double[] eurArr = new double[] {0.01, 0.02, 0.05,0.1,0.2,0.5,1,2,5,10,20,50,100,200,500};
			double[] usdArr = new double[] {0.01, 0.05, 0.1, 0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000, 5000, 10000};
			currencyMap.put(Currency.HUF, hufArr);
			currencyMap.put(Currency.EUR, eurArr);
			currencyMap.put(Currency.USD, usdArr);
	
		}
			private static Money initBean(Currency currency) {
			money = CurrencyBean.getCurrencyBeanInstance(currencyMap.get(currency), currency);
			return money;
		}
		

	}

}
