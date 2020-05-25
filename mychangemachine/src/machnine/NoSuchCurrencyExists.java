package machnine;

public class NoSuchCurrencyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchCurrencyExists(String msg) {
		super(msg);
	}

}
