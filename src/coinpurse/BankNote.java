package coinpurse;

public class BankNote implements Valuable {
	private double value;
	private String currency;
	private long serialNumber;
	/** Started serial number of bank note */
	private long ranNumber = 1000000;

	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = ranNumber;
		ranNumber++;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}

	public long getSerial() {
		return this.serialNumber;
	}

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
	
	@Override
	public String toString(){
		return this.getValue() + "-" + this.getCurrency()+" note ["+this.serialNumber+"]";
	}
}
