
public class Brot extends Speise {
	
	public Brot(int typ, int menge) {
		super(""+typ, menge);
		if(typ == 0) name = "Weissbrot";
		if(typ == 1) name = "Schwarzbrot";
		if(typ == 2) name = "Mischbrot";
		else name = "Spezialbrot";
	}
	
	public boolean essen() {
		return super.essen(50);
	}
	
	public String status() {
		return "Brot: " + name + ", " + menge + " g."; 
	}
}
