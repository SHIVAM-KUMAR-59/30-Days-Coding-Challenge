
// 443. String Compression ( Medium )
// Question Link - https://leetcode.com/problems/string-compression/description/
// Given an array of characters chars, compress it using the following algorithm:
// Begin with an empty string s. For each group of consecutive repeating characters in chars:
// If the group's length is 1, append the character to s.
// Otherwise, append the character followed by the group's length.
// The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
// After you are done modifying the input array, return the new length of the array.
// You must write an algorithm that uses only constant extra space.

class Solution {
    public int compress(char[] chars) {
        char previousChar = chars[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();

        // STEP-1 : iterate through input array
        for (int i = 1; i < chars.length; i++) {
            char currentChar = chars[i];

            // STEP-2 : if current char is matched with previous char, then increase the
            // count
            if (previousChar == currentChar) {
                count++;
            }
            // STEP-3 : else add the character and count in the answer String builder
            else {
                sb.append(previousChar);
                if (count > 1)
                    sb.append(count);
                previousChar = currentChar;
                count = 1;
            }
        }
        sb.append(previousChar);
        if (count > 1)
            sb.append(count);

        // STEP-4 : copy answer from StringBuilder to input array
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}