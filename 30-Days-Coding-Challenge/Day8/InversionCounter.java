
// Write a program to count the number of inversions possible in an array.
// Inversion occurs when i < j and a[i] > a[j], where 'i' and 'j' are the index numbers of present and next element respectively, and 'a' represents array
// Eg: Input: [70,50,60,10,20,30,80,15] Output: 17

public class InversionCounter {
    public static int countInversions(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        int leftInv = countInversions(left);
        int rightInv = countInversions(right);
        int mergedInv = merge(left, right, arr);
        return leftInv + rightInv + mergedInv;
    }

    public static int merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0, inv = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                inv += left.length - i;
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return inv;
    }

    public static void main(String[] args) {
        int[] arr = { 70, 50, 60, 10, 20, 30, 80, 15 };
        int inversions = countInversions(arr);
        System.out.println("Number of inversions: " + inversions);
    }
}
