public class Operators {

	// addiert die Ziffernfelder a und b
	public static int[ ] add (int[ ] a, int[ ] b) { 
		int temp = 0;
		int borrow = 0;
		int[] sum = new int[0];
		for(int i = 0; i < a.length || i < b.length; i++) {
			if(i >= a.length)
				temp = 0 + b[i] + borrow;
			else if(i >= b.length)
				temp = a[i] + 0 + borrow;
			else
				temp = a[i] + b[i] + borrow;
			if(temp > 9) {
				borrow = temp / 10;
				temp = temp % 10;
			}
			else
				borrow = 0;
			sum = addDigit(sum, temp);
		}
		return sum;
	}
	
	// erzeugt ein neues Ziffernfeld aus dem Ziffernfeld n und der Ziffer d 
	static int[] addDigit (int[] n, int d) {
		int[] result = new int[n.length + 1];
		for(int i = 0; i < n.length; i++)
			result[i] = n[i];
		result[result.length - 1] = d;
		return result;
	}
		
	// gibt das Ziffernfeld n in lesbarer dezimaler Form (ohne Newline) aus
	static void print (int[ ] n) { 
		for(int i = n.length - 1; i >= 0; i--)
			System.out.print(n[i]);
	}
	
	// gibt das Ziffernfeld n in lesbarer dezimaler Form (mit Newline) aus
	static void println (int[ ] n) { 
		for(int i=n.length-1; i >= 0; i--) {
			if(i > 0 )
				System.out.print(n[i]);
			else
				System.out.println(n[i]);
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
		for(int i = 0, j = 1; j < n.length; i++, j++)
			quotient[i] = n[j];
		return quotient;
	}

	// Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld	
	static int[ ] fromInt(int n) {
		int[] intArr = new int[0];
		while (n > 0) {
			intArr = addDigit(intArr, n % 10);
			n /= 10;
		}
		return intArr;
	}

	// kopiert den Wert von n
	static int[ ] copy(int[ ] n) { 
		int[] arrCopy = new int[n.length];
		for(int i = 0; i < n.length; i++)
			arrCopy[i] = n[i];
		return arrCopy;
	}
	
	// multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
	static int[ ] times(int[ ] n, int d) { 
		int temp = 0;
		int borrow = 0;
		int[] product = new int[0];
		for(int i = 0; i < n.length; i++) {
			temp = d * n[i] + borrow;
			if(temp > 9) {
				borrow = temp / 10;
				temp = temp % 10;
			}
			else
				borrow = 0;
			product = addDigit(product, temp);
		}
		if(borrow > 0)
			product = addDigit(product, borrow);
		return product;
	}

	// multipliziert das Ziffernfeld n mit 10
	static int[ ] times10(int[ ] n) { 
		int[] product = new int[n.length+1];
		product[0] = 0;
		for(int i = 0, j = 1; i < n.length; i++, j++)
			product[j] = n[i];
		return product;
	}

	// multipliziert zwei Ziffernfelder	
	static int[ ] times(int[ ]a, int[ ] b) { 
		int[] product = new int[0];
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
		boolean smaller = false;
		if(a.length < b.length)
			smaller = true;
		else if(a.length == b.length) {
			for(int i = a.length-1; i >= 0; i--) {
				if(a[i] < b[i]) {
					smaller = true;
					break;
				}
				else if(a[i] > b[i])
					break;
				else if(a[i] == b[i] && i != 0)
					continue;
				else if(a[i] == b[i] && i == 0)
					break;
			}
		}
		else
			smaller = false;
		return smaller;
	}

	// Test auf Gleichheit zweier Ziffernfelder
	static boolean equal (int[ ] a, int[ ] b) { 
		boolean identical = false;
		if(a.length == b.length) {
			for(int i = 0; i < a.length; i++) {
				if(a[i] == b[i])
					identical = true;
			}
		}
		return identical;
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
	
	public static void main(String[] args) {
		
		int intNr = 12345679;
		int[] arrNumber = fromInt(intNr);
		for(int i = 0; i < arrNumber.length; i++)
			System.out.print(arrNumber[i]);
		
		System.out.println();

		int[] number2 = new int[arrNumber.length+1];
		number2 = times10(arrNumber);
		for(int i = 0; i < number2.length; i++)
			System.out.print(number2[i]);
		
		System.out.println();
		
		int[] number3 = new int[arrNumber.length-1];
		number3 = div10(arrNumber);
		for(int i = 0; i < number3.length; i++)
			System.out.print(number3[i]);

		System.out.println();

		int number4 = intNr%10;
		int number5 = mod10(arrNumber);
		System.out.print("Modulo 10: " + number4 + " - Methode: " + number5);

		System.out.println();

		int[] number6 = new int[8];
		number6 = times(arrNumber, 2);
		for(int i = 0; i < number6.length; i++)
			System.out.print(number6[i]);
		
		System.out.println();

		int[] number7 = fromInt(2367546);
		System.out.print(equal(arrNumber, number7));
		
		System.out.println();

		int[] number8 = fromInt(2325);
		System.out.print(less(number7, number8)); //  number7 < number8
		System.out.println();

		System.out.println("2 Ziffernfelder addieren:");
		
		int[] number9 = fromInt(987);
		int[] number10 = add(number8, number9);
		println(number10);
		
		System.out.println("2 Ziffernfelder multiplizieren:");
		
		int[] number11 = fromInt(919);
		int[] number12 = times(number9, number11);
		println(number12);
		
		int[] number13 = times10(number11);
		println(number13);

		int[] falsearray = {1, 0, 6};
		System.out.println(ok(falsearray));
	}

}
