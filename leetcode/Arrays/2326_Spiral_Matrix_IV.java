
/*
LeetCode 2326: Spiral Matrix IV

Approach: Boundary Traversal + Linked List

Logic:
1. Initialize an m x n matrix with -1.
2. Traverse in spiral order:
   Right -> Down -> Left -> Up
3. Fill each cell using the current linked-list node.
4. Move to curr.next after inserting a value.
5. Stop when the list ends or the matrix is filled.

Time Complexity: O(m * n)
Auxiliary Space: O(1), excluding the output matrix.
*/

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];

        // Initialize all cells with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = -1;
            }
        }

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        ListNode curr = head;

        while (curr != null && top <= bottom && left <= right) {

            // Left to right
            for (int j = left; j <= right && curr != null; j++) {
                ans[top][j] = curr.val;
                curr = curr.next;
            }
            top++;

            // Top to bottom
            for (int i = top; i <= bottom && curr != null; i++) {
                ans[i][right] = curr.val;
                curr = curr.next;
            }
            right--;

            // Right to left
            if (top <= bottom) {
                for (int j = right; j >= left && curr != null; j--) {
                    ans[bottom][j] = curr.val;
                    curr = curr.next;
                }
                bottom--;
            }

            // Bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top && curr != null; i--) {
                    ans[i][left] = curr.val;
                    curr = curr.next;
                }
                left++;
            }
        }

        return ans;
    }
}
