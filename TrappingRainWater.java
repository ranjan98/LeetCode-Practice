// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:

// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9

 
// Constraints:

//     n == height.length
//     0 <= n <= 3 * 10^4
//     0 <= height[i] <= 10^5

// Brute Force - O(n^2)
// class Solution {
//     public int trap(int[] height) {
//         int currentWater = 0;
//         for(int i=1;i<height.length-1;i++){
//             int maxLeft = findMax(height, 0, i);
//             int maxRight = findMax(height, i+1, height.length);
//             int water = Math.min(maxLeft, maxRight) - height[i];
//             if(water>0)
//                 currentWater += water;
//         }
//         return currentWater;
//     }
//     public static int findMax(int[] height, int index, int len){
//         int max = 0;
//         for(int i=index; i<len;i++){
//             max = Math.max(max, height[i]);
//         }
//         return max;
//     }
// }

// Optimal Solution - O(n)
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;
        while(left < right){
            if(height[left] <= height[right]){
                if(maxLeft <= height[left])
                    maxLeft = height[left];
                else
                    totalWater += maxLeft - height[left];
                left++;
            }
            else{
                if(maxRight <= height[right])
                    maxRight = height[right];
                else
                    totalWater += maxRight - height[right];
                right--;
            }
        }
        return totalWater;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Trapping Rain Water.
// Memory Usage: 38.4 MB, less than 68.14% of Java online submissions for Trapping Rain Water.
