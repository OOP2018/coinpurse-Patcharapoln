package coinpurse;

/**
 * A class of money which have value and currency.
 * @author Patcahrapol Nirunpornputta
 *
 */
public class Money implements Valuable{
	protected double value;
	protected String currency;

	/**
	 * A constructor of money class.
	 * @param value is value of money.
	 * @param currency is currency of money.
	 */
	public Money(double value,String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return value of money.
	 * @return value of money.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Return currency of money.
	 * @return currency of money.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check that money value,currency are equal.
	 * @param arg is an object that bring to compare.
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Money other = (Money) arg;
		if (currency.equalsIgnoreCase(other.getCurrency()) && value == other.getValue())
			return true;
		return false;
	}
	
	/**
	 * Compare which money currency should come first if object have same
	 * currency it will compare with value.
	 * 
	 * @return -1 if object a should come first. 0 if 2 objects are equal. 1 if
	 *         object b should come first.
	 */
	@Override
	public int compareTo(Valuable o) {
		if(this.getCurrency().compareToIgnoreCase(o.getCurrency()) == 0) 
			return Double.compare(this.getValue(), o.getValue());
		return this.getCurrency().compareToIgnoreCase(o.getCurrency());
	}
}