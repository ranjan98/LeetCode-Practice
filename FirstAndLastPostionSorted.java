// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]

// Constraints:
//     0 <= nums.length <= 10^5
//     -10^9 <= nums[i] <= 10^9
//     nums is a non-decreasing array.
//     -10^9 <= target <= 10^9

// Using Binary Search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};
        int firstPos = Arrays.binarySearch(nums, target);
        // System.out.println(firstPos);
        if(firstPos == -1)
            return new int[]{-1, -1};
        int endPos = firstPos;
        int startPos = firstPos;
        int temp1 = -1;
        int temp2 = -1;

        while (startPos > -1) {
            temp1 = startPos;
            startPos = Arrays.binarySearch(nums, 0, startPos, target);
        }
        startPos = temp1;
        while (endPos > -1) {
            temp2 = endPos;
            endPos = Arrays.binarySearch(nums, endPos + 1, nums.length, target);
        }
        endPos = temp2;
        return new int[]{startPos, endPos};
    }
}

// Time Complexity: O(n) and Space Complexity: O(1)
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
// Memory Usage: 42 MB, less than 76.22% of Java online submissions for Find First and Last Position of Element in Sorted Array.
