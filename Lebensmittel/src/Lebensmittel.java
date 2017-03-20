
public abstract class Lebensmittel {
	protected String name;
	protected int menge;	// in Milliliter bzw. Gramm
	
	public Lebensmittel(String name, int menge) {
		this.name = name;
		this.menge = menge;
	}
	
	public Lebensmittel(int menge) {
		this.menge = menge;
	}
	
	public abstract boolean essen();
	public abstract boolean trinken();
	public abstract String status();
}
