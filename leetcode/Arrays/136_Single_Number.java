
/*
LeetCode 136: Single Number

Approach: Bit Manipulation (XOR)

Logic:
1. Initialize answer with 0.
2. XOR every element with answer.
3. Duplicate numbers cancel each other.
4. The remaining number is the single number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            ans = ans ^ num;
        }

        return ans;
    }
}
