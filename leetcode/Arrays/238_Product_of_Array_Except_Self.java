
/*
LeetCode 238: Product of Array Except Self

Approach: Prefix and Suffix Products

Logic:
1. Store the product of all elements to the left.
2. Traverse from right to left and multiply by
   the product of all elements to the right.
3. Do not use division.

Time Complexity: O(n)
Auxiliary Space: O(1), excluding output.
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;

        // Prefix products
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}
