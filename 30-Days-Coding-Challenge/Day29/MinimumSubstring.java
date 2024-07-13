
/*  You are given two strings, s (the "source" string) and t (the "target" string). Your task is to find the minimum window in s which contains all characters from t in any order. If there is no such window in s that covers all characters in t, return an empty string "". 
Ex:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
*/

public class MinimumSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }

    public static void main(String[] args) {
        MinimumSubstring ms = new MinimumSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(ms.minWindow(s, t));
    }

}
