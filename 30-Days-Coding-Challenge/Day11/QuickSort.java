
// Quick Sort using Recursion
// QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks an element as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.
// Time Complexity: O(n log n)

public class QuickSort {
    public static void Sort(int[] arr, int startingIndex, int endingIndex) {
        // Base Case
        if (startingIndex >= endingIndex) {
            return;
        }
        int pivotIndex = partition(arr, startingIndex, endingIndex); // Last Element
        Sort(arr, startingIndex, pivotIndex - 1); // Left Part
        Sort(arr, pivotIndex + 1, endingIndex);
    }

    public static int partition(int[] arr, int startingIndex, int endingIndex) {
        int pivot = arr[endingIndex];
        int i = startingIndex - 1; // to make place for elements smaller than pivot
        for (int j = startingIndex; j < endingIndex; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // swap
        int temp = pivot;
        arr[endingIndex] = arr[i];
        arr[i] = temp;

    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 6, 1, };
        Sort(arr, 0, arr.length - 1);
        System.out.println(arr); // {1,2,5,6,8 }
    }
}
