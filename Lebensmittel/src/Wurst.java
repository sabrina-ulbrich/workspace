
public class Wurst extends Speise {
	
	public Wurst(String name, int menge) {
		super(name, menge);
	}

	public boolean essen(){
		return super.essen(10);
	}
	
	public String status() {
		return "Wurst: " + name + ", " + menge + " g."; 
	}
}
