package strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * Recursive strategy for withdraw money.
 * @author Patcharapol Nirunpornputta
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	/**
	 * Withdraw money that value is equals amount that user parse through parameter using recursive.
	 * @param amount is a money that user want to withdraw with value and currency.
	 * @param List of money which user want to withdraw from.
	 * @return null if can't withdraw.
	 * 		   Empty array list if value of amount equals 0.
	 * 		   List of money which need to be withdraw.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		double remove = amount.getValue();
		if (remove == 0)
			return new ArrayList<>();
		if (money.size() == 0)
			return null;

		List<Valuable> temp;
		Valuable first = money.get(0);
		if (money.get(0).getCurrency().equalsIgnoreCase(amount.getCurrency())) {
			temp = withdraw(new Money(remove - first.getValue(), amount.getCurrency()), money.subList(1, money.size()));
			if (temp != null) {
				temp.add(first);
				return temp;
			}
			return withdraw(amount, money.subList(1, money.size()));
		}
		return null;
	}

}
