/*
Problem: 503. Next Greater Element II

Approach: Brute Force

Idea:
- For every element, search for the first greater element
  to its right.
- Since the array is circular, after reaching the last index,
  continue searching from index 0.
- We can check at most n - 1 elements for each element.
- If no greater element is found, store -1.

Example:
nums = [1, 2, 1]

For 1 → next greater = 2
For 2 → no greater element = -1
For 1 → circularly find 2

Answer = [2, -1, 2]

Time Complexity: O(n²)
Space Complexity: O(n) for the answer array

What I Learned:
- In a circular array, use modulo (%) to wrap around.
- (i + j) % n gives the circular index.
- Brute force checks every possible next element.
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            ans[i] = -1;

            for (int j = 1; j < n; j++) {

                int index = (i + j) % n;

                if (nums[index] > nums[i]) {
                    ans[i] = nums[index];
                    break;
                }
            }
        }

        return ans;
    }
}