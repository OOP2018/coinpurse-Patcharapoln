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
	 * Compare a value between money.
	 * @return -1 if coin value is less than another.
	 * 		   0 if coins are equal.
	 * 		   1 if coin is more than another.
	 */
	@Override
	public int compareTo(Valuable o) {
		if (this.getCurrency().compareTo(o.getCurrency()) < 1)
			return -1;
		else if (this.getCurrency().compareTo(o.getCurrency()) > 1)
			return 1;
		else {
			if (this.getValue() < o.getValue())
				return -1;
			else if (this.getValue() > o.getValue())
				return 1;
		}
		return 0;
	}
}