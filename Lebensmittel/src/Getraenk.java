
public abstract class Getraenk extends Lebensmittel {
	
	public Getraenk(String name, int menge) {
		super(name, menge);
	}
	
	public boolean essen() {
		return false;
	}
		
	public boolean trinken(int menge){
		if (this.menge>=menge){
			this.menge -= menge;
			return true;
		} else
			return false;	
	}
	
	public abstract boolean trinken(); 
	
	public abstract String status(); 

}
