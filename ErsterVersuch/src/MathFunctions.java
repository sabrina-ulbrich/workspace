
public class MathFunctions {
	
	public static boolean isPrime(int n) {
		int temp = 2;
		while(temp < n) {
			if(n % temp == 0) return false;
			temp++;
		}
		return true;
	}
	
	public static long ggTiterativ(long n, long m) {
		int count = 0;
		while(n != m) {
			count++;
			if(n > m) n -= m;
			else m -= n;
		}
		System.out.print(count);
		return n;
	}
	
//	public static long ggTrekursiv(long n, long m) {
//		if(n == m) return n;
//		if(n > m) return ggTrekursiv(n-m, m);
//		else return ggTrekursiv(n, m-n);
//	}
	
	public static long ggTrekursiv(long n, long m) {
		if(n == 0 || m == 0) return n + m;
		if(n > m) return ggTrekursiv(n % m, m);
		else return ggTrekursiv(n, m % n);
	}
	
	public static long ggTmodulo(long x, long y) {
		int count = 0;
		while((x > 0) && (y > 0)) {
			count++;
			if(x >= y) x = x % y;
			else y = y % x;
		}
		System.out.print(count);
		return x + y;
	}
	
	public static int quersumme(long n){
		int result = 0;
		while(n > 0) {
			result += n % 10;
			n = n / 10;
		}
		return result;
	}
	
	public static long qsRekursiv(long n, long result) {
		if(n == 0) return result;
		result += n % 10;
		return qsRekursiv(n / 10, result);
	}
	
	public static String writeBin(int n) {
		String binary = "";
		while (n > 0) {
			binary = n % 2 + binary;
			n = n / 2;
		}
		return binary;
	}
	
	public static void main(String[] args) {
		long x = 65432;
		long y = 98;
		int z = 8;
		double var2 = 5. / 2.;
		
		System.out.println(6%18);
		System.out.println(var2);
		System.out.println(isPrime(101));
		System.out.println("greatest common divisor of " + x + " and " + y + " is: ");
		System.out.print("with ");
		System.out.println(" while loop iterations: " + ggTiterativ(x, y));
		System.out.println("recursive procedure: " + ggTrekursiv(x, y));
		System.out.print("just ");
		System.out.println(" loop iterations with modulo: " + ggTmodulo(6, 18));
		System.out.println("sum of the digits of " + x + " is: " + quersumme(x));
		System.out.println("sum of the digits with recursive procedure: " + qsRekursiv(x, 0));
		System.out.println("binary representation of " + z + " is: " + writeBin(z));
		System.out.println(4 + 5.1 + 6.23e-10 + 0x1E);
		System.out.println(1 + 4.4 + "3" + 10/4 * 0.5);			//5.431.0
	}

}
