
/*
LeetCode 3: Longest Substring Without Repeating Characters

Approach: Sliding Window + HashSet

Logic:
1. Use two pointers to maintain a sliding window.
2. Store characters in a HashSet.
3. If a character repeats, remove characters from the
   left until the duplicate is removed.
4. Update the maximum window length.
5. Return the maximum length.

Time Complexity: O(n)
Space Complexity: O(min(n, character set size))
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
