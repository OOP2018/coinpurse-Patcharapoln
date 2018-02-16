package coinpurse;

import java.util.ResourceBundle;

/**
 * Read file from properties file.
 * 
 * @author Patcharapol Nirunpornputta
 *
 */
public class FileReader {

	/**
	 * Read file from properties file.
	 * 
	 * @return type of money factory.
	 */
	public static MoneyFactory readFile() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null)
			System.exit(1);
		return factory;
	}
}
