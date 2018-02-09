package coinpurse;

public class Money implements Valuable{

	protected double value;
	protected String currency;

	public Money(double value,String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return value of coins
	 * @return value of coins
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Return currency of coins
	 * @return currency of coins
	 */
	public String getCurrency() {
		return currency;
	}

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