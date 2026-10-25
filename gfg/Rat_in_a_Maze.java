
/*
GeeksforGeeks: Rat in a Maze

Approach: DFS + Backtracking

Logic:
1. Start from cell (0, 0).
2. Explore valid directions: Down, Left, Right, Up.
3. Use StringBuilder to maintain the current path.
4. Mark cells as visited to avoid cycles.
5. Backtrack by removing the last move and restoring the cell.
6. Store each valid path when the destination is reached.

Time Complexity: Exponential in the worst case O(4^n*n) or O(4^(n^2))
Auxiliary Space: O(n^2), including recursion stack
*/

import java.util.ArrayList;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();

        if (maze == null || maze.length == 0 ||
            maze[0].length == 0 || maze[0][0] == 0) {
            return ans;
        }

        int n = maze.length;

        if (maze[n - 1][n - 1] == 0) {
            return ans;
        }

        StringBuilder path = new StringBuilder();
        getAllCombinations(0, 0, maze, ans, path);

        return ans;
    }

    private void getAllCombinations(
            int row, int col, int[][] maze,
            ArrayList<String> ans, StringBuilder path) {

        int n = maze.length;

        if (row < 0 || col < 0 ||
            row >= n || col >= n ||
            maze[row][col] == 0 || maze[row][col] == -1) {
            return;
        }

        if (row == n - 1 && col == n - 1) {
            ans.add(path.toString());
            return;
        }

        int temp = maze[row][col];
        maze[row][col] = -1;

        // Down
        path.append('D');
        getAllCombinations(row + 1, col, maze, ans, path);
        path.deleteCharAt(path.length() - 1);

        // Left
        path.append('L');
        getAllCombinations(row, col - 1, maze, ans, path);
        path.deleteCharAt(path.length() - 1);

        // Right
        path.append('R');
        getAllCombinations(row, col + 1, maze, ans, path);
        path.deleteCharAt(path.length() - 1);

        // Up
        path.append('U');
        getAllCombinations(row - 1, col, maze, ans, path);
        path.deleteCharAt(path.length() - 1);

        maze[row][col] = temp;
    }
}
