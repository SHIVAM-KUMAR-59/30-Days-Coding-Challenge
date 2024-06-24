
// 17. Letter Combinations of a Phone Number ( Medium )
// Question Link - https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        solve(0, new StringBuilder(), digits);
        return ans;
    }

    public void solve(int index, StringBuilder sb, String digits) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String str = findString(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            solve(index + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String findString(char ch) {
        if (ch == '2') {
            return "abc";
        }
        if (ch == '3') {
            return "def";
        }
        if (ch == '4') {
            return "ghi";
        }
        if (ch == '5') {
            return "jkl";
        }
        if (ch == '6') {
            return "mno";
        }
        if (ch == '7') {
            return "pqrs";
        }
        if (ch == '8') {
            return "tuv";
        } else {
            return "wxyz";
        }
    }
}