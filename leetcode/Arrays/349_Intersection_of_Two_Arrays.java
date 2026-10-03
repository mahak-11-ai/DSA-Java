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
3. If nums1[i] == nums2[j], add it to a HashSet.
4. HashSet automatically removes duplicates.
5. Convert the HashSet into int[].

TIME: O(n * m)

SPACE: O(min(n,m)) approximately


IMPORTANT BUG I MADE:

Initially I created the result array before filling
the HashSet:

    int[] result = new int[ans.size()];

At that point ans was empty, so:

    ans.size() = 0

Therefore:

    result = new int[0]

The result array does not automatically grow when
the HashSet grows.

CORRECT ORDER:

1. Fill HashSet
2. Create result array
3. Copy HashSet into result
4. Return result


========================================================
APPROACH 2: OPTIMAL - HASHSET
========================================================

IDEA:

Instead of comparing every element of nums1 with every
element of nums2, store nums1 elements in a HashSet.

Then traverse nums2 and check whether the current element
exists in the HashSet.

HashSet lookup is O(1) average.

Steps:

1. Create a HashSet containing all elements of nums1.
2. Create another HashSet for the answer.
3. Traverse nums2.
4. If nums2[i] exists in the first HashSet, add it
   to the answer HashSet.
5. Convert the answer HashSet into an int[].


Example:

nums1 = [4,9,5]
nums2 = [9,4,9,8,4]

nums1Set:

    {4,9,5}

Traverse nums2:

    9 → exists → add 9
    4 → exists → add 4
    9 → already in answer
    8 → doesn't exist
    4 → already in answer

Answer:

    [4,9]


========================================================
WHY TWO HASHSETS?
========================================================

First HashSet:

    Stores elements of nums1
    → used for fast searching

Second HashSet:

    Stores intersection
    → automatically prevents duplicates


========================================================
TIME COMPLEXITY
========================================================

Creating nums1 HashSet:
    O(n)

Traversing nums2:
    O(m)

HashSet lookup:
    O(1) average

Total:

    O(n + m)


========================================================
SPACE COMPLEXITY
========================================================

First HashSet can contain n elements.

Second HashSet can contain up to min(n,m) elements.

Therefore:

    O(n + m)


========================================================
KEY LEARNING
========================================================

1. HashSet is useful when we need unique elements.

2. HashSet lookup is O(1) average.

3. Instead of comparing every pair, store elements
   and check for existence.

4. This reduces the brute-force O(n * m) approach
   to O(n + m).

5. When converting a HashSet to an array, create the
   array AFTER the HashSet has been populated.


========================================================
PATTERN:

Need to check whether an element exists quickly?
        ↓
Think HashSet / HashMap

Need unique elements?
        ↓
Think HashSet
========================================================
*/

import java.util.HashSet;

class Solution {

    // =====================================================
    // APPROACH 1: BRUTE FORCE + HASHSET
    // =====================================================

    public int[] intersectionBruteForce(int[] nums1, int[] nums2) {

        HashSet<Integer> ans = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    ans.add(nums1[i]);
                }
            }
        }

        int[] result = new int[ans.size()];

        int i = 0;

        for (int num : ans) {
            result[i++] = num;
        }

        return result;
    }


    // =====================================================
    // APPROACH 2: OPTIMAL - HASHSET
    // =====================================================

    public int[] intersection(int[] nums1, int[] nums2) {

        // Store all elements of nums1
        HashSet<Integer> nums1Set = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        // Store unique intersection elements
        HashSet<Integer> ans = new HashSet<>();

        // Check every element of nums2
        for (int num : nums2) {

            if (nums1Set.contains(num)) {
                ans.add(num);
            }
        }

        // Convert HashSet to int[]
        int[] result = new int[ans.size()];

        int i = 0;

        for (int num : ans) {
            result[i++] = num;
        }

        return result;
    }
}
