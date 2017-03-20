
public class Aufgabe3 {
	private static Knoten feldZuListe(int[] eingabe) {
		Knoten list = null;								// Variable list vom Typ Knoten wird deklariert als null-Objekt
		for(int i = eingabe.length-1; i >= 0; i--) {	// uebergebener int-array wird von hinten durchgegangen
			Knoten temp = new Knoten();					// ein temporaerer Knoten wird angelegt,
			temp.schluessel = eingabe[i];				// ... dem die Zahl aus dem array zugeordnet wird
			temp.rechts = list;							// ... und die Adresse der bisher angelegten Liste
			list = temp;								// dem Knoten list wird die Referenz auf den Knoten temp zugewiesen
		}												// for(int schluessel : eingabe)
		return list;
	}
	
	private static boolean existiertSchluessel(Knoten start, int schluessel) {
		while (start != null) {
			if(start.schluessel == schluessel) return true;
			start = start.rechts;
		}
		return false;
	}
	
	private static void gibListeAus(Knoten start) {
		while (start != null) {
			System.out.println(start.schluessel);
			start = start.rechts;
		}
	}

	public static void main (String[] args) {
		int[] eingabe = {2, 4, 5, 7, 8};
		Knoten start = feldZuListe(eingabe);
		gibListeAus(start);
		System.out.println(existiertSchluessel(start, 7));
		System.out.println(existiertSchluessel(start, 0));
	}
}
