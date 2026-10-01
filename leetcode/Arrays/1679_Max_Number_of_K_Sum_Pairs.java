/*
========================================================
LeetCode 1679 - Max Number of K-Sum Pairs
Topic: Arrays
Difficulty: Medium
========================================================

PROBLEM:

Given an integer array nums and an integer k, find the
maximum number of operations where:

    nums[i] + nums[j] == k

In one operation, remove the two numbers from the array.

A number can be used only once.

Return the maximum number of such operations.

Example:

Input:
nums = [1,2,3,4]
k = 5

Output:
2

Pairs:
1 + 4 = 5
2 + 3 = 5


========================================================
APPROACH 1: BRUTE FORCE
========================================================

IDEA:

Try to find pairs using two loops.

For every nums[i]:
    1. Check every element after it.
    2. If nums[i] + nums[j] == k:
           count++
    3. Mark both elements as used.

A boolean array is used to remember which elements
have already been used.

========================================================
WHY DO WE NEED used[]?
========================================================

Because every element can be used only once.

Example:

nums = [1,1,4,4]
k = 5

The correct answer is 2:

    1 + 4
    1 + 4

Once an element has been used in a pair, we mark it:

    used[i] = true
    used[j] = true

Then it cannot be used again.


========================================================
TIME COMPLEXITY
========================================================

There are two nested loops:

    for i
        for j

Therefore:

    O(n^2)

========================================================
SPACE COMPLEXITY
========================================================

We use a boolean array of size n:

    boolean[] used

Therefore:

    O(n)

========================================================
MY LEARNING
========================================================

1. An element can be used only once.

2. boolean[] used can track whether an element
   has already been used.

3. When a valid pair is found:
       count++;
       used[i] = true;
       used[j] = true;

4. Don't manually increment i inside the for loop.

5. This brute-force approach works, but can be optimized
   using sorting + two pointers or a HashMap.
========================================================
*/


class Solution {

    public int maxOperations(int[] nums, int k) {

        int count = 0;

        boolean[] used = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (!used[j] && nums[i] + nums[j] == k) {

                    count++;

                    // Mark both elements as used
                    used[i] = true;
                    used[j] = true;

                    break;
                }
            }
        }

        return count;
    }
}