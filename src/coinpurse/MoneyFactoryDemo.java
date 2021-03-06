package coinpurse;

/**
 * Create ThaiMoneyFactory and MalayMoneyFactory for testing create money.
 * @author Patcharapol Nirunpornputta
 *
 */
public class MoneyFactoryDemo {
	public static void main(String[] args) {
		MoneyFactory factory1 = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
		System.out.println("Check that 2 factory are equal");
		System.out.println(factory1 == factory2);
		
		System.out.println("Thai Money");
		// Create baht coin.
		Valuable coin = factory1.createMoney(10);
		System.out.println(coin.toString());
		// Create bath bank notes.
		Valuable bankNote1 = factory1.createMoney(20);
		Valuable bankNote2 = factory1.createMoney(100);
		System.out.println(bankNote1.toString());
		System.out.println(bankNote2.toString());
		// Set factory2 to Malay.
		factory2.setMoneyFactory(new MalayMoneyFactory());
		factory2 = MoneyFactory.getInstance();	
		System.out.println();
		System.out.println("Malay Money");
		// Create Ringgit coin.
		Valuable ringcoin = factory2.createMoney(0.1);
		System.out.println(ringcoin.toString());
		// Create ringgit bank note.
		Valuable ringgit = factory2.createMoney(10);
		// Create String ringgit bank notes.
		Valuable ringgit2 = factory2.createMoney("100");
		System.out.println(ringgit.toString());
		System.out.println(ringgit2.toString());
	}
}
