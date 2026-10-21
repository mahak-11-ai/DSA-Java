
/*
LeetCode 560: Subarray Sum Equals K

Approach: Prefix Sum + HashMap

Logic:
1. Store prefix sums and their frequencies.
2. For each number, update the running sum.
3. Check if sum - k exists in the map.
4. Add its frequency to the answer.
5. Record the current prefix sum.

Time Complexity: O(n) average
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            count += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
