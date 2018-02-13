package coinpurse;
import java.util.ResourceBundle;

public abstract class MoneyFactory {
	private static MoneyFactory instance;
	static long nextSerialNumber = 1000000;

	public static MoneyFactory getInstance() {
		return instance;
	}

	public abstract Valuable createMoney(double value) throws IllegalArgumentException;

	public Valuable createMoney(String value) throws IllegalArgumentException {
		try {
			double val = Double.parseDouble(value);
			return createMoney(val);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}
	public static void setMoneyFactory(MoneyFactory factory) {
		MoneyFactory.instance = factory;
	}
}
