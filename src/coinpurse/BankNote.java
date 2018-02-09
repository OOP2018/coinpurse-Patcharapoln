package coinpurse;

/**
 * A class of bank note which have value,currency and serialnumber
 * @author Patcharapol Nirunpornputta
 *
 */
public class BankNote extends Money implements Valuable {
	private double value;
	private String currency;
	private long serialNumber;
	/** Started serial number of bank note */
	private static long nextSerialNumber = 1000000;

	/**
	 * A constructor of BankNote class , random serial number for bank note.
	 * @param value is value of bank note.
	 * @param currency is currency of bank note.
	 */
	public BankNote(double value, String currency) {
		super(value,currency);		
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	/**
	 * Return a serial number of bank note.
	 * @return a serial number of bank note.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Return value,currency,serial number of bank note.
	 * @return value ,currency ,serial number of bank note.
	 */
	@Override
	public String toString(){
		return this.getValue() + "-" + this.getCurrency()+" note ["+this.getSerial()+"]";
	}
}
