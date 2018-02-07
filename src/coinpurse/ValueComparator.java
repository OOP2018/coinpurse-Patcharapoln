package coinpurse;

import java.util.Comparator;

/**
 * A comparator of Valuable
 * 
 * @author Patcharapol Nirunpornputta
 *
 */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare which object currency should come first if object have same
	 * currency it will compare with value.
	 * 
	 * @return -1 if object a should come first. 0 if 2 objects are equal. 1 if
	 *         object b should come first.
	 */
	public int compare(Valuable a, Valuable b) {
		if (a.getCurrency().compareTo(b.getCurrency()) < 1)
			return -1;
		else if (a.getCurrency().compareTo(b.getCurrency()) > 1)
			return 1;
		else {
			if (a.getValue() < b.getValue())
				return -1;
			else if (a.getValue() > b.getValue())
				return 1;
		}
		return 0;
	}
}
