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


/*


Approach: Index Placement / Cyclic Sort (OPTIMAL)

Idea:
- For an array of length n, the answer must be between 1 and n + 1.
- We try to place every valid positive number at its correct index.
- Number 1 should be at index 0.
- Number 2 should be at index 1.
- Number 3 should be at index 2.
- In general, number x should be at index x - 1.
- Ignore numbers <= 0 and numbers > n.

After placing the numbers, the first index i where
nums[i] != i + 1 gives the first missing positive.

Example:
nums = [3, 4, -1, 1, 2]

After rearranging:
[1, 2, 3, 4, -1]

Index 0 → 1 ✓
Index 1 → 2 ✓
Index 2 → 3 ✓
Index 3 → 4 ✓
Index 4 → 5 ✗

Answer = 5

Time Complexity: O(n)
Space Complexity: O(1)

What I Learned:
- An array can be used as its own hash/index structure.
- For a positive number x, its correct index is x - 1.
- Cyclic placement can achieve O(n) time and O(1) extra space.
*/
/*
LeetCode 41: First Missing Positive

Optimal Approach: Index Placement

Key Idea:
For every valid number x, its correct position is index x - 1.

Example:
1 → index 0
2 → index 1
3 → index 2
4 → index 3


Why TWO loops?

1. PLACE → while loop
   Put every valid number x at index x - 1.
   After swapping, don't increase i because the new number
   at index i may also need to be placed.

2. CHECK → for loop
   After placement, scan the array.
   The first index i where nums[i] != i + 1 means
   i + 1 is the first missing positive.

Memory Trick:
PLACE → CHECK


Why did Brute Force get TLE?
The brute-force approach searches the entire array repeatedly
for every missing number.

Time: O(n²)
Space: O(1)

Optimal:
Time: O(n)
Space: O(1)
*/

class Solution {
    public int firstMissingPositive(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            int correctIndex = nums[i] - 1;

            if (nums[i] > 0 &&
                nums[i] <= nums.length &&
                nums[i] != nums[correctIndex]) {

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}