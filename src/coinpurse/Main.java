package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Patcharapol Nirunpornphutta
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
		MoneyFactory.setMoneyFactory(FileReader.readFile());
		Purse purse = new Purse(10);
		ConsoleDialog ui = new ConsoleDialog(purse);
		ui.run();
    }
}
