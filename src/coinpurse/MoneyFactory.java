package coinpurse;

/**
 * MoneyFactory is a class that create money with value and currency.
 * @author Patcharapol Nirunpornputta
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory instance;

	/**
	 * Return an instance of MoneyFactory.
	 * @return an instance of MoneyFactory.
	 */
	public static MoneyFactory getInstance() {
		if(instance == null) {
			instance = FileReader.readFile();
		}
		return instance;
	}

	/**
	 * Create money with double value.
	 * @param value of money.
	 * @return money with value and currency.
	 * @throws IllegalArgumentException when value is not valid.
	 */
	public abstract Valuable createMoney(double value) throws IllegalArgumentException;

	/**
	 * Create money with string value.
	 * @param value of money.
	 * @return money with value and currency.
	 * @throws IllegalArgumentException when value is not valid.
	 */
	public Valuable createMoney(String value) throws IllegalArgumentException {
		double val = 0;
		try {
			val = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid value",e);
		}
		return createMoney(val);
	}
	
	/**
	 * Set money factory.
	 */
	public static void setMoneyFactory(MoneyFactory factory) {
		MoneyFactory.instance = factory;
	}
}
