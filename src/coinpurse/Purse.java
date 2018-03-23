package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.startegy.GreedyWithdraw;
import coinpurse.startegy.RecursiveWithdraw;
import coinpurse.startegy.WithdrawStrategy;

/**
 * A purse contains money. You can insert coins/ bank note, withdraw money,
 * check the balance, and check if the purse is full.
 * 
 * @author Patcharapol Nirunpornputta
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<Valuable>();
	private Comparator<Valuable> comp = new ValueComparator();
	private WithdrawStrategy strategy = new RecursiveWithdraw();

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of objects you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		setWithdrawStrategy(strategy);
	}

	/**
	 * Count and return the number of object in the purse. This is the number of
	 * object, not their value.
	 * 
	 * @return the number of object in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (Valuable value : money) {
			balance += value.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (getCapacity() > count())
			return false;
		return true;
	}

	/**
	 * Insert money into the purse. The money are only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param value
	 *            is a valuable object to insert into purse
	 * @return true if money are inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		if (isFull())
			return false;
		else if (value.getValue() > 0) {
			this.money.add(value);
			return true;
		}
		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		Money value = new Money(amount, "Baht");
		return withdraw(value);
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		Collections.sort(money, comp);
		Collections.reverse(money);
		List<Valuable> temp = new ArrayList<>();
		temp = strategy.withdraw(amount, money);
		for(Valuable remove : temp) {
			money.remove(remove);
		}
		Valuable[] value = new Valuable[temp.size()];
		temp.toArray(value);
		return value;
	}

	public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * toString returns a string description of the purse contents.
	 * 
	 * @return a number of elements and a value of money.
	 */
	public String toString() {
		return count() + " with value " + getBalance();
	}
}
