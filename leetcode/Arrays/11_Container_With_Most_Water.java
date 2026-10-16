
/*
LeetCode 11: Container With Most Water

Approach: Two Pointers

Logic:
1. Place left at the beginning and right at the end.
2. Calculate area using the shorter line's height
   multiplied by the distance between the pointers.
3. Update maximum area.
4. Move the pointer at the shorter line inward.
5. Repeat until left >= right.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
