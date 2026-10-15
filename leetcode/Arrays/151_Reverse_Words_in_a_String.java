
/*
LeetCode 151: Reverse Words in a String

Approach: String Manipulation

Logic:
1. Use trim() to remove leading and trailing spaces.
2. Use split("\\s+") to separate words by whitespace.
3. Traverse the words array from right to left.
4. Append each word to StringBuilder with a single space.
5. Return the resulting string.

Example:
Input:  "  hello world  "
Output: "world hello"

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);

            if (i > 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
