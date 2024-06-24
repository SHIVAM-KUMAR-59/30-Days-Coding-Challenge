
// The Fibonacci numbers are the numbers in the following integer sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

public class fibonacci {
    static int fib(int n) {
        int a = 0, b = 1, c;
        // Base Case
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String args[]) {
        int n = 9;
        System.out.println(fib(n)); // Output: 34
    }
};
