package coinpurse;

public class Test {
	
	public boolean equals(Object obj) {
		Coin c = (Coin)obj;
		c.getValue();
		return false;
	}
	public static void main(String[] args) {
		double value = 10;
		String s = String.format("%d Baht", value);
	}
}
