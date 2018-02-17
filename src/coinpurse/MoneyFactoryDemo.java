package coinpurse;

/**
 * Create ThaiMoneyFactory for testing create money.
 * @author Patcharapol Nirunpornputta
 *
 */
public class MoneyFactoryDemo {
	public static void main(String[] args) {
		MoneyFactory factory1 = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
		System.out.println("Check that 2 factory are equal");
		System.out.println(factory1 == factory2);
		
		// Create stang coin.
		Valuable stang = factory1.createMoney(0.5);
		System.out.println(stang.toString());
		// Create baht coin.
		Valuable coin = factory1.createMoney(10);
		System.out.println(coin.toString());
		// Create bath banknotes.
		Valuable bankNote1 = factory1.createMoney(20);
		Valuable bankNote2 = factory1.createMoney(100);
		System.out.println(bankNote1.toString());
		System.out.println(bankNote2.toString());
		// Create invalid money it will show an error.
		Valuable invalid = factory1.createMoney(7);
	}
}
