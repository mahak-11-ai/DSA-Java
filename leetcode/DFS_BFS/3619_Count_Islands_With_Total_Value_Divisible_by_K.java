
/*
LeetCode 3619: Count Islands With Total Value Divisible by K

Approach: Iterative DFS + Stack

Logic:
1. Traverse every cell in the grid.
2. When a positive cell is found, start DFS.
3. Add the values of all connected land cells.
4. Mark visited cells as 0 to avoid revisiting them.
5. If the island sum is divisible by k, increment count.

Time Complexity: O(m * n)
Auxiliary Space: O(m * n)
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                long sum = grid[i][j];

                // Mark visited before adding to stack.
                grid[i][j] = 0;
                stack.push(i * n + j);

                while (!stack.isEmpty()) {
                    int cell = stack.pop();

                    int row = cell / n;
                    int col = cell % n;

                    for (int d = 0; d < 4; d++) {
                        int nr = row + dr[d];
                        int nc = col + dc[d];

                        if (nr >= 0 && nr < m &&
                            nc >= 0 && nc < n &&
                            grid[nr][nc] > 0) {

                            sum += grid[nr][nc];

                            // Mark before pushing to prevent duplicates.
                            grid[nr][nc] = 0;
                            stack.push(nr * n + nc);
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
