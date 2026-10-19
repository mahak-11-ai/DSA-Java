
/*
LeetCode 75: Sort Colors

Approach: Dutch National Flag Algorithm

Logic:
1. low marks the next position for 0.
2. mid examines the current element.
3. high marks the next position for 2.
4. If nums[mid] == 0, swap with low and move both.
5. If nums[mid] == 1, move mid.
6. If nums[mid] == 2, swap with high and move high.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
