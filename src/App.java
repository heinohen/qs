import java.util.Arrays;

public class App {

    
    public static void main(String[] args) throws Exception {

        String[] A = {"c","d","b","a"};
        System.out.println(Arrays.toString(A));
        quicksort(A, 0, A.length-1);
        System.out.println(Arrays.toString(A));


    }


    public static int partition(String[] A, int left, int right, String pivot) {
        while (left <= right) { // Move bounds inward until they meet
            while (A[left].compareTo(pivot) < 0) left++;
                while ((right >= left) && (A[right].compareTo(pivot) >= 0)) right--;
                    if (right > left) {
                        swap(A, left, right); // Swap out-of-place values
                    }
        }
        return left;            // Return first position in right partition
    }

    public static void quicksort(String[] A, int i, int j) { // Quicksort
        int pivotindex = A.length - 1;  // Pick a pivot
        swap(A, pivotindex, j);               // Stick pivot at end
        // k will be the first position in the right subarray
        int k = partition(A, i, j-1, A[j]);
        swap(A, k, j);                        // Put pivot in place
        if ((k-i) > 1) quicksort(A, i, k-1);  // Sort left partition
        if ((j-k) > 1) quicksort(A, k+1, j);  // Sort right partition
    }


    public static void swap(String[] A, int k, int j) {
        String temp = A[k];
        A[k] = A[j];
        A[j] = temp;
    }

}
