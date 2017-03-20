/**
 * 
 */

/**
 * @author sabrina
 *
 */
public class Zweier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    int limit = 40;
	    int nr1, nr2, nr3, nr4 = 0;

	    for(int i=1; i <= limit; i++) {
	      nr1 = i*i*i;
	      for(int j=1; j <= limit; j++) {
	        nr2 = j*j*j;
	        for(int k=j+1; k <= limit; k++) {
	          nr3 = k*k*k;
	          for(int l=k+1; l <= limit; l++) {
	            nr4 = l*l*l;
	            if(nr1 + nr2 == nr3 + nr4) {
	              System.out.println(nr1+nr2);
	            }
	          }
	        }
	      }
	    }
	}
}
