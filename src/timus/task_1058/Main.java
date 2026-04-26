package timus.task_1058;

import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Point[] pts = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            pts[i] = new Point(x, y);
        }

        double totalArea = polygonArea(pts);
        double target = totalArea / 2.0;

        double[] cumlen = new double[n + 1];
        for (int i = 0; i < n; i++) {
            cumlen[i + 1] = cumlen[i] + dist(pts[i], pts[(i + 1) % n]);
        }
        double perimeter = cumlen[n];

        double minLen = Double.MAX_VALUE;

        for (int i = 0; i < 5000; i++) {
            double s = i * perimeter / 5000.0;

            double lo = 0, hi = perimeter;
            for (int iter = 0; iter < 60; iter++) {
                double mid = (lo + hi) / 2;
                double e = (s + mid) % perimeter;
                double area = areaFromTo(pts, cumlen, s, e);
                if (area < target) lo = mid;
                else hi = mid;
            }

            double e = (s + lo) % perimeter;
            Point p1 = pointAt(pts, cumlen, s);
            Point p2 = pointAt(pts, cumlen, e);
            double len = dist(p1, p2);

            double area = areaFromTo(pts, cumlen, s, e);
            if (Math.abs(area - target) < 1e-6) {
                minLen = Math.min(minLen, len);
            }
        }

        System.out.println((int)Math.round(minLen));
    }

    static double polygonArea(Point[] p) {
        int n = p.length;
        double area = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            area += p[i].x * p[j].y - p[j].x * p[i].y;
        }
        return Math.abs(area) / 2;
    }

    static double dist(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static Point pointAt(Point[] pts, double[] cumlen, double d) {
        int n = pts.length;
        d = d % cumlen[n];
        for (int i = 0; i < n; i++) {
            if (cumlen[i] <= d && d <= cumlen[i + 1]) {
                double t = (d - cumlen[i]) / (cumlen[i + 1] - cumlen[i]);
                return new Point(
                        pts[i].x + t * (pts[(i + 1) % n].x - pts[i].x),
                        pts[i].y + t * (pts[(i + 1) % n].y - pts[i].y)
                );
            }
        }
        return pts[0];
    }

    static double areaFromTo(Point[] pts, double[] cumlen, double s, double e) {
        List<Point> poly = new ArrayList<>();
        poly.add(pointAt(pts, cumlen, s));

        int n = pts.length;
        double per = cumlen[n];

        for (int i = 0; i < n; i++) {
            double pos = cumlen[i];
            if (s <= e) {
                if (pos >= s - 1e-9 && pos <= e + 1e-9) {
                    boolean exists = false;
                    for (Point p : poly) {
                        if (dist(p, pts[i]) < 1e-9) { exists = true; break; }
                    }
                    if (!exists) poly.add(pts[i]);
                }
            } else {
                if (pos >= s - 1e-9 || pos <= e + 1e-9) {
                    boolean exists = false;
                    for (Point p : poly) {
                        if (dist(p, pts[i]) < 1e-9) { exists = true; break; }
                    }
                    if (!exists) poly.add(pts[i]);
                }
            }
        }

        Point endPt = pointAt(pts, cumlen, e);
        boolean exists = false;
        for (Point p : poly) {
            if (dist(p, endPt) < 1e-9) { exists = true; break; }
        }
        if (!exists) poly.add(endPt);

        if (poly.size() < 3) return 0;

        Point[] arr = new Point[poly.size()];
        poly.toArray(arr);
        return polygonArea(arr);
    }
}