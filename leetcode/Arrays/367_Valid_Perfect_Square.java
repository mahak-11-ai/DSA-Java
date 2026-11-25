
/*
Problem: LeetCode 367 - Valid Perfect Square

Approach: Binary Search

1. A perfect square is a number that can be expressed
   as the square of an integer.

2. Instead of checking every number from 1 to num,
   we use Binary Search.

3. Initialize start = 1 and end = num.

4. Calculate the middle element:
   mid = start + (end - start) / 2

5. Calculate mid * mid and compare it with num.

6. If mid * mid == num:
   The number is a perfect square. Return true.

7. If mid * mid < num:
   The square is smaller than num, so search the
   right half.

8. If mid * mid > num:
   The square is greater than num, so search the
   left half.

9. If the search space becomes empty, return false.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPerfectSquare(int num) {

        long start = 1;
        long end = num;

        while (start <= end) {

            long mid = start + (end - start) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            }
            else if (square < num) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return false;
    }
}
