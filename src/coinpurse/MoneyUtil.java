package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyUtil {
	
	/**
	 * Sort a coin by compareto method in purse
	 * @param coins a list of coins.
	 */
	public static void sortCoins(List<Coin> coins){
		Collections.sort(coins);
	}
	
	/**
	 * 
	 * @param coins a list of coins.
	 * @param currency of coins
	 * @return List of coins that have same currency
	 */
	public static List<Coin>filterByCurrency(List<Coin>coins,String currency){
		List<Coin> temp = new ArrayList<Coin>();
		for(Coin c:coins){
			if(c.getCurrency()==currency){
				temp.add(c);
			}
		}return temp;
	}
		
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(5.0,"Baht"));
		coins.add(new Coin(1,"Baht"));
		coins.add(new Coin(1,"Ringgit"));
		coins.add(new Coin(2.5,"Dollars"));
		sortCoins(coins);
		System.out.println(coins);
	}
}
