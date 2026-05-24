package timus.task_1500;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt(); // number of categories
        int N = scanner.nextInt(); // number of intersections
        int M = scanner.nextInt(); // number of street segments

        int[][] edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            edges[i][0] = scanner.nextInt(); // v1
            edges[i][1] = scanner.nextInt(); // v2
            edges[i][2] = scanner.nextInt(); // category
        }

        int minMask = -1;
        int minCount = K + 1;

        // Try all subsets of categories (bitmask enumeration)
        for (int mask = 1; mask < (1 << K); mask++) {
            int count = Integer.bitCount(mask);
            if (count >= minCount) continue;

            if (hasPath(edges, N, mask)) {
                minCount = count;
                minMask = mask;
            }
        }

        // Output minimum number of permits
        System.out.println(minCount);

        // Output the categories
        boolean first = true;
        for (int i = 0; i < K; i++) {
            if ((minMask & (1 << i)) != 0) {
                if (!first) System.out.print(" ");
                System.out.print(i);
                first = false;
            }
        }
        System.out.println();
    }

    // Check if there's a path from 0 to 1 using only edges with categories in mask
    static boolean hasPath(int[][] edges, int N, int mask) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list using only edges with permitted categories
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            int category = edge[2];

            if ((mask & (1 << category)) != 0) {
                adj.get(v1).add(v2);
                adj.get(v2).add(v1);
            }
        }

        // BFS to check if path exists from 0 to 1
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == 1) return true;

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        return false;
    }
}
