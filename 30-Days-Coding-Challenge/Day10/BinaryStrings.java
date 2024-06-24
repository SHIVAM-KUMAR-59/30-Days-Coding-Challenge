
// Binary Strings Problem
// Print all binary stringd of size 'N' without consecutive ones

public class BinaryStrings {
    public static void PrintString(int n, int LastPlace, String str) {

        // Base Case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        PrintString(n - 1, 0, str + "0");
        if (LastPlace == 0) {
            PrintString(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        PrintString(n, 0, "");
    }
}
