
// Find the first and last occurrence of a given number in a sorted array

public class occurence {

    public static int FirstOccurrence(int[] arr, int key, int i) {
        // Base Case
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return FirstOccurrence(arr, key, i + 1);
    }

    public static int LastOccurrence(int[] arr, int key, int i) {
        // Base Case
        if (i == -1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return LastOccurrence(arr, key, i - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        System.out.println(FirstOccurrence(arr, 3, 0)); // Output: 1
        System.out.println(LastOccurrence(arr, 3, arr.length - 1)); // Output: 8
    }
}
