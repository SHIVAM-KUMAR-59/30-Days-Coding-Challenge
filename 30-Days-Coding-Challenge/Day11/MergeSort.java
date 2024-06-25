
// Quick Sort using Recursion
// Merge sort is a sorting algorithm that follows the divide-and-conquer approach. It works by recursively dividing the input array into smaller subarrays and sorting those subarrays then merging them back together to obtain the sorted array.
// Time Complexity: O(n log n)

public class MergeSort {
    // Recursive function to sort the array
    public static void sort(int[] arr, int startingIndex, int endingIndex) {
        // Base Case
        if (startingIndex <= endingIndex) {
            return;
        }
        int mid = startingIndex + (endingIndex - startingIndex) / 2; // calculate middle index
        sort(arr, startingIndex, mid); // to sort the left part
        sort(arr, mid + 1, endingIndex); // to sort the right part
        merge(arr, mid, startingIndex, endingIndex); // merge the two sides
    }

    // Function to merge the left and right side
    public static void merge(int[] arr, int mid, int startingIndex, int endingIndex) {
        int temp[] = new int[endingIndex - startingIndex + 1];
        int i = startingIndex; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp array
        // Copy the elements
        while (i <= mid && j <= endingIndex) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // copy the remaining elements from left part, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // copy the remaining elements from right part, if any
        while (j <= endingIndex) {
            temp[k++] = arr[j++];
        }
        // copy the temp array back to the original array
        for (i = startingIndex, k = 0; i <= endingIndex; i++, k++) {
            arr[i] = temp[k];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 12, 3 };
        sort(arr, 0, arr.length - 1);
        System.out.println(arr); // Output: {2,3,5,8,12}
    }
}