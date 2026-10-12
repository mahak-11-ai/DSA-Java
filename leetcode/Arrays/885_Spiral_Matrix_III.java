
/*
LeetCode 885: Spiral Matrix III

Approach: Simulation

Direction order:
Right -> Down -> Left -> Up

Step lengths:
1, 1, 2, 2, 3, 3, ...

Logic:
1. Start from (rStart, cStart).
2. Move in a spiral pattern.
3. Store coordinates only when inside the grid.
4. Stop after visiting rows * cols cells.

Time Complexity: O(max(rows, cols)^2)
Auxiliary Space: O(1), excluding the output array.
*/

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols,
                                   int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];

        int[][] directions = {
            {0, 1},   // Right
            {1, 0},   // Down
            {0, -1},  // Left
            {-1, 0}   // Up
        };

        int r = rStart;
        int c = cStart;
        int index = 0;
        int steps = 1;
        int dir = 0;

        ans[index++] = new int[]{r, c};

        while (index < rows * cols) {
            for (int count = 0; count < 2; count++) {
                int dr = directions[dir][0];
                int dc = directions[dir][1];

                for (int s = 0; s < steps; s++) {
                    r += dr;
                    c += dc;

                    if (r >= 0 && r < rows &&
                        c >= 0 && c < cols) {
                        ans[index++] = new int[]{r, c};

                        if (index == rows * cols) {
                            return ans;
                        }
                    }
                }

                dir = (dir + 1) % 4;
            }

            steps++;
        }

        return ans;
    }
}
