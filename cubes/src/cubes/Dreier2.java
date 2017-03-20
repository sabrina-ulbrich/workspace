/**
 * 
 */
package cubes;

/**
 * @author sabrina
 *
 */
import java.util.*;

public class Dreier {
	public static void main(String[] args) {
		int n = 10;
		int[] cubes = new int[n];
		for(int i=1; i<n; i++)
			cubes[i] = i*i*i;
		System.out.println(Arrays.toString(cubes));
		
		Hashtable<Integer, Integer[][]> sums = new Hashtable<Integer, Integer[][]>();
		int sum = 0;
		Integer[][] result = new Integer[3][2];
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++) {
				sum = cubes[i] + cubes[j];
				if(sums.containsKey(sum)) {
					// if not the same pair exists, add the actual pair
					/*if(sums.key(sum).hasValue() || sums.key(sum).hasValue()) {
						sums.key(sum).addtoarray(cubes[i], cubes[j]);
						if(sums.hasValue.length(3))
							System.out.println(sums.key(sum));
					}*/
					// print, if there are 3 pairs
					System.out.println("already exists" + sum);
				}
				else {
					// create new key-value-pair
					// ArrayList sumTerms = new ArraList
					Integer[][] sumTerms = new Integer[3][2];
					sumTerms[0][0] = cubes[i];
					sumTerms[0][1] = cubes[j];
					sums.put(sum, sumTerms);
					result = sums.get(sum);
					System.out.println(result);
				}
				//System.out.println(((Integer[][]) sums.get(sum))[i]);
			}
		}
	}
}
