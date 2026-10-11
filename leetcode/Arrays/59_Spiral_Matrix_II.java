
/*
LeetCode 59: Spiral Matrix II

Approach: Boundary Traversal

Order:
1. Left to Right  -> top++
2. Top to Bottom  -> right--
3. Right to Left  -> bottom--
4. Bottom to Top  -> left++

Inner conditions:
top <= bottom  -> prevents revisiting a row
left <= right  -> prevents revisiting a column

Time Complexity: O(n^2)
Space Complexity: O(n^2) for the output matrix
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int val = 1;

        while (val <= n * n && top <= bottom && left <= right) {

            // 1. Left to right
            for (int j = left; j <= right; j++) {
                ans[top][j] = val++;
            }
            top++;

            // 2. Top to bottom
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = val++;
            }
            right--;

            // 3. Right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans[bottom][j] = val++;
                }
                bottom--;
            }

            // 4. Bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = val++;
                }
                left++;
            }
        }

        return ans;
    }
}
