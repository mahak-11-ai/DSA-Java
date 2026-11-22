
/*
Problem: LeetCode 240 - Search a 2D Matrix II

Approach: Staircase Search

1. Start searching from the top-right corner of the matrix.
2. Compare the current element with the target.
3. If both are equal, return true.
4. If the current element is smaller than the target,
   move down to the next row.
5. If the current element is greater than the target,
   move left to the previous column.
6. Continue until the target is found or the search
   goes outside the matrix.

Why does this work?
- Every row is sorted in ascending order.
- Every column is sorted in ascending order.
- Moving down eliminates the current row's remaining
  candidates to the left.
- Moving left eliminates the current column's remaining
  candidates below.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            } 
            else if (matrix[row][col] < target) {
                row++;
            } 
            else {
                col--;
            }
        }

        return false;
    }
}
