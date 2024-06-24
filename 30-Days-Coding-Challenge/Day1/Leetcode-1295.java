// LinkedIn Post Link - https://www.linkedin.com/posts/shivam-kumar-946614277_day1-codesprintbyusckiit-30dayscodechallenge-activity-7207772675119669249-XLph?utm_source=share&utm_medium=member_desktop

// 1295. Find Numbers with Even Number of Digits ( Easy )
// Question Link - https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
// Given an array nums of integers, return how many of them contain an even number of digits.

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) {
                count++;
            }
        }
        return count;
    }

    boolean even(int num) {
        int numberofdigits = digits(num);
        return numberofdigits % 2 == 0;
    }

    int digits(int num) {
        if (num < 0) {
            num = num * -1;
        }
        return (int) (Math.log10(num)) + 1;
    }
}