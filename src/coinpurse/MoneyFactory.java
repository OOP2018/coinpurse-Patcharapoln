package coinpurse;
import java.util.ResourceBundle;

/**
 * MoneyFactory is a class that create money with value and currency.
 * @author Patcharapol Nirunpornputta
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory instance;
	static long nextSerialNumber = 1000000;

	/**
	 * Return an instance of MoneyFactory.
	 * @return an instance of MoneyFactory.
	 */
	public static MoneyFactory getInstance() {
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
		try {
			double val = Double.parseDouble(value);
			return createMoney(val);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	/**
	 * Set money factory.
	 */
	public static void setMoneyFactory(MoneyFactory factory) {
		MoneyFactory.instance = factory;
	}
}
