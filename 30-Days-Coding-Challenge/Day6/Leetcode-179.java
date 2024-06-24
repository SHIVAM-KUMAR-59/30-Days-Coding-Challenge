
// 179. Largest Number ( Medium )
// Question Link - https://leetcode.com/problems/largest-number/description/
// Given a list of non-negative integers nums, arrange them such that they form
// the largest number and return it. Since the result may be very large, so you
// need to return a string instead of an integer.

class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            s[i] = String.valueOf(nums[i]);
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        return s[0].equals("0") ? "0" : String.join("", s);
    }
}