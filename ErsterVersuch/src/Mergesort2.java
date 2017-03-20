public class Mergesort2 { 

    public static int[] intArr = { 53, 41, 52, 26, 38, 7, 49, 9 };

    public int[] sort(int left, int right) { 
        if (left < right) { 
            int q = (left + right) / 2; 
             
            sort(left, q); 
            sort(q + 1, right); 
            merge(left, q, right); 
        } 
        return intArr; 
    } 

    private void merge(int left, int q, int right) { 
        int[] arr = new int[intArr.length];
        int i, j;
        for (i = left; i <= q; i++) {
            arr[i] = intArr[i]; 
        } 
        for (j = q + 1; j <= right; j++) {
            arr[right + q + 1 - j] = intArr[j]; 
        } 
        i = left; 
        j = right; 
        for (int k = left; k <= right; k++) { 
            if (arr[i] <= arr[j]) { 
                intArr[k] = arr[i]; 
                i++; 
            } else { 
                intArr[k] = arr[j]; 
                j--; 
            } 
        } 
    } 

    public static void main(String[] args) { 
        Mergesort2 ms = new Mergesort2(); 
        int[] arr = ms.sort(0, intArr.length - 1);
        for (int i = 0; i < arr.length; i++) { 
            System.out.println(i + 1 + ": " + arr[i]); 
        } 
    } 
} 