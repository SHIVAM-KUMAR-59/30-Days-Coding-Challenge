
/*  You are given a string s consisting of lowercase English letters. Your task is to count the number of distinct non-empty subsequences of s. A subsequence of a string is obtained by deleting zero or more characters from the string without changing the order of the remaining characters.
Ex: 
   Input: s = "abc"
   Output: 7
*/

import java.util.Arrays;

public class Count_subsequences {
    static final int MAX_CHAR = 256;

    // Returns count of distinct subsequences of str.
    static int countSub(String str) {
        int[] last = new int[MAX_CHAR];
        Arrays.fill(last, -1);
        int n = str.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        // Traverse through all lengths from 1 to n.
        for (int i = 1; i <= n; i++) {

            dp[i] = 2 * dp[i - 1];
            if (last[(int) str.charAt(i - 1)] != -1)
                dp[i] = dp[i] - dp[last[(int) str.charAt(i - 1)]];

            // Mark occurrence of current character
            last[(int) str.charAt(i - 1)] = (i - 1);
        }

        return dp[n];
    }

    // Driver code
    public static void main(String args[]) {
        System.out.println(countSub("abc"));
    }
}
