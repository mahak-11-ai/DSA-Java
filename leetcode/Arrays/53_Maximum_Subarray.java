/*
Problem: 53. Maximum Subarray

Approach: Kadane's Algorithm

Key Idea:
At every element, decide whether to:
1. Start a new subarray from the current element, OR
2. Continue the previous subarray.

So:
currentSum = max(nums[i], currentSum + nums[i])

We also keep track of the maximum sum found so far.


Example:
nums = [-2,1,-3,4,-1,2,1,-5,4]

Maximum subarray:
[4,-1,2,1]

Maximum sum = 6


Why do we reset sum to 0?

If current sum becomes negative, it will only decrease the
sum of any future subarray.

So we discard the negative sum:

if (sum < 0)
    sum = 0;


Important:
Update maxi BEFORE resetting sum.

This is important for arrays containing only negative numbers.

Example:
[-5,-2,-8]

Answer = -2


Time Complexity: O(n)
Space Complexity: O(1)


What I Learned:
- At every index, choose between starting fresh or extending.
- A negative running sum is useless for future elements.
- Kadane's Algorithm finds the maximum subarray sum in one pass.
*/

class Solution {
    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int maxi = nums[0];

        for (int i = 1; i < nums.length; i++) {

            sum = Math.max(nums[i], sum + nums[i]);

            maxi = Math.max(maxi, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }
}