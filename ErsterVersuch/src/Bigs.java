class Bigs {
	
	// addiert die Ziffernfelder a und b
	public static int[ ] add (int[ ] a, int[ ] b) {
		int size = 0;
		if(b.length > a.length) {
			size = b.length;
		}
		else {
			size = a.length;
		}
		int[] sum = new int[size];
		int[] temp = Null();
		for(int i = 0; i < b.length || i < a.length; i++) {
			if(i >= a.length) {
				temp = fromInt(b[i] + sum[i]);
			}
			else if(i >= b.length) {
				temp = fromInt(a[i] + sum[i]);
			}
			else {
				temp = fromInt(a[i] + b[i] + sum[i]);
			}
			sum[i] = mod10(temp);
			if(less(digit(9), temp)) {
				if(i + 1 >= sum.length) {
					sum = addField(sum);
				}
				sum[i+1] = div10(temp)[0];
			}
		}
		return sum;
	}
	
	// kopiert den Wert von n und fuegt ein Feld an
	static int[] addField (int[] n) {
		int[] result = new int[n.length + 1];
		for(int i = 0; i < n.length; i++) {
			  result[i] = n[i];
		}
		return result;
	}
	
	// gibt das Ziffernfeld n in lesbarer dezimaler Form (ohne Newline) aus
	static void print (int[ ] n) { 
		for(int i = n.length - 1; i >= 0; i--) {
			System.out.print(n[i]);
		}
	}
	
	// gibt das Ziffernfeld n in lesbarer dezimaler Form (mit Newline) aus
	static void println (int[ ] n) { 
		for(int i=n.length-1; i >= 0; i--) {
			if(i > 0 ) {
				System.out.print(n[i]);
			}
			else {
				System.out.println(n[i]);
			}
		}
	}

	// konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
	static int[ ] digit(int d) { 
		int[] digit = {d};
		return digit;
	}
 
	// konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
	static int[ ] Null() { 
		int[] digitZero = {0};
		return digitZero;
	}

	// konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
	static int[ ] One() { 
		int[] digitOne = {1};
		return digitOne;
	}

	// Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
	static int mod10(int[ ] n) { 
		return n[0];
	}

	// ganzzahliger Quotient bei Division durch 10
	static int[ ] div10(int[ ] n) { 
		int[] quotient = new int[n.length-1];
		for(int i = 0, j = 1; j < n.length; i++, j++) {
			quotient[i] = n[j];
		}
		return quotient;
	}

	// Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld	
	static int[ ] fromInt(int n) {
		int[] intArr = Null();
		if(n == 0) {
			return Null();
		}
		for(int i = 0; n > 0; i++) {
			if(i == 0) {
				intArr[0] = n % 10;
			}
			else {
				intArr = addField(intArr);
				intArr[intArr.length-1] = n % 10;
			}
			n /= 10;
		}
		return intArr;
	}
	
	// kopiert den Wert von n
	static int[ ] copy(int[ ] n) { 
		int[] arrCopy = new int[n.length];
		for(int i = 0; i < n.length; i++) {
			arrCopy[i] = n[i];
		}
		return arrCopy;
	}

	// multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
	static int[ ] times(int[ ] n, int d) {
		int[] result = new int[n.length];
		int[] temp = Null();
		for(int i = 0; i < n.length; i++) {
			temp = fromInt(d * n[i] + result[i]);
			result[i] = mod10(temp);
			if(less(digit(9), temp)) {
				if(i + 1 >= result.length) {
					result = addField(result);
				}
				result[i+1] = div10(temp)[0];
			}
		}
		return result;
	}
	
	// multipliziert das Ziffernfeld n mit 10
	static int[ ] times10(int[ ] n) { 
		int[] product = new int[n.length+1];
		product[0] = 0;
		for(int i = 0, j = 1; i < n.length; i++, j++) {
			product[j] = n[i];
		}
		return product;
	}

	// multipliziert zwei Ziffernfelder	
	static int[ ] times(int[ ]a, int[ ] b) { 
		int[] product = Null();
		int[] sum = Null();
		for(int i = b.length-1; i >= 0; i--) {
			product = times(a, b[i]);
			for(int j = i; j > 0; j--) {
				product = times10(product);
			}
			sum = add(product, sum);
		}
		return sum;
	}
			
	// Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
	static boolean less (int[ ] a, int[ ] b) { 
		if(a.length < b.length) {
			return true;
		}
		else if(a.length == b.length) {
			for(int i = a.length-1; i >= 0; i--) {
				if(a[i] < b[i]) {
					return true;
				}
				else if(a[i] > b[i]) {
					return false;
				}
			}
		}
		return false;
	}

	// Test auf Gleichheit zweier Ziffernfelder
	static boolean equal (int[ ] a, int[ ] b) { 
		if(a.length != b.length) {
			return false;
		}
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
	
	// Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt mindenstens einer Ziffer, 
   // alle Positionen liegen zwischen 0 und 9, keine fuehrenden Nullen (ausser bei Null selbst)
	static boolean ok (int[ ] n) {
		if(n.length == 0) {
			return false;
		}
		if(n.length > 1 && n[n.length-1] == 0) {
			return false;
		}
		for(int i = 0; i < n.length; i++) {
			if(n[i] < 0 || n[i] > 9) {
				return false;
			}
		}
		return true;
	}
		
	public static void main (String[ ] s) {
		int[ ] a = One();
		for (int i=0; i<9989; ++i) {
			a = times(a, 2);
		}
		System.out.println("hat " + a.length + " Stellen");
		println(a); // 2 hoch 9989

		int[ ] b = fromInt(12345679);
		int[ ] c = copy(b);

		for (int i=1; i<424; ++i) {
			c=times(c, b);
			//println(c);  // 12345679 hoch 424
		}
		
		System.out.println("hat " + c.length + " Stellen");
		println(c);  // 12345679 hoch 424

		System.out.println(less(a, c)); // beantwortet die Frage aus der Aufgabenueberschrift
	}
}
