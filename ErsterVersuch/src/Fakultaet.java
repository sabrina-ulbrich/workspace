public class Fakultaet {
  
	public static int iterativeFactorial (int n) {
		int result = 1;
		
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	public static int iterativeDecrement (int n) {		
		for (int i = n; i > 1; i--) {
			n *= i-1;
		}
		return n;
	}
	
	public static int whileFactorial (int n) {
		int result = n;
		if(n <= 1) return 1;
		while(n > 1) {
			result *= n-1;
			n--;
		}
		return result;
	}
	
	public static int recursiveFactorial (int n) {
		if (n <= 1) {
			return 1;
		}
	    return n * recursiveFactorial(n-1);
	}
	
	public static long zweierpotenz(int n) {
		if(n == 0) return 1;
		return 2 * zweierpotenz(n - 1);
	}
	
	public static void main (String[] args) {
		int w, x, y, z;
		//long potenz;
		
		//potenz = zweierpotenz(5);
		System.out.println(zweierpotenz(5));
		
		x = iterativeFactorial(6);
		System.out.println("iterative calculation: 6! = " + x);
		
		y = recursiveFactorial(6);
		System.out.println("recursive calculation: 6! = " + y);
		
		z = whileFactorial(6);
		System.out.println("iterative while loop: 6! = " + z);
		
		w = iterativeDecrement(6);
		System.out.println("iterative decrement loop: 6! = " + w);

	}
}
