public class Coins {	
	public static long[][] cache;
	public static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200}; // Muenzwerte
	public static int n = coins.length;							 // Anzahl der Muenzen
	public static boolean cached = false;

	/**
	 * Hauptmethode: Bei der Eingabe wird der Parameter s erwartet und als
	 * Centbetrag in der Variable int sum gespeichert. Aufrufe ohne Parameter
	 * erzeugen eine Fehlermeldung. Bei optionaler Eingabe des Parameters -c
	 * wird ein Cache verwendet. Eine Methode zur Berechnung der Anzahl der
	 * moeglichen Zahlweisen wird aufgerufen und das Ergebnis ausgegeben.
	 */
	public static void main(String[] s) {
		int sum = 0;
		try {
			if(s[0].contentEquals("-c")) {
				sum = Integer.parseInt(s[1]);
				cached = true;
			}
			else {
				sum = Integer.parseInt(s[0]);
			}
		} catch ( Exception e ) {
			System.err.println("Aufruf mit Geldbetrag (in Cent) als Parameter oder mit vorangestelltem -c fuer Caching");
			System.exit(n);
		}
		System.out.print(euro(sum));
		System.out.print(" kann auf ");
		System.out.print(pay(sum));
		System.out.println(" verschiedene Arten passend bezahlt werden ");
		// System.out.println(million());
		// System.out.println(billion());
		// printCache();
	}

	/**
	 * Initialisierung des Arrays der Cache-Version und Aufruf der
	 * rekursiven Funktion zur Berechnung der Wahrscheinlichkeiten.
	 */
	public static long pay (int m) {
		if(cached) {
			cache = new long[m + 1][coins.length + 1];
		}
		return pay(m, coins.length);
	}

	/**
	 * Fuer eine gegebene Summe amount wird in einer rekursiven Funktion
	 * ermittelt, auf wieviele verschiedene Weisen der Betrag ausgezahlt
	 * werden kann.
	 */
	private static long pay(int amount, int coin) {
		if(amount == 0 || coin == 1) {
			return 1;
		}
		if(amount < 0) {
			return 0;
		}
		
		if(cached) {
			if(cache[amount][coin - 1] == 0) {
				cache[amount][coin - 1] = pay(amount, coin - 1);
			}

			if(amount - coins[coin - 1] < 0) {
				return cache[amount][coin - 1] + 0;
			}

			if(cache[amount - coins[coin - 1]][coin] == 0) {
				cache[amount - coins[coin - 1]][coin] = pay(amount - coins[coin-1], coin);
			}

			return cache[amount][coin - 1] + cache[amount - coins[coin - 1]][coin];
		}
		
		return pay(amount, coin - 1) + pay(amount - coins[coin-1], coin);
	}
	
	/**
	 * Berechnet den kleinsten Betrag, der auf mindestens 1.000.000 
	 * verschiedene Weisen bezahlt werden kann
	 */
	public static String million() {
		long result = 0;
		int amount = 0;
		while (result < 1000000) {
			amount++;
			result = pay(amount);
		};
		return euro(amount);
	}

	/**
	 * Berechnet den kleinsten Betrag, der auf mindestens 1.000.000.000 
	 * verschiedene Weisen bezahlt werden kann
	 */
	public static String billion() {
		long result = 0;
		int amount = 0;
		cached = true;
		// cache = new long[1208][9];
		while (result < 1000000000) {
			amount++;
			result = pay(amount);
		};
		return euro(amount);
	}
	
	/**
	 * Erzeugt eine Zeichenkette, die den Centbetrag cent in Euro im Format
	 * "ee...ee,cc Euro" enthaelt
	 */
	public static String euro(int cent) {
		String euro = "";
		for(int i = 0; i < 2; i++) {
			euro = String.valueOf(cent % 10) + euro;
			cent /= 10;
		}
		euro = String.valueOf(cent) + "," + euro + " Euro";
		return euro;
	}
	
	public static void printCache() {
		for(int i = 0; i < cache.length; i++) {
			for(int j = 0; j < cache[i].length; j++) {
				System.out.println(i + ", " + j + ": " + cache[i][j]);
			}
		}
	}
}
