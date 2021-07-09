// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
// You can either start from the step with index 0, or the step with index 1.
// Return the minimum cost to reach the top of the floor.

// Example 1:
// Input: cost = [10,15,20]
// Output: 15
// Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.

// Example 2:
// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 

// Constraints:
//     2 <= cost.length <= 1000
//     0 <= cost[i] <= 999

// Using Dynamic Programming - Top Down (Memoization) Approach
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int minCostArr[] = new int[n];
        return Math.min(minCost(n-1, cost, minCostArr), minCost(n-2, cost, minCostArr));
    }
    public int minCost(int i, int[] cost, int dp[]){
        if(i<0)
            return 0;
        if(i < 2)
            return cost[i];
        if(dp[i]!=0) 
            return dp[i];
        dp[i] = cost[i] + Math.min(minCost(i-1, cost, dp), minCost(i-2, cost, dp));
        return dp[i];
    }
}

// Time: O(n) and Space: O(n)
// Runtime: 1 ms, faster than 86.98% of Java online submissions for Min Cost Climbing Stairs.
// Memory Usage: 38.4 MB, less than 89.11% of Java online submissions for Min Cost Climbing Stairs.


// Using Dynamic Programming - Bottom Up Approach (Iterative)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int minCostArr[] = new int[n];
        return minCost(n, cost, minCostArr);
    }
    public int minCost(int n, int[] cost, int dp[]){
        for(int i=0; i<n;i++){
            if(i<2)
                dp[i] = cost[i];
            else
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}

// Time: O(n) and Space: O(n)
// Runtime: 1 ms, faster than 86.98% of Java online submissions for Min Cost Climbing Stairs.
// Memory Usage: 38.6 MB, less than 71.38% of Java online submissions for Min Cost Climbing Stairs.

// A further optimized approach - better space complexity 
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n<2)
            return cost[n];
        return minCost(n, cost);
    }
    public int minCost(int n, int[] cost){
        int dp1 = cost[0];
        int dp2 = cost[1];
        for(int i=2; i<n;i++){
            int current = cost[i] + Math.min(dp1, dp2);
            dp1 = dp2;
            dp2 = current;
        }
        return Math.min(dp1, dp2);
    }
}

// Time: O(n) and Space: O(1)
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Min Cost Climbing Stairs.
// Memory Usage: 38.6 MB, less than 80.66% of Java online submissions for Min Cost Climbing Stairs.
