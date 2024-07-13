
/* You are given a grid with dimensions n x m, where each cell in the grid is either free (0) or has an obstacle (1). You need to find the number of unique paths from the top-left corner (0,0) to the bottom-right corner (n-1,m-1) of the grid. You can only move either down or right at any point in time, and you cannot move through obstacles.
Ex: 
   Input grid = [[0,0,0], [0,1,0], [0,0,0]] , n = 3, m = 3
   Output = 2
*/

public class UniquePath {
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, {
                0, 0, 0 } };
        int n = 3, m = 3;
        System.out.println(uniquePaths(grid, n, m));
    }

    public static int uniquePaths(int[][] grid, int n, int m) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else if (grid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j
                            - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
