
/*
Problem: LeetCode 35 - Search Insert Position

Approach: Binary Search (Ceiling Concept)

1. The given array is sorted in ascending order.
2. We need to find the index of the target.
3. If the target exists, return its index.
4. If the target does not exist, return the index
   where it should be inserted to maintain sorted order.

Algorithm:

1. Initialize start = 0 and end = nums.length - 1.
2. Calculate the middle index.
3. If nums[mid] == target, return mid.
4. If target > nums[mid], search the right half:
   start = mid + 1.
5. If target < nums[mid], search the left half:
   end = mid - 1.
6. When the loop ends, return start.

Why return start?

When binary search ends, start points to the position
where the target should be inserted to maintain
the ascending order of the array.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (target > nums[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return start;
    }
}
