package coinpurse;

public abstract class MoneyFactory {
	private static MoneyFactory instance;

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
}
