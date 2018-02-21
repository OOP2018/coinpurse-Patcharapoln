package coinpurse;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test MoneyFactory using JUnit. This is a JUnit 4 test suite.
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4, but you have to
 * tell the IDE to add it to your project as a "Library". To run these tests,
 * right click on this file (in Project panel) and choose Run As -> JUnit test
 * 
 * @author Patcharapol Nirunpornputta
 */
public class MoneyFactoryTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "Baht";

	/**
	 * Test created , equals and set MoneyFactory class.
	 */
	@Test
	public void testMoneyFactory() {
		MoneyFactory factory1 = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
		assertTrue(factory1 == factory2);
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		factory2 = MoneyFactory.getInstance();
		assertFalse(factory1 == factory2);
	}
	
	/**
	 * Test create stang coins , Baht coin and Bath BankNotes.
	 */
	@Test
	public void testCreateThaiMoney() {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		assertEquals(5, factory.createMoney(5).getValue(),TOL);
		assertEquals("Baht", factory.createMoney(5).getCurrency());
		assertEquals("Stang", factory.createMoney(0.5).getCurrency());
		assertEquals(20, factory.createMoney(20).getValue(),TOL);
	}

	/**
	 * Test create sen coins, Ringgit BankNtes.
	 */
	@Test
	public void testCreateMalayMoney() {
		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		assertEquals(1, factory.createMoney(1).getValue(),TOL);
		assertEquals("Sen", factory.createMoney(0.05).getCurrency());
		assertEquals("Ringgit", factory.createMoney(20).getCurrency());
		assertEquals(20, factory.createMoney(20).getValue(),TOL);
	}
	
	/**
	 * Test create non-numerical value case. Pass when it throw IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNonNumericalValueExceptionCase() {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		factory.createMoney("invalid");
	}
	
	/**
	 * Test create invalid value case. Pass when it throw IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidValueExceptionCase() {
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		factory.createMoney(3);
	}
}
