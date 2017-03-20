/**
 * 
 */


public class arrays {
	public static void main(String[] args) {
		// 4 x 5 String arrays, all Strings are null
		// [0] -> [null,null,null,null,null]
		// [1] -> [null,null,null,null,null]
		// [2] -> [null,null,null,null,null]
		// [3] -> [null,null,null,null,null]

		String[][] sa1 = new String[4][5];
		for(int i = 0; i < sa1.length; i++) {           // sa1.length == 4
		    for (int j = 0; j < sa1[i].length; j++) {     //sa1[i].length == 5
		        sa1[i][j] = i + ", " + j;
		        // System.out.println(sa1[i][j]);
		    }
		}
		// 3 x 2 Integer arrays: 3 ways with 2 numbers a time
		// [0] -> [0,0]
		// [1] -> [0,0]
		// [2] -> [0,0]

		int[][] number = new int[3][2];
		for(int i = 0; i < number.length; i++) {           // number.length == 3
		    for (int j = 0; j < number[i].length; j++) {     // number[i].length == 2
		        number[i][j] = i;
		        System.out.println(number[i][j]);
		    }
		}

	}

}
