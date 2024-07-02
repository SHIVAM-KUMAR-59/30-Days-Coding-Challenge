
// 202. Happy Number ( Easy )
// Question Link - https://leetcode.com/problems/happy-number/description/
// Write an algorithm to determine if a number n is happy. A happy number is a
// number defined by the following process: Starting with any positive integer,
// replace the number by the sum of the squares of its digits. Repeat the
// process until the number equals 1 (where it will stay), or it loops endlessly
// in a cycle which does not include 1. Those numbers for which this process
// ends in 1 are happy. Return true if n is a happy number, and false if not.

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);
        return slow == 1;
    }

    public int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber obj = new HappyNumber();
        System.out.println(obj.isHappy(19)); // True
        System.out.println(obj.isHappy(2)); // False
    }

}