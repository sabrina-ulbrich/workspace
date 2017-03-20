/**
 * 
 */

/**
 * @author sabrina
 *
 */
public class Pyramide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int rows = Integer.parseInt(args[0]);
		
		for(int i = rows-1; i > 0; i--)
			System.out.print(" ");
		if(rows > 0)
			System.out.println("*");
		for(int i = rows-2, r = 1; i > 0; i--, r=r+2) {
			for(int j = i; j > 0; j--)
				System.out.print(" ");
			System.out.print("*");
			for(int k = r; k > 0; k--)
				System.out.print(" ");
			System.out.println("*");
		}
		if(rows > 1)
			for(int i = rows; i > 0; i--)
				System.out.print("* ");
		System.out.println("");
	}
}