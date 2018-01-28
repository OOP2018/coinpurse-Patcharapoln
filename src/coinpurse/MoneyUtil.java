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
	 * Sort a coin by compareto method in purse
	 * 
	 * @param coins
	 *            a list of coins.
	 */
	public static void sortCoins(List<Valuable> value) {
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(value,comp);
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
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> temp = new ArrayList<Valuable>();
		for (Valuable c : money) {
			if (c.getCurrency().equals(currency)) {
				temp.add(c);
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		List<Valuable> coins = new ArrayList<Valuable>();
		coins.add(new Coin(5.0, "Dollar"));
		coins.add(new Coin(100, "Baht"));
		coins.add(new Coin(1, "Ringgit"));
		coins.add(new Coin(2.5, "Dollars"));
		sortCoins(coins);
		System.out.println(coins);
	}
}
