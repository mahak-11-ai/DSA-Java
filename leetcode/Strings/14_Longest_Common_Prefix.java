
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Compare characters at the same index
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {

                // Stop if a string ends or characters mismatch
                if (i >= strs[j].length()
                    || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // All characters of the first string matched
        return strs[0];
    }
}


// **Approach:** Horizontal Scanning

// **Logic:**
// - Use the first string as a reference.
// - Compare characters at the same index in every string.
// - If a mismatch occurs, return the prefix before that index.
// - If all characters match, return the first string.

// **Complexity:**
// - Time: `O(n × m)` in the worst case, where `n` is the number of strings and `m` is the length of the first string.
// - Auxiliary space: `O(1)`, excluding the returned string.

// **Memory trick:** Compare → Mismatch → Return prefix.