
// Tiling Problem
// Given a ' 2 x n ' board and tiles of size ' 2 x 1 ', count the number of ways to tile the given board using ' 2 x 1 ' tiles. ( A tile can be placed horizontally or vertically )

public class Tiling {

    public static int TilingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int verticalTiles = TilingProblem(n - 1);
        int horizontalChoice = TilingProblem(n - 2);
        int TotalWays = verticalTiles + horizontalChoice;
        return TotalWays;
    }

    public static void main(String[] args) {
        System.out.println(TilingProblem(4)); // ans: 5
    }
}