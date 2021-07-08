// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
// We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 
// Example 1:
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2

// Example 2:
// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1

// Example 3:
// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1

// Constraints:
//     1 <= k <= n <= 100
//     1 <= times.length <= 6000
//     times[i].length == 3
//     1 <= ui, vi <= n
//     ui != vi
//     0 <= wi <= 100
//     All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

// Using Dijkstra Algorithm
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int adjacencyMatrix[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j)
                    adjacencyMatrix[i][j] = 0;
                else
                    adjacencyMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<times.length;i++){
            int temp[] = times[i];
            adjacencyMatrix[temp[0]-1][temp[1]-1] = temp[2];
        }
        List<Integer> done = new ArrayList<>();
        int dijkstra[] = new int[n];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);
        k--;
        done.add(k);
        dijkstra[k] = 0;
        while(done.size()<n){
            for(int col=0; col<n; col++){
                if(dijkstra[col] > adjacencyMatrix[k][col] + dijkstra[k] && adjacencyMatrix[k][col]!=Integer.MAX_VALUE){
                    dijkstra[col] = adjacencyMatrix[k][col] + dijkstra[k];
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if(done.contains(i)!=true && min > dijkstra[i]){
                    min = dijkstra[i];
                    k = i;
                }
            }
            done.add(k);
        }
        int max = 0;
        for(int i=0; i<n; i++){
            if(dijkstra[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dijkstra[i]);
        }
        return max;
    }
}

// Runtime: 11 ms, faster than 85.14% of Java online submissions for Network Delay Time.
// Memory Usage: 43.4 MB, less than 41.99% of Java online submissions for Network Delay Time.

// Using Bellman Ford Algorithm
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int distances[] = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k-1] = 0;
        for(int i=0; i<n-1; i++){
            int count = 0;
            for(int j=0; j<times.length; j++){
                int source = times[j][0]-1;
                int target = times[j][1]-1;
                int weight = times[j][2];
                if((long)distances[source] + (long)weight < distances[target]){
                    distances[target] = distances[source] + weight;
                    count++;
                }
            }
            if(count == 0)
                break;
        }
        int max = 0;
        for(int i=0; i<n; i++){
            if(distances[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, distances[i]);
        }
        return max;
    }
}

// Runtime: 3 ms, faster than 99.11% of Java online submissions for Network Delay Time.
// Memory Usage: 42 MB, less than 81.67% of Java online submissions for Network Delay Time.
