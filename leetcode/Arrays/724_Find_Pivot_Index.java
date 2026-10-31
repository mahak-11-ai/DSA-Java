
/*
LeetCode 724: Find Pivot Index

Approach: Prefix Sum

Logic:
1. Calculate the total sum of the array.
2. Maintain the left sum.
3. Calculate the right sum using total - left - current.
4. If left sum equals right sum, return the index.
5. Otherwise, update the left sum.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
