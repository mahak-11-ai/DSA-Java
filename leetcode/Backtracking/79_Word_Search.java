
/*
LeetCode 79: Word Search

Approach: DFS + Backtracking

Logic:
1. Start searching from every cell.
2. If the character matches, explore all four directions.
3. Mark the current cell as visited.
4. If the entire word is found, return true.
5. Restore the cell while backtracking.

Time Complexity: O(m * n * 3^L)
Space Complexity: O(L)

m = number of rows
n = number of columns
L = length of the word
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 ||
            board[0].length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found =
            dfs(board, word, row + 1, col, index + 1) ||
            dfs(board, word, row - 1, col, index + 1) ||
            dfs(board, word, row, col + 1, index + 1) ||
            dfs(board, word, row, col - 1, index + 1);

        board[row][col] = temp;

        return found;
    }
}
