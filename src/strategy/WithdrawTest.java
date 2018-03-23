package strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Money;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * Class for testing withdraw money by using strategy.
 * 
 * @author Patcharapol Nirunpornputta.
 *
 */
public class WithdrawTest {
	private static final double TOL = 1.0E-6;
	private WithdrawStrategy strategy;
	private final String baht = "Baht";
	private Comparator<Valuable> comp = new ValueComparator();

	private Money makeMoney(int value, String currency) {
		return new Money(value, currency);
	}

	@Before
	public void setUp() throws Exception {
		strategy = new RecursiveWithdraw();
	}

	@Test
	public void testWithdrawEveryThings() {
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> temp = new ArrayList<Valuable>();
		money.add(makeMoney(20, baht));
		money.add(makeMoney(100, baht));
		money.add(makeMoney(1, baht));
		temp = strategy.withdraw(makeMoney(121, baht), money);
		assertTrue(temp != null);
		assertEquals(sum(temp), 121, TOL);
	}

	@Test
	public void testMultiWithdraw() {
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> temp = new ArrayList<Valuable>();
		money.add(makeMoney(20, baht));
		money.add(makeMoney(1, baht));
		money.add(makeMoney(100, baht));
		temp = strategy.withdraw(makeMoney(120, baht), money);
		assertTrue(temp != null);
		assertEquals(2, temp.size());
		assertEquals(sum(temp), 120, TOL);
	}

	@Test
	public void testRecursiveWithdraw() {
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> temp = new ArrayList<Valuable>();
		money.add(makeMoney(5, baht));
		money.add(makeMoney(2, baht));
		money.add(makeMoney(2, baht));
		money.add(makeMoney(2, baht));
		temp = strategy.withdraw(makeMoney(6, baht), money);
		assertEquals(6, sum(temp), TOL);
	}

	/*
	 * Test withdraw money with difference currency.
	 */
	@Test
	public void testWithdrawDiffCurrency() {
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> temp = new ArrayList<Valuable>();
		money.add(makeMoney(20, baht));
		money.add(makeMoney(100, "Ringgit"));
		temp = strategy.withdraw(makeMoney(100, "Baht"), money);
		money.add(makeMoney(50, baht));
		assertNull(temp);
	}

	@Test
	public void testGreedyWithdraw() {
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> temp = new ArrayList<Valuable>();
		GreedyWithdraw greedy = new GreedyWithdraw();
		money.add(makeMoney(5, baht));
		money.add(makeMoney(10, baht));
		money.add(makeMoney(2, baht));
		money.add(makeMoney(2, baht));
		Collections.sort(money,comp);
		Collections.reverse(money);
		temp = greedy.withdraw(makeMoney(12, baht), money);
		assertEquals(12, sum(temp), TOL);
	}

	@Test
	public void testImpossibleWithdraw() {
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> temp = new ArrayList<Valuable>();
		money.add(makeMoney(20, baht));
		money.add(makeMoney(100, "Ringgit"));
		temp = strategy.withdraw(makeMoney(500, "Baht"), money);
		assertNull(temp);
	}

	private double sum(List<Valuable> value) {
		if (value == null)
			return 0.0;
		double sum = 0;
		for (Valuable c : value)
			if (c != null)
				sum += c.getValue();
		return sum;
	}
}
