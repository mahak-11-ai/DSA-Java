/*
========================================================
LeetCode 349 - Intersection of Two Arrays
Topic: Arrays / HashSet
Difficulty: Easy
========================================================

PROBLEM:

Given two integer arrays nums1 and nums2, return an array
containing their intersection.

Each element in the result must be unique.

Example:

Input:
nums1 = [1,2,2,1]
nums2 = [2,2]

Output:
[2]

Example:

Input:
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]

Output:
[4,9]


========================================================
APPROACH 1: BRUTE FORCE + HASHSET
========================================================

IDEA:

1. Use two nested loops.
2. Compare every element of nums1 with every element
   of nums2.
3. If nums1[i] == nums2[j], add the element to a HashSet.
4. HashSet automatically removes duplicates.
5. Convert the HashSet into an int[] because the method
   needs to return an array.

Example:

nums1 = [4,9,5]
nums2 = [9,4,9,8,4]

The loops may find:

4
9
9
4

But HashSet stores:

[4,9]

because a Set does not allow duplicate elements.


========================================================
IMPORTANT BUG I MADE
========================================================

Initially I created the result array before filling
the HashSet:

    int[] result = new int[ans.size()];

At that time:

    ans.size() = 0

because the HashSet was still empty.

So result became:

    new int[0]

After that, adding elements to the HashSet does NOT
automatically resize the already-created array.

CORRECT ORDER:

1. Fill HashSet
2. Create result array using ans.size()
3. Copy HashSet into result
4. Return result


========================================================
TIME COMPLEXITY
========================================================

Two nested loops:

    O(n * m)

where:
    n = nums1.length
    m = nums2.length

HashSet insertion is O(1) average.


========================================================
SPACE COMPLEXITY
========================================================

HashSet stores the unique intersection elements.

    O(min(n,m)) approximately

The result array also contains the intersection.


========================================================
KEY LEARNING
========================================================

1. HashSet does not store duplicate values.

2. Use HashSet when the answer needs unique elements.

3. A collection's size must be known AFTER adding elements
   if we use that size to create an array.

4. An array has fixed size. It does not automatically grow.

5. When returning int[] from a HashSet<Integer>, we need
   to manually copy the elements into the array.


========================================================
NEXT STEP:

Try the optimal approach using HashSet without nested loops.
========================================================
*/

import java.util.HashSet;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> ans = new HashSet<>();

        // Compare every element of nums1 with nums2
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    ans.add(nums1[i]);
                }
            }
        }

        // Create result AFTER HashSet is filled
        int[] result = new int[ans.size()];

        int i = 0;

        // Convert HashSet to int[]
        for (int num : ans) {
            result[i++] = num;
        }

        return result;
    }
}