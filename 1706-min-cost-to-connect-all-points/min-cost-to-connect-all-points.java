import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] used = new boolean[n];
        int[] minCost = new int[n];

        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;

        int total = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!used[j] && (u == -1 || minCost[j] < minCost[u])) {
                    u = j;
                }
            }

            used[u] = true;
            total += minCost[u];

            for (int v = 0; v < n; v++) {
                if (!used[v]) {
                    int cost = Math.abs(points[u][0] - points[v][0])
                             + Math.abs(points[u][1] - points[v][1]);

                    minCost[v] = Math.min(minCost[v], cost);
                }
            }
        }

        return total;
    }
}