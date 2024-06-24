// LinkedIn Post Link - https://www.linkedin.com/posts/shivam-kumar-946614277_day2-codesprintbyusckiit-30dayscodechallenge-activity-7208151512131276801-S7ks?utm_source=share&utm_medium=member_desktop

// 15. 3Sum ( Medium )
// Question Link - https://leetcode.com/problems/3sum/description/
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}