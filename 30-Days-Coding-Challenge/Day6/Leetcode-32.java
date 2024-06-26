
// 32. Longest Valid Parentheses ( Hard )
// Question Link - https://leetcode.com/problems/longest-valid-parentheses/description/
// Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
// substring.

class Solution {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                l++;
            else
                r++;
            if (l == r) {
                ans = Math.max(ans, l + r);
            } else if (r > l) {
                l = r = 0;
            }
        }
        l = r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                l++;
            else
                r++;
            if (l == r) {
                ans = Math.max(ans, l + r);
            } else if (l > r) {
                l = r = 0;
            }
        }
        return ans;
    }
}