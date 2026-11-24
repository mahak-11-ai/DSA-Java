/*
Problem: LeetCode 34 - Find First and Last Position
of Element in Sorted Array

Approach: Binary Search (Boundary Search)

1. Perform binary search to find the first occurrence.
2. When the target is found, store its index and
   continue searching towards the left.
3. Perform another binary search to find the last occurrence.
4. When the target is found, store its index and
   continue searching towards the right.
5. If the target is not present, return {-1, -1}.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = search(nums,target,true);
        int end = search(nums,target,false);
        int[] ans = { -1, -1 };
        ans[0]=start;
        ans[1]=end;
        return ans;
    }

    static int search(int[] nums, int target, boolean findStartIndex) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;
        
        while (start <= end ) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                ans = mid;
                if(findStartIndex){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}