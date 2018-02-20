package coinpurse;

/**
 * MalayMoneyFactory is a class that create Malaysia money with value and
 * currency.
 * 
 * @author Patcharapol Nirunpornputta.
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	static long nextSerialNumber = 1000000;
	private double[] marray = { 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100 };

	/**
	 * Create Malaysia money with double value.
	 * 
	 * @return Malaysia money with value and currency.
	 * @throws IllegalArgumentException
	 *             when value is not valid.
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		for (double malay : marray) {
			if (malay == value) {
				if (malay < 1) {
					return new Coin(value*100, "Sen");
				} else {
					return new BankNote(value, "Ringgit", this.nextSerialNumber++);
				}
			}
		}
		throw new IllegalArgumentException("Invalid value");
	}

}
