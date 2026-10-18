
/*
LeetCode 128: Longest Consecutive Sequence

Approach: HashSet

Logic:
1. Store all numbers in a HashSet.
2. A sequence starts when num - 1 is absent.
3. Count consecutive numbers starting from num.
4. Track the maximum sequence length.

Time Complexity: O(n) average
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
