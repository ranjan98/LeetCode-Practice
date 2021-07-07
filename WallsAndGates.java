// Given a 2-D array containing -1's (Walls), 0's (Gates) and INF's (empty room). Fill each empty room with the number of steps to the nearest gate.
// If it is impossible to reach a gate, leave INF as the value. INF = Integer.MAX_VALUE = 2147483647.

public class Solution {
    static int directions[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int[][] wallsAndGates(int grid[][]){
        for(int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                if(grid[row][col] == 0){
                    dfs(grid, row, col, 0);
                }
            }
        }
        return grid;
    }
    public static void dfs(int grid[][], int row, int col, int count){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || count>grid[row][col])
            return;
        grid[row][col] = count;
        for(int i=0; i<directions.length;i++){
            int currentDir[] = directions[i];
            int nextRow = row + currentDir[0];
            int nextCol = col + currentDir[1];
            dfs(grid, nextRow, nextCol, count+1);
        }
    }
    public static void main(String args[]){
        int inf = Integer.MAX_VALUE;
        int grid[][] = new int[][]{{inf, -1, 0, inf}, {inf, inf, inf, 0}, {inf, -1, inf, -1}, {0, -1, inf, inf}};
        int resultingGrid[][] = wallsAndGates(grid);
        for(int i=0; i<resultingGrid.length; i++){
            for(int j=0; j<resultingGrid[0].length; j++){
                System.out.print(resultingGrid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

// Premium Problem
// Output:
// 3	-1	0	1	
// 2	2	1	0	
// 1	-1	2	-1	
// 0	-1	3	4	
