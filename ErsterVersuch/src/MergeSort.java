public class MergeSort {
	
	public static void sort(int[] array, int[] comparing, int[] writing) {
		if (array.length > 1) {
			int mitte = (int) (array.length / 2);
			int[] links = new int[mitte];
			for (int i = 0; i < mitte; i++) {
				writing[0]++;
				links[i] = array[i];
			}
			
			int[] rechts = new int[array.length - mitte];
			for (int i = mitte; i < array.length; i++) {
				writing[0]++;
				rechts[i - mitte] = array[i];
			}
			sort(links, comparing, writing);
			sort(rechts, comparing, writing);
			merge(array, links, rechts, comparing, writing);
		}
	}

	private static void merge(int[] array, int[] links, int[] rechts, int[] comparing, int[] writing) {
		int indexLinks = 0;
		int indexRechts = 0;
		int indexErgebnis = 0;
		
		while (indexLinks < links.length && indexRechts < rechts.length) {
			comparing[0]++;
			if (links[indexLinks] < rechts[indexRechts]) {
				writing[0]++;
				array[indexErgebnis++] = links[indexLinks++];
			} else {
				writing[0]++;
				array[indexErgebnis++] = rechts[indexRechts++];
			}
		}

		while (indexLinks < links.length) {
			writing[0]++;
			array[indexErgebnis++] = links[indexLinks++];
		}
		
		while (indexRechts < rechts.length) {
			writing[0]++;
			array[indexErgebnis++] = rechts[indexRechts++];
		}
	}
	
	public static void main(String[] args) {
		int[] comparing = {0};
		int[] writing = {0};
		//int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};		// min. 12 Vergleiche, 48 Schreiboperationen
		//int[] numbers = {5, 1, 6, 2, 7, 3, 8, 4};		// 16 Vergleiche, 48 Schreiboperationen
		//int[] numbers = {8, 4, 6, 2, 7, 3, 5, 1};		// max. 17 Vergleiche, 48 Schreiboperationen
		
		// 2 aufsteigend sortierte Arrays (hier in einem zusammengefasst) brauchen im Worst-case
		// mind. 2n-1 Vergleiche
		int[] numbers = {1,3,5,7,9,2,4,6,8,10};			// 19 Vergleiche, 68 Schreiboperationen
		
		sort(numbers, comparing, writing);
		System.out.println("Vergleiche: " + comparing[0] + ", Schreiboperationen: " + writing[0]);
		for(int i = 0; i < numbers.length; i++){
			System.out.print("- " + numbers[i] + " -");
		}
	}
}