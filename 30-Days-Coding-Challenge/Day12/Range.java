
// 201. Bitwise AND of Numbers Range ( Medium )
// Question Link - https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
// Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

class Range {
    public int rangeBitwiseAnd(int left, int right) {
        int rightShiftCnt = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            rightShiftCnt++;
        }
        int commonPref = (right << rightShiftCnt);
        return commonPref;
    }
}
