
public class Sort {
	
	static int[] selection(int numbers[]) {
		int minIndex;
		for(int i = 0; i <= numbers.length -1; i++){
			minIndex = minPosition(numbers, i, numbers.length -1);
			swapping(numbers, i, minIndex);
		}
		return numbers;
	}
	
	static int minPosition(int numbers[], int first, int last) {
		for(int i = first + 1; i <= last; i++) {
			if(numbers[i] < numbers[first]) first = i;
		}
		return first;
	}
	
	static void swapping(int[] numbers, int first, int smallest) {
		int temp = numbers[first];
		numbers[first] = numbers[smallest];
		numbers[smallest] = temp;
	}
	
	static void bubbleSort(int numbers[]){
		int changes = 0;
		int compare = 0;
		
		for(int k = numbers.length - 1; k > 0; k--){
			for(int i = 0; i < k; i++){
				compare++;
				if(numbers[i] > numbers[i+1]){
					swap(numbers, i, i+1);
					changes++;
				}
			}
		}
		System.out.println("Vergleiche: " + compare + ", Vertauschungen: " + changes);
	}
	
	static void selectionSort(int numbers[]){
		int last = numbers.length - 1;
		int changes = 0;
		int[] compare = {0};
		
		for(int k = 0; k < last; k++){
			int min = minPos(numbers, k, last, compare);
			if(min != k){
				swap(numbers, min, k);
				changes++;
			}
		}
		System.out.println("Vergleiche: " + compare[0] + ", Vertauschungen: " + changes);
	}
	
	static int minPos(int[] numbers, int front, int end, int[] compare){
		for(int i = front + 1; i <= end; i++){
			compare[0]++;
			if(numbers[i] < numbers[front]){
				front = i;
			}
		}
		return front;
	}
	
	static void swap(int[] numbers, int i, int j){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void main(String[] args) {
		//int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};		//minimal 0 Vertauschungen
		//int[] numbers = {8, 7, 6, 5, 4, 3, 2, 1};		//maximal 28 Vertauschungen mit bubbleSort
		int[] numbers = {5, 6, 8, 2, 4, 3, 7, 1};		//maximal 7 Vertauschungen mit selectionSort
		
		selection(numbers);
		//selectionSort(numbers);
		//bubbleSort(numbers);
		for(int i = 0; i < numbers.length; i++){
			System.out.print(numbers[i] + ", ");
		}
		
	}

}
