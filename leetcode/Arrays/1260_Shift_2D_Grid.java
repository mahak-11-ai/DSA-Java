/*
Problem: 1260. Shift 2D Grid

Approach: Simulation

Key Idea:
- Each shift moves every element one position to the right.
- The last element of each row moves to the beginning of the
  next row.
- The last element of the entire grid moves to the beginning
  of the first row.

Example:

grid = [
    [1,2,3],
    [4,5,6],
    [7,8,9]
]

After 1 shift:

[
    [9,1,2],
    [3,4,5],
    [6,7,8]
]

After k shifts, repeat the same operation k times.


Important:
Instead of physically shifting the whole grid k times,
we can reduce k using:

k = k % (m * n)

because after m*n shifts, the grid becomes exactly the
same as the original grid.

where:
m = number of rows
n = number of columns


Time Complexity: O(k * m * n)

Space Complexity: O(1) extra space
(excluding the returned grid)


What I Learned:
- A 2D grid can be treated as a sequence of elements.
- The last element wraps around to the first position.
- k % totalElements avoids unnecessary complete rotations.
*/

import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        k = k % (m * n);

        List<List<Integer>> result = new ArrayList<>();

        // Perform the shift k times
        for (int shift = 0; shift < k; shift++) {

            int last = grid[m - 1][n - 1];

            // Shift elements from right to left
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    if (i == 0 && j == 0) {
                        grid[i][j] = last;
                    } 
                    else if (j == 0) {
                        grid[i][j] = grid[i - 1][n - 1];
                    } 
                    else {
                        grid[i][j] = grid[i][j - 1];
                    }
                }
            }
        }

        // Convert grid into List<List<Integer>>
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }

            result.add(row);
        }

        return result;
    }
}