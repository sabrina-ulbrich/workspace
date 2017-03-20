
public abstract class Speise extends Lebensmittel{
	
	public Speise(String name, int menge) {
		super(name, menge);
	}
	
	public abstract boolean essen (); 

	protected boolean essen(int menge){ 
		if (this.menge>=menge) {
			this.menge -= menge;
			return true;
		} else {
			return false;
		}
	}

	public boolean trinken(){
		return false;	
	}

	public abstract String status(); 
}
