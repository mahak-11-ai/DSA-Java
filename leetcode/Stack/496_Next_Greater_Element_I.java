/*
========================================================
LeetCode 496 - Next Greater Element I
Topic: Array / Brute Force
Difficulty: Easy
========================================================

PROBLEM:
For every element in nums1, find the first greater element
to its right in nums2.

If no greater element exists, return -1.

--------------------------------------------------------
BRUTE FORCE APPROACH:
--------------------------------------------------------

For every element of nums1:

1. Take the current element as 'digit'.
2. Search for this element in nums2.
3. Once we find it, start traversing nums2 from the
   next position.
4. Find the first element greater than 'digit'.
5. If found, store it in ans[i].
6. If no greater element is found, store -1.

--------------------------------------------------------
IMPORTANT LOGIC:
--------------------------------------------------------

boolean found = false;

We use 'found' to remember whether a greater element
was found for the current nums1[i].

If a greater element is found:

    ans[i] = nums2[k];
    found = true;
    break;

If the loop finishes and found is still false:

    ans[i] = -1;

--------------------------------------------------------
WHY IS found INSIDE THE i LOOP?
--------------------------------------------------------

Every nums1[i] is a new search.

Therefore, found must be reset to false for every
new element.

If found is declared outside the loop, its value can
carry over from the previous element.

--------------------------------------------------------
TIME COMPLEXITY:
O(n * m * m) in the worst case

where:
n = nums1.length
m = nums2.length

--------------------------------------------------------
SPACE COMPLEXITY:
O(n)

because of the answer array.

--------------------------------------------------------
MY LEARNING:
- break only exits the current loop.
- mid/index and actual array value are different concepts.
- A boolean flag can be used to remember whether something
  was found inside a loop.
- Variables that represent the state of one iteration
  should usually be declared inside that loop.

--------------------------------------------------------
NEXT STEP:
Try to solve this problem using the OPTIMAL approach
with a Monotonic Stack.

========================================================
*/

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        // Traverse every element of nums1
        for (int i = 0; i < nums1.length; i++) {

            int digit = nums1[i];

            // Initially, no greater element has been found
            boolean found = false;

            // Find digit inside nums2
            for (int j = 0; j < nums2.length; j++) {

                if (digit == nums2[j]) {

                    // Search for the next greater element
                    for (int k = j + 1; k < nums2.length; k++) {

                        if (nums2[k] > digit) {

                            ans[i] = nums2[k];
                            found = true;

                            // First greater element found
                            break;
                        }
                    }

                    // If no greater element was found
                    if (!found) {
                        ans[i] = -1;
                    }

                    // We found digit in nums2, so stop searching
                    break;
                }
            }
        }

        return ans;
    }
}
