class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }

        int[][] dist = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // {distance, node, remainingK}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[0][k] = 0;
        pq.offer(new int[]{0, 0, k});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int d = curr[0];
            int u = curr[1];
            int rem = curr[2];

            if (d != dist[u][rem]) continue;

            for (int[] nei : adj[u]) {

                int v = nei[0];
                int w = nei[1];

                int newRem =
                    labels.charAt(u) == labels.charAt(v)
                    ? rem - 1
                    : k;

                if (newRem <= 0) continue;

                if (d + w < dist[v][newRem]) {
                    dist[v][newRem] = d + w;
                    pq.offer(new int[]{d + w, v, newRem});
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int rem = 1; rem <= k; rem++) {
            ans = Math.min(ans, dist[n - 1][rem]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}