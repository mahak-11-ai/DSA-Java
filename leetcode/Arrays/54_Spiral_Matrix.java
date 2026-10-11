
/*
LeetCode 54: Spiral Matrix

Approach: Boundary Traversal

Order:
1. Left to Right  -> top++
2. Top to Bottom  -> right--
3. Right to Left  -> bottom--
4. Bottom to Top  -> left++

Continue while:
top <= bottom && left <= right

Time Complexity: O(m * n)
Auxiliary Space: O(1), excluding output
*/

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse left to right
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;

            // Traverse top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Traverse right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // Traverse bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
