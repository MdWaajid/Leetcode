import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            }
        );

        pq.offer(new int[]{grid[0][0], 0, 0});

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int time = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (visited[r][c])
                continue;

            visited[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return time;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int newTime = Math.max(time, grid[nr][nc]);

                    pq.offer(new int[]{newTime, nr, nc});
                }
            }
        }

        return -1;
    }
}