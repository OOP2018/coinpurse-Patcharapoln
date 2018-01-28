package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Patcharapol Nirunpornputta
 *
 */
public interface Valuable {
	
	/**
	 * Return value of objects.
	 * @return value of objects.
	 */
	public double getValue();

	/**
	 * return currency of objects.
	 * @return currency of objects.
	 */
	public String getCurrency();

}
