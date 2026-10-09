
/*
Problem: 118. Pascal's Triangle

Approach: Nested Lists

Key Idea:
- Every row starts and ends with 1.
- Each middle element is the sum of the two elements
  above it in the previous row.
- Store each completed row in ans.

Example: numRows = 4
Output: [[1], [1,1], [1,2,1], [1,3,3,1]]

Important:
- ans = stores all rows
- row = builds the current row
- previousRow = retrieves the row above
- ans.add(row) = saves the completed row

Time Complexity: O(numRows²)
Space Complexity: O(numRows²) for the output
*/

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            if (i > 0) {
                List<Integer> previousRow = ans.get(i - 1);

                for (int j = 1; j < i; j++) {
                    int value = previousRow.get(j - 1)
                              + previousRow.get(j);
                    row.add(value);
                }

                row.add(1);
            }

            ans.add(row);
        }

        return ans;
    }
}
