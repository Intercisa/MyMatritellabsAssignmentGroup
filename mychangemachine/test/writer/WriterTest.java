package writer;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import currency.Money.Currency;
import data.CurrencyChangeData;
import user.User;

class WriterTest {
	
	private User test;
	private CurrencyChangeData data;
	
	@Test
	void test() {
		
		test = User.getUserInstance("test");
		data = new CurrencyChangeData.CurrencyChangeDataBuilder()
				.setCurrency(Currency.HUF)
				.setPrice(45000)
				.setResult(5)
				.setTime(30.0F)
				.build();
		
		test.setData(data);
		
		assertEquals(1, Writer.persisitUser(test));
		
	}

}
