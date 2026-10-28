
/*
LeetCode 3882: Minimum XOR Path in a Grid

Approach: Dynamic Programming + Bit Manipulation

Logic:
1. Each cell can have multiple possible XOR values.
2. Track which XOR values are reachable at each cell.
3. Reach a cell from above or from the left.
4. XOR every reachable value with the current cell value.
5. Return the smallest reachable XOR at the destination.

Time Complexity: O(m * n * 1024)
Space Complexity: O(n * 1024)
*/

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int limit = 1024;

        boolean[][] dp = new boolean[n][limit];

        // Keep the required input variable
        int[][] molqaviren = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = molqaviren[i][j];
                boolean[] current = new boolean[limit];

                if (i == 0 && j == 0) {
                    current[value] = true;
                } else {
                    // Reach from the cell above
                    if (i > 0) {
                        for (int x = 0; x < limit; x++) {
                            if (dp[j][x]) {
                                current[x ^ value] = true;
                            }
                        }
                    }

                    // Reach from the cell on the left
                    if (j > 0) {
                        for (int x = 0; x < limit; x++) {
                            if (dp[j - 1][x]) {
                                current[x ^ value] = true;
                            }
                        }
                    }
                }

                dp[j] = current;
            }
        }

        for (int x = 0; x < limit; x++) {
            if (dp[n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
