
// Factorial of a non-negative integer is the multiplication of all positive integers smaller than or equal to n. For example factorial of 6 is 6*5*4*3*2*1 which is 720. 

class factorial {
    // method to find factorial of given number
    static int Factorial(int n) {
        if (n == 0)
            return 1;

        return n * Factorial(n - 1);
    }

    // Driver method
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " is " + Factorial(5)); // Output: 120
    }
}