package coinpurse;

/**
 * A class of bank note which have value,currency and serialnumber
 * @author Patcharapol Nirunpornputta
 *
 */
public class BankNote implements Valuable {
	private double value;
	private String currency;
	private long serialNumber;
	/** Started serial number of bank note */
	private static long ranNumber = 1000000;

	/**
	 * A constructor of BankNote class , random serial number for bank note.
	 * @param value is value of bank note.
	 * @param currency is currency of bank note.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = ranNumber;
		ranNumber++;
	}

	/**
	 * Return value of bank note.
	 * @return value of bank note.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Return a currency of bank note.
	 * @return a currency of bank note.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Return a serial number of bank note.
	 * @return a serial number of bank note.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Check that bank note value,currency are equal
	 * @param arg is an object that bring to compare
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		BankNote other = (BankNote) obj;
		if (this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency()))
			return true;
		return false;
	}
	
	/**
	 * Return value,currency,serial number of bank note.
	 * @return value ,currency ,serial number of bank note.
	 */
	@Override
	public String toString(){
		return this.getValue() + "-" + this.getCurrency()+" note ["+this.serialNumber+"]";
	}
}
