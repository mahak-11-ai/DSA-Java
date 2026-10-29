
/*
LeetCode 525: Contiguous Array

Approach: Prefix Sum + HashMap

Logic:
1. Treat 0 as -1 and 1 as +1.
2. Maintain a running prefix sum.
3. If the same prefix sum appears again,
   the subarray between those indices has equal
   numbers of zeros and ones.
4. Store the first index of each prefix sum.
5. Update the maximum subarray length.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                prefixSum--;
            } else {
                prefixSum++;
            }

            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(
                    maxLength,
                    i - map.get(prefixSum)
                );
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
