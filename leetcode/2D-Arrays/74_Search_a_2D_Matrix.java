
/*
Problem: LeetCode 74 - Search a 2D Matrix

Approach: Binary Search on a Virtual 1D Array

1. The matrix is sorted row-wise, and the first element
   of each row is greater than the last element of the
   previous row.

2. Therefore, we can consider the entire matrix as
   a single sorted 1D array without actually converting it.

3. Initialize:
   start = 0
   end = (m * n) - 1

4. Calculate the middle index:
   mid = start + (end - start) / 2

5. Convert the 1D index into 2D coordinates:
   row = mid / n
   col = mid % n

6. Compare matrix[row][col] with the target:
   - If equal, return true.
   - If target is greater, search the right half.
   - If target is smaller, search the left half.

7. If start becomes greater than end,
   the target does not exist. Return false.

Time Complexity: O(log(m * n))
Space Complexity: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n= matrix[0].length;
        int start=0;
        int end= m*n-1;
        
        while(start<=end){
            int mid = start+ (end - start)/2;
            int r = mid/n;
            int c = mid%n;
            if(target ==  matrix[r][c]){
                return true;
            }
            else if(target > matrix[r][c]){
                start = mid+1;
            }
            else end = mid-1;
        }
        return false;

    }
}