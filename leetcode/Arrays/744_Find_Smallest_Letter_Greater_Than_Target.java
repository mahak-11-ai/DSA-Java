
/*
Problem: LeetCode 744 - Find Smallest Letter Greater Than Target

Approach: Binary Search (Ceiling Concept)

1. The given character array is sorted in ascending order.
2. We need to find the smallest character strictly greater
   than the target.
3. Initialize start = 0 and end = letters.length - 1.
4. Calculate the middle index.
5. If letters[mid] is less than or equal to target,
   move start to mid + 1.
6. Otherwise, move end to mid - 1.
7. When the loop ends, start points to the index of the
   smallest letter greater than the target.

Why use Modulo (%)?

- If the target is greater than or equal to the largest
  letter, start becomes letters.length.
- This index is outside the array.
- Modulo brings the index back to 0.
- Therefore, we return the first letter (wrap-around).

Example:
letters = {'c', 'f', 'j'}
target = 'j'

start = 3
3 % 3 = 0

Answer = 'c'

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target >= letters[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return letters[start % letters.length];
        // start represents the index of the smallest letter
// strictly greater than the target.
//
// If start == letters.length, it means no letter is
// greater than the target, so we wrap around to index 0.
//
// Modulo (%) keeps the index within the valid array range.
// Example: 3 % 3 = 0, so we return the first letter.


    }
}
