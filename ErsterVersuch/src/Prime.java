
public class Prime {

	static boolean[] createSieb(int size) {
		boolean[] sieb = new boolean[size];
		for (int i = 2; i < size; i++) {
			sieb[i] = true;
		}
		return sieb;
	}
	
	static void printPrimes(boolean[] sieb, int n) {
		for(int i = 2, j = 1; j <= n; i++) {
			if(sieb[i]) {
				System.out.println(j + ": " + i);
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int count = 0;
		int m = 10;
		boolean[] sieb = new boolean[m];			// sieb[i] = true <-> i ist Primzahl

		sieb = createSieb(m);						// alle Elemente sind true

		for (int i = 2; i < m; i++) {
			if (sieb[i]) {
				count++;
				for (int j = i+i; j < m; j += i) {
					sieb[j] = false;
				}
			}
			if (count < n && i+1 == m) {
				m *= 10;
				i = 1;
				count = 0;
				sieb = createSieb(m);
			}
		}
		
		printPrimes(sieb, n);
	}
}
