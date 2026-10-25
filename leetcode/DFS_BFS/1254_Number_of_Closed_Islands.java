/*
LeetCode 1254: Number of Closed Islands

Approach: DFS

Logic:
1. Land = 0, Water = 1.
2. Explore boundary-connected land first and mark it visited.
3. Traverse the remaining cells.
4. Each unvisited land cell starts a closed island.
5. Count the island and mark all its connected land visited.

Time Complexity: O(m * n)
Space Complexity: O(m * n) for the DFS recursion stack
*/

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Remove land connected to the boundary.
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int count = 0;

        // Count the remaining islands.
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || col < 0 ||
            row >= m || col >= n ||
            grid[row][col] == 1) {
            return;
        }

        // Mark the land as visited.
        grid[row][col] = 1;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
