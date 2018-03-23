package coinpurse.startegy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * Greedy strategy for withdraw money.
 * @author Patcharapol Nirunpornputta.
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

	/**
	 * Withdraw money that value is equals amount that user parse through 
	 * parameter using greedy algorithm.
	 * @param amount is a money that user want to withdraw with value and currency.
	 * @param List of money which user want to withdraw from.
	 * @return null if can't withdraw.
	 * 		   Empty array list if value of amount equals 0.
	 * 		   List of money which need to be withdraw.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> temp = new ArrayList<Valuable>();
		double remain = amount.getValue();
		if (remain == 0)
			return null;
		else {
			for (int i = 0; i < money.size(); i++) {
				if (remain >= money.get(i).getValue()
						&& money.get(i).getCurrency().equalsIgnoreCase(amount.getCurrency())) {
					remain = remain - money.get(i).getValue();
					temp.add(money.get(i));
				}
			}
			if(remain != 0) return null;
			return temp;
		}
	}
}
