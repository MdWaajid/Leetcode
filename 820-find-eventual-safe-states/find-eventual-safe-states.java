import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, state))
                result.add(i);
        }

        return result;
    }

    public boolean dfs(int[][] graph, int node, int[] state) {
        if (state[node] == 1)
            return false;

        if (state[node] == 2)
            return true;

        state[node] = 1;

        for (int next : graph[node]) {
            if (!dfs(graph, next, state))
                return false;
        }

        state[node] = 2;
        return true;
    }
}