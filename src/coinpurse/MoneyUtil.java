package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A utility program of coin which can sort and filter coin by currency.
 * 
 * @author Patcharapol Nirunpornputta
 *
 */
public class MoneyUtil {

	/**
	 * Sort a coin by compareTo method in purse
	 * 
	 * @param coins
	 *            a list of coins.
	 */
	public static void sortMoney(List<? extends Valuable> value) {
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(value, comp);
	}

	/**
	 * Filter coin by currency and put it to a list.
	 * 
	 * @param money
	 *            a list of coins.
	 * @param currency
	 *            of coins
	 * @return List of coins that have same currency
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> money, String currency) {
		List<E> temp = new ArrayList<E>();
		for (E m : money) {
			if (m.getCurrency().equals(currency)) {
				temp.add(m);
			}
		}
		return temp;
	}

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args
	 *            one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) throws IllegalArgumentException {
		int size = args.length - 1;
		E max = null;
		E temp = args[0];
		for (int i = 0; i < size; i++) {
			if (temp.compareTo(args[i]) > 0)
				max = temp;
			else if (temp.compareTo(args[i]) < 0)
				max = args[i];
		}
		return max;
	}

	public static void main(String[] args) {
		String max = MoneyUtil.max( "dog", "zebra", "cat" );
		System.out.println(max);
	}
}
