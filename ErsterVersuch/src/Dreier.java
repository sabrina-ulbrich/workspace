/**
 * 
 */


/**
 * @author sabrina
 *
 */
import java.util.*;

public class Dreier {
	public static void main(String[] args) {
		int n = 800;
		int[] cubes = new int[n];
		for(int i=1; i<n; i++)
			cubes[i] = i*i*i;
		
		Hashtable<Integer, Integer[][]> sums = new Hashtable<Integer, Integer[][]>();
		Integer sum = 0;
		Integer[] pair = new Integer[2];
		Integer[] reverse = new Integer[2];
		Integer[][] result = new Integer[3][2];
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n; j++) {
				sum = cubes[i] + cubes[j];
				pair[0] = cubes[i];
				pair[1] = cubes[j];
				if(sums.containsKey(sum)) {	// if not the same pair exists, add the actual pair
					result = sums.get(sum);
					for(int x = 0; x < result.length; x++) {
						if(result[x][0] != null) {
							reverse[0] = result[x][1];
							reverse[1] = result[x][0];
						}
						if(Arrays.equals(pair, result[x]) || Arrays.equals(pair, reverse))
							break;
						else {
							for(int a = 0; a < result.length; a++) {
								if(result[a][0] == null) {
									result[a][0] = pair[0];
									result[a][1] = pair[1];
									break;
								}
								if(result[2][0] != null && !resultList.contains(sum) && resultList.size() < 5)
									resultList.add(sum);
							}
						};
					}
				}
				else {	// create new key-value-pair
					Integer[][] sumTerms = new Integer[3][2];
					sumTerms[0][0] = cubes[i];
					sumTerms[0][1] = cubes[j];
					sums.put(sum, sumTerms);
				}
			}
		}
		if(resultList.size() == 5) {
			Collections.sort(resultList);
			for(int z=0; z<resultList.size(); z++)
				System.out.println(resultList.get(z));
		}
	}
}