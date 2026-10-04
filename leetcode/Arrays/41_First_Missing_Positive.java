/*
Problem: 41. First Missing Positive

Approach: Brute Force

Idea:
- The answer is the smallest positive integer that is missing from the array.
- Start with missing = 1.
- Search the entire array to check whether missing exists.
- If it exists, increase missing by 1 and search again.
- If it does not exist, return missing.

Example:
nums = [3, 4, -1, 1, 2]

missing = 1 → found
missing = 2 → found
missing = 3 → found
missing = 4 → found
missing = 5 → not found

Answer = 5


Code:
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int missing = 1;

        while (true) {
            boolean found = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == missing) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return missing;
            }

            missing++;
        }
    }
}

/*
Time Complexity: O(n²)

Space Complexity: O(1)

Limitation:
The logic is correct, but this approach gives
Time Limit Exceeded (TLE) for large test cases.

LeetCode result:
174 / 179 test cases passed before TLE.

What I Learned:
- When missing changes, I need to search the entire array again.
- A nested/repeated search can make the time complexity O(n²).
- Passing most test cases does not mean the algorithm is efficient enough.
- Need to find an O(n) time and O(1) space approach next.
*/