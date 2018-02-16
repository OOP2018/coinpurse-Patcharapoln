package coinpurse;

/**
 * A class of coins which have value and currency
 * @author Patcharapol Nirunpornputta
 *
 */
public class Coin extends Money  {
	/**
	 * A constructor of coin class
	 * @param value of coins
	 * @param currency of coins
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}

	/**
	 * return value,currency of a coin
	 * @return value and currency of a coin
	 */
	public String toString() {
		return this.getValue()  +" "+ this.getCurrency()+ " coin";
	}
}
