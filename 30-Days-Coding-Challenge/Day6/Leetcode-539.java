
// 539. Minimum Time Difeference ( Medium )
// Question Link - https://leetcode.com/problems/minimum-time-difference/description/
// Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        int[] nums = new int[timePoints.size()];
        for (int i = 0; i < nums.length; i++) {
            String s = timePoints.get[i];
            nums[i] = Integer.paseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    min = Math.min(min, Math.abs(nums[i] + 1440 - nums[j]));
                    min = Math.min(min, Math.abs(nums[j] - nums[i]));
                }
            }
            return min;
        }
    }
}