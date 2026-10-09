```java
/*
Problem: 796. Rotate String

Approach 1: Brute Force
- Repeatedly move the first character to the end.
- After each rotation, compare the string with goal.
- If they match, return true.
- If no rotation matches, return false.

Approach 2: Optimized
- If s and goal have different lengths, return false.
- Concatenate s with itself: s + s.
- Every possible rotation of s appears as a substring
  of s + s.
- Check whether (s + s) contains goal.

Example:
s = "abcde"
goal = "cdeab"

s + s = "abcdeabcde"
"cdeab" exists in it.

Output: true

Time Complexity:
Brute force: O(n^2) with repeated string construction.
Optimized: O(n) auxiliary work for concatenation;
           substring search complexity depends on implementation.

Space Complexity:
Brute force: O(n) for temporary strings.
Optimized: O(n) for the concatenated string.

Key Learning:
A string is a rotation of another string if and only if
their lengths are equal and goal is a substring of s + s.
*/

class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length()
            && (s + s).contains(goal);
    }
}
```