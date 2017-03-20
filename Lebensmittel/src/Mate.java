
public class Mate extends Getraenk {
	
	public Mate(String name) {
		super(name, 500);
	}
	
	public boolean trinken(){
		return super.trinken(100);
	}
	
	public String status() {
		return "Mate: " + name + ", " + menge + " ml."; 
	}
}
