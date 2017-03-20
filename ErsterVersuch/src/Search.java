public class Search {
	
	public static void linearSearch(int[] a, int x) {
		int compare = 0;
		
		for (int i = 0; i < a.length; i++) {
			compare++;
			if(a[i] == x) {
				System.out.println("Gefunden an Position " + i + " nach " + compare + " Vergleichen.");
				return;
			}
		}
		System.out.println("Nicht gefunden");
	}
	
	public static void binarySearch(int[] a, int x) {
		int left = 0;
		int compare = 0;
	    int right = a.length - 1;
	    int middle;
	    
	    while(left <= right) {     
	    	middle = (left + right) / 2;
	    	compare++;
	        if(a[middle] == x) {
	        	System.out.println("Gefunden an Position " + middle + " nach " + compare + " Vergleichen.");
	        	return;
	        }
	        if(a[middle] < x)	left = middle + 1;		// search on the right side
	        else 				right = middle - 1;		// search on the left side
	    }    
	    System.out.println("Nicht gefunden");
	}

	public static void main (String argv[]) {
	    int[] numbers = { 3, 1, 8, 5, 7, 4, 2, 6 };
	    int[] numSort = { 1, 2, 3, 4, 5, 6, 7, 8 };
	    
	    linearSearch(numbers, 6);
	    binarySearch(numSort, 8);
	}
}