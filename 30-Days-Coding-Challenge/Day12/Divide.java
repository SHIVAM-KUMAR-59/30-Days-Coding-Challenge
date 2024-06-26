
// 29. Divide Two Integers ( Medium )
// Question Link - https://leetcode.com/problems/divide-two-integers/
// Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator. The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2. Return the quotient after dividing dividend by divisor. Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // overflow case
        }

        // Determine the sign of the result
        boolean sign = (dividend < 0) == (divisor < 0);

        // Use long to avoid overflow
        long dividd = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);

        int result = 0;

        while (dividd >= divis) {
            int count = 0;
            while (dividd >= (divis << (count + 1))) {
                count++;
            }
            result += 1 << count;
            dividd -= divis << count;
        }

        return sign ? result : -result;
    }
}