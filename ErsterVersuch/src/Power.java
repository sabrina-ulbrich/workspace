//import java.util.*;

public class Power {
//	private static int base = 2;
//	private static int exponent = 9989;
//	private static int[] last = { 1 };
//	private static int[] current;
//	private static int size = 2;

	public static void main(String[] args) {
		int[] result = times(new int[] { 6, 1 }, 2);
		output(result);

		result = times(new int[] { 4, 6 }, 2);
		output(result);

		result = times(new int[] { 2, 1, 5 }, 2);
		output(result);

		result = times(new int[] { 2, 9, 1, 8 }, 2);
		output(result);
	}

	public static int[] times(int[] n, int d) {
		int[] result = new int[n.length];
		int[] temp = new int[0];
		int[] carry = Null();
		for (int i = 0; i < n.length; i++) {
			// split tmp into ziffernfeld
			// add each digit of the ziffernfeld to result, carrying over at each digit
			//int tmp = d * n[i] + result[i];
			temp = fromInt(d * n[i] + carry[0]); //result[i]);
			carry = Null();
			result[i] = mod10(temp); //tmp % 10;
			if (less(fromInt(9), temp)) { //(tmp > 9) {
				if (i + 1 >= result.length) {
					result = addField(result);//Arrays.copyOf(result, result.length + 1);
				}
				carry = copy(div10(temp)); // result[i + 1] += div10(temp); //tmp / 10;
			}
		}
		if(ok(carry) && carry[0] > 0) {
			result[result.length-1] = carry[0];
		}
		return result;
	}

	static int[] addField (int[] n) {
		int[] result = new int[n.length + 1];
		for(int i = 0; i < n.length; i++) {
			  result[i] = n[i];
		}
		//result[result.length - 1] = d;
		return result;
	}

	static int[ ] copy(int[ ] n) { 
		int[] arrCopy = new int[n.length];
		for(int i = 0; i < n.length; i++) {
			arrCopy[i] = n[i];
		}
		return arrCopy;
	}
	
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
	
	static int[ ] fromInt(int n) {
		int[] intArr = new int[0];
		while (n > 0) {
			intArr = addDigit(intArr, n % 10);
			n /= 10;
		}
		return intArr;
	}

	static int[] addDigit (int[] n, int d) {
		int[] result = new int[n.length + 1];
		for(int i = 0; i < n.length; i++) {
			  result[i] = n[i];
		}
		result[result.length - 1] = d;
		return result;
	}
	
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
	
	static int[ ] Null() { 
		int[] digitZero = {0};
		return digitZero;
	}
	
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
//	public static int[] times(int[] n, int d) {
//		int[] result = new int[n.length];
//		for (int i = 0; i < n.length; i++) {
//			result[i] += d * n[i];
//			if (result[i] >= 10) {
//				result = carryOver(result, i);
//			}
//		}
//		return result;
//	}
//
//	public static int[] carryOver(int[] result, int i) {
//		if (i + 1 >= result.length) {
//			result = Arrays.copyOf(result, result.length + 1);
//		}
//		int carry = result[i] / 10;
//		result[i] %= 10;
//		result[i + 1] += carry;
//		return result;
//	}	
	
	private static void output(int[] array) {
		// int start = array[array.length - 1] == 0 ? array.length - 2 : array.length - 1;
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i]);
		}		
		System.out.println();
	}
//	for (int z = 0; z < exponent; z++) {
//	current = new int[size];
//	for (int i = 0; i < last.length; i++) {
//		current[i] += 2 * last[i];
//		carryOver(i);
//	}
//	last = current;
//	for (int i = current.length - 1; i > current.length - 2; i--) {
//		if (current[i] != 0) {
//			size++;
//		}
//	}
//}
}