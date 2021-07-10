// Recursive Solution -> Basic Approach, not efficient (Time and Space: O(8^k))
class Solution {
    int directions[][] = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2}};
    public double knightProbability(int n, int k, int row, int column) {
        if(row<0 || row>=n || column<0 || column>=n)
            return 0;
        if(k == 0)
            return 1;
        double ans = 0;
        for(int i=0; i<directions.length; i++){
            int currentDir[] = directions[i];
            int nextRow = currentDir[0];
            int nextCol = currentDir[1];
            ans += knightProbability(n, k-1, row+nextRow, column+nextCol)/8;
        }
        return ans;
    }
}

// Using Dynamic Programming: Memoization (Top Down) -> Time and Space: O(k*n^2)
class Solution {
    static int directions[][] = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2}};
    public double knightProbability(int n, int k, int row, int column) {
        double dp[][][] = new double[k+1][n][n];
        double ans = knightDP(n, k, row, column, dp);
        return ans;
    }
    public static double knightDP(int n, int k, int row, int column, double dp[][][]){
        if(row<0 || row>=n || column<0 || column>=n)
            return 0;
        if(k == 0)
            return 1;
        if(dp[k][row][column]!=0)
            return dp[k][row][column];
        double ans = 0;
        for(int i=0; i<directions.length; i++){
            int currentDir[] = directions[i];
            int nextRow = currentDir[0];
            int nextCol = currentDir[1];
            ans += knightDP(n, k-1, row+nextRow, column+nextCol, dp)/8;
        }
        dp[k][row][column] = ans;
        return dp[k][row][column];
    }
}
// Runtime: 6 ms, faster than 73.71% of Java online submissions for Knight Probability in Chessboard.
// Memory Usage: 39.5 MB, less than 20.36% of Java online submissions for Knight Probability in Chessboard.

// Using Dynamic Programming: Tabulation Method (Bottom Up) -> Time and Space: O(k*n^2)
class Solution {
    static int directions[][] = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2}};
    public double knightProbability(int n, int k, int row, int column) {
        double dp[][][] = new double[k+1][n][n];
        dp[0][row][column] = 1;
        for(int step = 1; step<=k; step++){
            for(int r = 0; r<n; r++){
                for(int c = 0; c<n; c++){
                    for(int i = 0; i<directions.length; i++){
                        int currentDir[] = directions[i];
                        int prevRow = r + currentDir[0];
                        int prevCol = c + currentDir[1];
                        if(prevRow >= 0 && prevRow<n && prevCol>=0 && prevCol<n){
                            dp[step][r][c] += dp[step-1][prevRow][prevCol]/8;
                        }
                    }
                }
            }
        }
        double ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                ans += dp[k][i][j];
        }
        return ans;
    }
}

// Runtime: 13 ms, faster than 17.98% of Java online submissions for Knight Probability in Chessboard.
// Memory Usage: 39.5 MB, less than 21.97% of Java online submissions for Knight Probability in Chessboard.

// Using Dynamic Programming: Tabulation Method (Bottom Up) Optimized Approach -> Time: O(k*n^2) and Space: O(n^2) 
class Solution {
    static int directions[][] = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][] prevDP = new double[n][n];
        double[][] currentDP = new double[n][n];
        prevDP[row][column] = 1;
        for(int step = 1; step<=k; step++){
            for(int r = 0; r<n; r++){
                for(int c = 0; c<n; c++){
                    for(int i = 0; i<directions.length; i++){
                        int currentDir[] = directions[i];
                        int prevRow = r + currentDir[0];
                        int prevCol = c + currentDir[1];
                        if(prevRow >= 0 && prevRow<n && prevCol>=0 && prevCol<n){
                            currentDP[r][c] += prevDP[prevRow][prevCol]/8;
                        }
                    }
                }
            }
            prevDP = currentDP;
            currentDP = new double[n][n];
        }
        double ans = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                ans += prevDP[i][j];
        return ans;
    }
}

// Runtime: 21 ms, faster than 13.40% of Java online submissions for Knight Probability in Chessboard.
// Memory Usage: 39.2 MB, less than 25.95% of Java online submissions for Knight Probability in Chessboard.
