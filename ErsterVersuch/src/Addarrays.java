
public class Addarrays {

	static void output (int[] n) {
		for (int i = n.length - 1; i >= 0; i--) {
			System.out.print(n[i]);
		}		
		System.out.println();
	}

	static int[ ] Null() { 
		int[] digitZero = {0};
		return digitZero;
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
	
	static int[ ] fromInt(int n) {
		int[] intArr = new int[0];
		if(n == 0) {
			return Null();
		}
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

	static int[] addField (int[] n) {
		int[] result = new int[n.length + 1];
		for(int i = 0; i < n.length; i++) {
			  result[i] = n[i];
		}
		return result;
	}
	
	static int[ ] copy(int[ ] n) { 
		int[] arrCopy = new int[n.length];
		for(int i = 0; i < n.length; i++) {
			arrCopy[i] = n[i];
		}
		return arrCopy;
	}
	
	public static int[] times(int[] n, int d) {
		int[] result = new int[n.length];
		int[] temp = Null();
		int[] carry = Null();
		for (int i = 0; i < n.length; i++) {
			temp = fromInt(d * n[i] + carry[0]);
			carry = Null();
			result[i] = mod10(temp);
			if (less(fromInt(9), temp)) {
				if (i + 1 >= result.length) {
					result = addField(result);
				}
				carry = copy(div10(temp));
			}
		}
		if(carry[0] > 0) {
			result[result.length-1] = carry[0];
		}
		return result;
	}
	
	static int[] add(int[] a, int[]b) {
		int[] sum = new int[b.length];
		int[] temp = Null();
		int[] carry = Null();
		for(int i = 0; i < b.length || i < b.length; i++) {
			if(i >= a.length) {
				temp = fromInt(b[i] + carry[0]);
			}
			else if(i >= b.length) {
				temp = fromInt(a[i] + carry[0]);
			}
			else {
				temp = fromInt(a[i] + b[i] + carry[0]);
			}
			carry = Null();
			sum[i] = mod10(temp);
			if (less(fromInt(9), temp)) {
				if (i + 1 >= sum.length) {
					sum = addField(sum);
				}
				carry = copy(div10(temp));
			}
		}
		if(carry[0] > 0) {
			sum[sum.length-1] = carry[0];
		}
		return sum;
	}
	
	static int mod10(int[ ] n) { 
		return n[0];
	}

	static int[ ] div10(int[ ] n) { 
		int[] quotient = new int[n.length-1];
		for(int i = 0, j = 1; j < n.length; i++, j++) {
			quotient[i] = n[j];
		}
		return quotient;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		int[] result = add(new int[] { 3, 4, 9, 1 }, new int[] { 0, 9, 3, 7, 8 });
		output(result);
		
		int[] result2 = add(new int[] { 1, 9, 9, 8 }, new int[] { 0, 1, 9, 9, 8 });
		output(result2);
		
	    long endTime = System.currentTimeMillis();
	    System.out.println("Total execution time: " + (endTime-startTime) + "ms");
	}

}
