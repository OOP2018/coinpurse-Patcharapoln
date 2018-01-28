package coinpurse;

/**
 * A class of coins which have value and currency
 * @author Patcharapol Nirunpornputta
 *
 */
public class Coin implements Comparable<Coin> , Valuable {
	private double value;
	private String currency;

	/**
	 * A constructor of coin class
	 * @param value of coins
	 * @param currency of coins
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return value of coins
	 * @return value of coins
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Return currency of coins
	 * @return currency of coins
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check that coin value,currency are equal
	 * @param arg is an object that bring to compare
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		if (currency.equalsIgnoreCase(other.currency) && value == other.value)
			return true;
		return false;
	}

	/**
	 * Compare a value between two coins
	 * @return -1 if coin value is less than another
	 * 		   0 if coins are equal
	 * 		   1 if coin is more than another
	 */
	@Override
	public int compareTo(Coin coin) {
		if (this.getValue() < coin.getValue())
			return -1;
		else if (this.getValue() > coin.getValue())
			return 1;
		return 0;
	}

	/**
	 * return value,currency of a coin
	 * @return value and currency of a coin
	 */
	public String toString() {
		return this.value + "-" + this.currency;
	}
}
