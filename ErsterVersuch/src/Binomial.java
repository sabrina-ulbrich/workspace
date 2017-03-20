/**
 * Humboldt-Universitaet zu Berlin, Institut fuer Informatik
 * Grundlagen der Programmierung (Prof. Bothe, WS 2013/14)
 * Uebungsblatt 4 Aufgabe 2: Binomialkoeffizienten
 */
public class Binomial
{
	public static long aufrufe; // Zaehler fuer die Anzahl der Rekursionsaufrufe
	public static long [][]cache; // Speicher fuer die Cache- und iterative Variante

	/**
	 * Berechnet den Binomialkoeffizienten n ueber k (n \ k) rekursiv.
	 * Hierzu wird folgende Berechnungsvorschrift verwendet:
	 * (n \ k) = (n-1 \ k-1) + (n-1 \ k)
	 */
	public static long binomialRek(int n,int k) {
		aufrufe++;
		if (k == 0 || n == k) {
			return 1;
		}
		return binomialRek(n-1, k-1) + binomialRek(n-1, k);
	}

	/**
	 * Berechnet den Binomialkoeffizienten n ueber k (n \ k)
	 * rekursiv mit Hilfe eines Caches. Der Cache dient dazu, dass
	 * jeder Binomialkoeffizient der Zwischenrechnung nur hoechstens
	 * einmal berechnet wird. Es wird wieder verwendet:
	 * (n \ k) = (n-1 \ k-1) + (n-1 \ k)
	 */
	public static long binomialRekCache(int n,int k) {	
		aufrufe++;
		if(cache[n][k] == 0) {		
			if(k == 0 || n == k) {
				cache[n][k] = 1;
			}
			else {
				cache[n][k] = binomialRekCache(n-1, k-1) + binomialRekCache(n-1, k);
			}
		}
		return cache[n][k];
	}

	/**
	 * Berechnet den Binomialkoeffizienten n ueber k (n \ k)
	 * iterativ mit Hilfe der folgenden Produktformel:
	 * (n \ k) = \prod_{i=1}^k \frac{n-k+i}{i}
	 */
	public static long binomialIterativ(int n,int k)
	{	
		long result = 1;
		for(int i = 1, j = n; i <= k; i++, j--) {
			result *= j;
			result /= i;
		}
		return result;
	}

	/**
	 * Hauptmethode des Binomial Programms.
	 * Die Parameter n und k werden als Eingabeparameter erwartet.
	 * Ruft die drei Methoden zur Berechnung des Binomialkoeffizienten
	 * n ueber k auf und gibt jeweils das Ergebnis, die Laufzeit und
	 * (fuer rekursive Varianten) die Anzahl der Rekursionsaufrufe aus.
	 */
	public static void main(String []args) {
		if (args.length < 2) System.out.println("Bitte n und k als Parameter uebergeben!");
		else {
			int n = Integer.parseInt(args[0]);
			int k = Integer.parseInt(args[1]);
			if ((n < 0) || (k < 0)) System.out.println("Die Parameter n und k duerfen nicht negativ sein!");
			else if (n < k) System.out.println("n darf nicht kleiner sein als k!");
			else {

				aufrufe = 0;
				long time1 = System.currentTimeMillis();
				long result = binomialRek(n,k);
				long time2 = System.currentTimeMillis();
				System.out.println("binomialRek wurde " + aufrufe + " mal aufgerufen (" + (time2-time1) + " ms). Ergebnis: " + result);

				aufrufe = 0;
				cache = new long[n+1][k+1];
				time1 = System.currentTimeMillis();
				result = binomialRekCache(n,k);
				time2 = System.currentTimeMillis();
				System.out.println("binomialRekCache wurde "+aufrufe+" mal aufgerufen ("+(time2-time1)+" ms). Ergebnis: "+result);

				cache = new long[n+1][k+1];
				time1 = System.currentTimeMillis();
				result = binomialIterativ(n,k);
				time2 = System.currentTimeMillis();
				System.out.println("binomialIterativ ("+(time2-time1)+" ms) lieferte Ergebnis: "+result);

			}
		}
	}
}
