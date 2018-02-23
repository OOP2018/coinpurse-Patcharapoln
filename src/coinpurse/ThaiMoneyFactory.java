package coinpurse;

/**
 * ThaiMoneyFactory is a class that create Thai money with value and currency.
 * 
 * @author Patcharapol Nirunpornputta.
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	static long nextSerialNumber = 1000000;
	private double[] marray = { 0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	/**
	 * Create Thai money with double value.
	 * 
	 * @return Thai money with value and currency.
	 * @throws IllegalArgumentException
	 *             when value is not valid.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		for (double thai : marray) {
			if (thai == value) {
				if (thai <= 10) {
					return new Coin(value, "Baht");
				} else {
					return new BankNote(value, "Baht", this.nextSerialNumber++);
				}
			}
		}
		throw new IllegalArgumentException("Invalid value");
	}
	
	public static void main(String[] args) {
		MoneyFactory thai = MoneyFactory.getInstance();
		Valuable m = thai.createMoney(10);
		System.out.println(m);
	}
}
