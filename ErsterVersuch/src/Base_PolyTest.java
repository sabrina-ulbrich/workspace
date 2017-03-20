public class Base_PolyTest {
	
	static void out(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		Base_Derived d = new Base_Derived();
		System.out.println("class Base_Derived");
		out(d.s);
		out(d.s());
		out(d.t());				// da die Methode nur in Base existiert, kann die abgeleitete Klasse nur darauf zugreifen
		
		Base b = d;				// das abgeleitete Objekt d wird dem Basisobjekt b zugewiesen
								// so, wie auch einer double-Variablen eine int-Zahl zugewiesen werden kann (umgekehrt geht es nicht)
		System.out.println("class Base of Base_Derived");
		out(b.s);				// da Variablen statisch gebunden sind, wird die BasisVariable zugeordnet
		out(b.s());				// dynamische Bindung bei Methoden (zur Laufzeit ermittelt), also wird base mit derived ueberschrieben
		out(b.t());
		
		Base b2 = new Base();	// das Basis-Objekt greift immer auf die Basis-Variablen und -Methoden zu
		System.out.println("class Base");
		out(b2.s);
		out(b2.s());
		out(b2.t());

	}
}
