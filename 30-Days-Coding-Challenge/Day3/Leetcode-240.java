

// 240. Search a 2D Matrix II
// Question Link - https://leetcode.com/problems/search-a-2d-matrix-ii/description/
// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start from the top-right corner
        int i = 0;
        int j = matrix[0].length - 1;
        while (j >= 0 && i < matrix.length) {
            if (matrix[i][j] == target)
                return true;
            if (j - 1 >= 0 && matrix[i][j - 1] < target) {
                i++;
            } else {
                if (j - 1 < 0)
                    i++;
                else
                    j--;
            }
        }
        return false;
    }
}