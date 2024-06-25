
// Search in Rotated Sorted Array ( Medium )
// Question Link - https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. You must write an algorithm with O(log n) runtime complexity.

public class SearchArray {
    public static int Search(int[] arr, int target, int startingIndex, int endingIndex) {
        // Base Case
        if (startingIndex > endingIndex) {
            return -1;
        }
        int mid = startingIndex + (endingIndex - startingIndex) / 2;
        if (arr[startingIndex] < arr[mid]) {
            if (target >= arr[startingIndex] && target <= arr[mid]) {
                return Search(arr, target, startingIndex, mid - 1);
            } else {
                return Search(arr, target, mid + 1, endingIndex);
            }
        } else {
            if (arr[mid] <= target && target <= arr[endingIndex]) {
                return Search(arr, target, mid + 1, endingIndex);
            } else {
                return Search(arr, target, startingIndex, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2 };
        int target = 2;
        int n = arr.length;
        int result = Search(arr, target, 0, n - 1);
        if (result != -1) {
            System.out.println("Element found at index " + result); // This line will be printed
        } else {
            System.out.println("Element not found");
        }
    }
}
