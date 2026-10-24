
/*
LeetCode 13: Roman to Integer

Approach: Greedy

Logic:
1. Convert each Roman symbol into its integer value.
2. If the current value is smaller than the next value,
   subtract the current value.
3. Otherwise, add the current value.
4. Return the total.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int romanToInt(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = value(s.charAt(i));

            if (i + 1 < s.length()
                    && current < value(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
