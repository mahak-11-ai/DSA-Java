/*
========================================================
LeetCode 496 - Next Greater Element I
Topic: Array / Stack
Difficulty: Easy
========================================================

PROBLEM:
For every element in nums1, find the first greater element
to its right in nums2.

If no greater element exists, return -1.

========================================================
APPROACH 1: BRUTE FORCE
========================================================

Steps:
1. Take each element of nums1.
2. Find that element in nums2.
3. Start checking elements to its right.
4. The first greater element is the answer.
5. If no greater element is found, answer is -1.

KEY LEARNING:
- break only exits the current loop.
- Use a boolean flag to remember whether an answer was found.
- Don't increment i manually inside a for loop.

TIME: O(n * m)
SPACE: O(n)

========================================================
APPROACH 2: OPTIMAL - MONOTONIC STACK + HASHMAP
========================================================

IDEA:

Stack -> Finds the next greater element.
HashMap -> Remembers the answer.

For nums2, process elements from left to right.

If current element is greater than the element represented
by the top of the stack:
    current element is the next greater element.

Store:
    element -> next greater element

The stack stores INDICES, not values.

Example:
nums2 = [1, 3, 4, 2]

Map:
1 -> 3
3 -> 4
4 -> -1
2 -> -1

Then simply look up every nums1 element in the map.

TIME: O(n + m)
SPACE: O(m)

========================================================
MY LEARNING:
- Monotonic stack is useful for "next greater/smaller" problems.
- Stack stores indices so we can access nums2[index].
- HashMap stores the already calculated answers.
- Each element is pushed and popped at most once.
========================================================
*/


import java.util.HashMap;
import java.util.Stack;

class Solution {

    // =====================================================
    // APPROACH 1: BRUTE FORCE
    // =====================================================

    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int digit = nums1[i];
            boolean found = false;

            for (int j = 0; j < nums2.length; j++) {

                if (digit == nums2[j]) {

                    for (int k = j + 1; k < nums2.length; k++) {

                        if (nums2[k] > digit) {
                            ans[i] = nums2[k];
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        ans[i] = -1;
                    }

                    break;
                }
            }
        }

        return ans;
    }


    // =====================================================
    // APPROACH 2: OPTIMAL
    // Monotonic Stack + HashMap
    // =====================================================

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[nums1.length];

        // Find next greater elements in nums2
        for (int i = 0; i < nums2.length; i++) {

            while (!stack.empty()
                    && nums2[i] > nums2[stack.peek()]) {

                map.put(nums2[stack.peek()], nums2[i]);

                stack.pop();
            }

            stack.push(i);
        }

        // Remaining elements have no greater element
        while (!stack.empty()) {

            map.put(nums2[stack.peek()], -1);

            stack.pop();
        }

        // Get answers for nums1
        for (int i = 0; i < nums1.length; i++) {

            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}