// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4

// Constraints:
//     1 <= k <= nums.length <= 10^4
//     -10^4 <= nums[i] <= 10^4

// Using Arrays.sort()
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

// Runtime: 1 ms, faster than 98.07% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 39.1 MB, less than 82.10% of Java online submissions for Kth Largest Element in an Array.

// Quicksort Approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }
    public static void quickSort(int[] a, int i, int pivot){
        if(pivot<0)
            return;
        int j = i;
        int start = i;
        while(pivot != j){
            if(a[j] < a[pivot]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        if(start<i-1)
        quickSort(a, start, i-1);
        if(i+1<pivot)
        quickSort(a, i+1, pivot);
    }
}

// Runtime: 69 ms, faster than 5.10% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 39.6 MB, less than 30.14% of Java online submissions for Kth Largest Element in an Array.

// Using Quick Select Approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length-1, nums.length-k);
        return nums[nums.length-k];
    }
    public static void quickSelect(int[] a, int i, int pivot, int indexToFind){
        if(pivot<0)
            return;
        int j = i;
        int start = i;
        while(pivot != j){
            if(a[j] < a[pivot]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        if(indexToFind == i)
            return;
        if(indexToFind<i)
            quickSelect(a, start, i-1, indexToFind);
        else
            quickSelect(a, i+1, pivot, indexToFind);
    }
}

// Runtime: 19 ms, faster than 10.15% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 39.9 MB, less than 19.94% of Java online submissions for Kth Largest Element in an Array.
// Runtime: 20 ms, faster than 9.56% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 38.9 MB, less than 96.05% of Java online submissions for Kth Largest Element in an Array.
