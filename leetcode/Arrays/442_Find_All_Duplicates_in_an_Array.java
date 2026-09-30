/*
========================================================
LeetCode 442 - Find All Duplicates in an Array
Topic: Arrays
Difficulty: Medium
========================================================

PROBLEM:
Given an integer array nums of length n where:

1 <= nums[i] <= n

Each integer appears once or twice.

Return all the integers that appear twice.

Example:
Input:
nums = [4,3,2,7,8,2,3,1]

Output:
[2,3]


========================================================
APPROACH 1: BRUTE FORCE
========================================================

IDEA:
For every element, compare it with all the elements
after it.

If the same element is found again, it is a duplicate.

Steps:
1. Take nums[i].
2. Compare it with nums[j], where j starts from i + 1.
3. If nums[i] == nums[j], add nums[i] to the answer.

TIME: O(n^2)
SPACE: O(n) for the answer list


========================================================
APPROACH 2: OPTIMAL
Array Index Marking
========================================================

IMPORTANT OBSERVATION:

The problem guarantees:

1 <= nums[i] <= n

Therefore, every value can be mapped to an array index.

For a value:
    value = 1 -> index 0
    value = 2 -> index 1
    value = 3 -> index 2
    ...
    value = n -> index n - 1

So:

    index = Math.abs(nums[i]) - 1


IDEA:

Use the given array itself to keep track of whether
a number has already been seen.

If we see a number for the first time:
    Make the value at its corresponding index negative.

If we see the same number again:
    Its corresponding index is already negative,
    so that number is a duplicate.


WHY Math.abs()?

While marking, we change values to negative.

Example:
    2 -> -2

When we encounter it again:

    Math.abs(-2) = 2

Then:

    2 - 1 = 1

So:

    Math.abs(nums[i]) - 1

is used to find the correct index.


EXAMPLE:

nums = [4,3,2,7,8,2,3,1]

For 4:
    index = 4 - 1 = 3
    mark nums[3] negative

For 3:
    index = 3 - 1 = 2
    mark nums[2] negative

When 2 appears again:
    index = 2 - 1 = 1
    nums[1] is already negative
    -> 2 is a duplicate

When 3 appears again:
    index = 3 - 1 = 2
    nums[2] is already negative
    -> 3 is a duplicate

Answer:
    [2,3]


TIME: O(n)

SPACE: O(1) extra space
(The answer list is not counted as extra working space.)


========================================================
KEY LEARNING
========================================================

1. When values are in the range 1 to n, think about
   using values as array indices.

2. The sign of an array element can be used as a
   visited marker.

3. Math.abs(nums[i]) is needed because values may have
   already been changed to negative.

4. Important:
       Math.abs(nums[i]) - 1

   NOT:
       Math.abs(nums[i] - 1)

5. This technique allows us to avoid using a separate
   HashSet or visited array.


========================================================
*/


import java.util.*;

class Solution {

    // =====================================================
    // APPROACH 1: BRUTE FORCE
    // =====================================================

    public List<Integer> findDuplicatesBruteForce(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    ans.add(nums[i]);
                }
            }
        }

        return ans;
    }


    // =====================================================
    // APPROACH 2: OPTIMAL
    // Array Index Marking
    // =====================================================

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {

                // Already visited -> duplicate
                ans.add(Math.abs(nums[i]));

            } else {

                // Mark as visited
                nums[index] = -nums[index];
            }
        }

        return ans;
    }
}