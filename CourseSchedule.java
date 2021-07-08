// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//     For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Example 2:
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

// Constraints:
//     1 <= numCourses <= 10^5
//     0 <= prerequisites.length <= 5000
//     prerequisites[i].length == 2
//     0 <= ai, bi < numCourses
//     All the pairs prerequisites[i] are unique.

// BFS approach will not be efficient here since we need to do BFS at every node. Instead, we use topological sort to get optimal solution

// Using Topologial Sort with Adjacency List
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int inDegree[] = new int[numCourses];
        List<Integer> adjacencyList[] = new ArrayList[numCourses];
        for(int i=0; i<numCourses;i++){
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i=0; i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;
            adjacencyList[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        List<Integer> stack = new ArrayList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                stack.add(i);
            }
        }
        int count = 0;
        while(stack.size()>0){
            int current = stack.remove(stack.size()-1);
            count++;
            List<Integer> adjacent = adjacencyList[current];
            for(int i=0; i<adjacent.size(); i++){
                int next = adjacent.get(i);
                inDegree[next]--;
                if(inDegree[next] == 0){
                    stack.add(next);
                }
            }
        }
        return count==numCourses;
    }
}

// Runtime: 3 ms, faster than 85.86% of Java online submissions for Course Schedule.
// Memory Usage: 39 MB, less than 95.38% of Java online submissions for Course Schedule.
