package data;

import currency.Money.Currency;

public class CurrencyChangeData implements Data {
	private Currency currency;
	private double price;
	private float time;
	private int result;
	
	private StringBuilder sb;
	
	public Currency getCurrency() {return currency;}
	public double getPrice() {return price;}
	public float getTime() {return time;}
	public int getResult() {return result;}

	
	@Override
	public String getInfo() {
		this.sb = new StringBuilder();
		String colon = ", ";
		return sb.append(colon)
				.append(this.getCurrency())
				.append(colon)
				.append(this.getTime())
				.append(" ms")
				.append(colon)
				.append("the price was :")
				.append(this.getPrice())
				.append(" the result is ")
				.append(this.getResult())
				.toString();
		
	}
	
	
	private CurrencyChangeData (CurrencyChangeDataBuilder builder) {
		this.currency = builder.currency;
		this.price = builder.price;
		this.time = builder.time;
		this.result = builder.result;
	}
	
	//builder patter for building up the writable data 
	public static class CurrencyChangeDataBuilder{
		private Currency currency;
		private double price;
		private float time;
		private int result;
		
		public CurrencyChangeDataBuilder setCurrency(Currency currency) {
			this.currency = currency;
			return this;
		}
		public CurrencyChangeDataBuilder setPrice(double price) {
			this.price = price;
			return this;
		}
		public CurrencyChangeDataBuilder setTime(float time) {
			this.time = time;
			return this;
		}
		public CurrencyChangeDataBuilder setResult(int result) {
			this.result = result;
			return this;
		}
		
		public CurrencyChangeData build() {
			return new CurrencyChangeData(this);
		}
		
	}
	
}
