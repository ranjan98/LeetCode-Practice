// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

// Constraints:
//     m == grid.length
//     n == grid[i].length
//     1 <= m, n <= 300
//     grid[i][j] is '0' or '1'.

// BFS Approach
class Solution {
    public int numIslands(char[][] grid) {
        int directions[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, left, right, down
        int count = 0;
        if(grid.length == 0)
            return 0;
        List<Integer[]> queue = new ArrayList<>();
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    count++;
                    queue.add(new Integer[]{row, col});
                    while(!queue.isEmpty()){
                        Integer currentPosition[] = queue.remove(0);
                        int currentRow = currentPosition[0];
                        int currentCol = currentPosition[1];
                        grid[row][col] = '0';
                        for(int i=0; i<directions.length; i++){
                            int currentDir[] = directions[i];
                            int nextRow = currentRow + currentDir[0];
                            int nextCol = currentCol + currentDir[1];
                            if(nextRow<0 || nextRow>=grid.length || nextCol<0 || nextCol>=grid[0].length){
                                continue;
                            }
                            if(grid[nextRow][nextCol] == '1'){
                                queue.add(new Integer[  ]{nextRow, nextCol});
                                grid[nextRow][nextCol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

// Runtime: 5 ms, faster than 12.68% of Java online submissions for Number of Islands.
// Memory Usage: 41.3 MB, less than 78.15% of Java online submissions for Number of Islands.

// DFS Approach
class Solution {
    static int directions[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, left, right, down
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length == 0)
            return 0;
        List<Integer[]> queue = new ArrayList<>();
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }
    public static void dfs(char grid[][], int currentRow, int currentCol){
        if(currentRow<0 || currentRow>=grid.length || currentCol<0 || currentCol >=grid[0].length){
            return;
        }
        if(grid[currentRow][currentCol] == '1'){
            grid[currentRow][currentCol]  = '0';
            for(int i=0; i<directions.length;i++){
                int currentDir[] = directions[i];
                int nextRow = currentRow + currentDir[0];
                int nextCol = currentCol + currentDir[1];
                dfs(grid, nextRow, nextCol);
            }
        }
    }
}

// Runtime: 1 ms, faster than 99.94% of Java online submissions for Number of Islands.
// Memory Usage: 41.1 MB, less than 87.72% of Java online submissions for Number of Islands.
