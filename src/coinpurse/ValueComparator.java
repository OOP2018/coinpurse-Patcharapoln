package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {
	public int compare(Valuable a, Valuable b) {
		if (a.getCurrency().charAt(0) < b.getCurrency().charAt(0))
			return -1;
		else if (a.getCurrency().charAt(0) > b.getCurrency().charAt(0))
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
