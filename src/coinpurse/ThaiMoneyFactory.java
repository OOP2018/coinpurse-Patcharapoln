package coinpurse;

/**
 * ThaiMoneyFactory is a class that create Thai money with value and currency.
 * 
 * @author Patcharapol Nirunpornputta.
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private String currency = "Baht";

	/**
	 * Create Thai money with double value.
	 * @return Thai money with value and currency.
	 * @throws IllegalArgumentException when value is not valid.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (value == 1 || value == 2 || value == 5 || value == 10) {
			return new Coin(value, currency);
		} else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return new BankNote(value, currency, this.nextSerialNumber++);
		} else
			throw new IllegalArgumentException();
	}

}
