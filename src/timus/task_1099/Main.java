package timus.task_1099;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] g;
    static int[] match, p, base;
    static boolean[] used, blossom;
    static Queue<Integer> q;

    static int lca(int a, int b) {
        boolean[] usedPath = new boolean[n];
        while (true) {
            a = base[a];
            usedPath[a] = true;
            if (match[a] == -1) break;
            a = p[match[a]];
        }
        while (true) {
            b = base[b];
            if (usedPath[b]) return b;
            b = p[match[b]];
        }
    }

    static void markPath(int v, int b, int child) {
        while (base[v] != b) {
            blossom[base[v]] = blossom[base[match[v]]] = true;
            p[v] = child;
            child = match[v];
            v = p[match[v]];
        }
    }

    static boolean findPath(int root) {
        Arrays.fill(used, false);
        Arrays.fill(p, -1);
        for (int i = 0; i < n; i++) base[i] = i;

        q.clear();
        q.add(root);
        used[root] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int u : g[v]) {
                if (base[v] == base[u] || match[v] == u) continue;

                if (u == root || (match[u] != -1 && p[match[u]] != -1)) {
                    int curbase = lca(v, u);
                    Arrays.fill(blossom, false);
                    markPath(v, curbase, u);
                    markPath(u, curbase, v);
                    for (int i = 0; i < n; i++) {
                        if (blossom[base[i]]) {
                            base[i] = curbase;
                            if (!used[i]) {
                                used[i] = true;
                                q.add(i);
                            }
                        }
                    }
                } else if (p[u] == -1) {
                    p[u] = v;
                    if (match[u] == -1) {
                        // увеличиваем паросочетание
                        int cur = u;
                        while (cur != -1) {
                            int prev = p[cur];
                            int next = (prev != -1) ? match[prev] : -1;
                            match[cur] = prev;
                            if (prev != -1) match[prev] = cur;
                            cur = next;
                        }
                        return true;
                    } else {
                        used[match[u]] = true;
                        q.add(match[u]);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length != 2) break;

            int u = Integer.parseInt(parts[0]) - 1;
            int v = Integer.parseInt(parts[1]) - 1;

            g[u].add(v);
            g[v].add(u);
        }

        match = new int[n];
        Arrays.fill(match, -1);
        p = new int[n];
        base = new int[n];
        used = new boolean[n];
        blossom = new boolean[n];
        q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (match[i] == -1) {
                findPath(i);
            }
        }

        List<int[]> res = new ArrayList<>();
        boolean[] usedOut = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (match[i] != -1 && !usedOut[i]) {
                res.add(new int[]{i, match[i]});
                usedOut[i] = usedOut[match[i]] = true;
            }
        }

        System.out.println(res.size() * 2);
        for (int[] pair : res) {
            System.out.println((pair[0] + 1) + " " + (pair[1] + 1));
        }
    }
}