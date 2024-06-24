// LinkedIn Post Link - https://www.linkedin.com/posts/shivam-kumar-946614277_day2-codesprintbyusckiit-30dayscodechallenge-activity-7208151512131276801-S7ks?utm_source=share&utm_medium=member_desktop
// 1095. Find in Mountain Array ( Hard )
// Question Link - https://leetcode.com/problems/find-in-mountain-array/description/
// (This problem is an interactive problem.)
// You may recall that an array arr is a mountain array if and only if:
// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
// You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
// MountainArray.get(k) returns the element of the array at index k (0-indexed).
// MountainArray.length() returns the length of the array.
// Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Step 1: Find the peak of the mountain array
        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            int midNextValue = mountainArr.get(mid + 1);

            // Compare the current element with the next element
            if (midValue < midNextValue) {
                // If the current element is less than the next element, move to the right
                left = mid + 1;
            } else {
                // Otherwise, move to the left
                right = mid;
            }
        }

        // The left pointer will be at the peak element's index
        int peakIndex = left;

        // Step 2: Search for the target in the ascending part of the mountain
        int leftResult = binarySearch(mountainArr, target, 0, peakIndex, true);

        // If the target is found in the ascending part, return its index
        if (leftResult != -1) {
            return leftResult;
        }

        // Step 3: Search for the target in the descending part of the mountain
        int rightResult = binarySearch(mountainArr, target, peakIndex, mountainArr.length() - 1, false);

        // Return the index where the target is found in the descending part
        return rightResult;
    }

    // Helper function for binary search on the mountain array
    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                // If the current element is the target, return its index
                return mid;
            }

            if (ascending) {
                if (midValue < target) {
                    // If the current element is less than the target, move to the right
                    left = mid + 1;
                } else {
                    // If the current element is greater than the target, move to the left
                    right = mid - 1;
                }
            } else {
                if (midValue < target) {
                    // If the current element is less than the target, move to the left
                    right = mid - 1;
                } else {
                    // If the current element is greater than the target, move to the right
                    left = mid + 1;
                }
            }
        }

        // If the target is not found, return -1
        return -1;
    }
}