package timus.task_1503;

import java.util.*;

public class Main {

    static double eval(double[] c, double x) {
        double r = 0;
        for (double ci : c) r = r * x + ci;
        return r;
    }

    static double[] deriv(double[] c) {
        int n = c.length - 1;
        if (n == 0) return new double[]{0};
        double[] d = new double[n];
        for (int i = 0; i < n; i++) d[i] = c[i] * (n - i);
        return d;
    }

    static double bisect(double[] c, double a, double b) {
        double fa = eval(c, a);
        for (int i = 0; i < 200; i++) {
            double mid = (a + b) / 2.0;
            double fm = eval(c, mid);
            if (fa * fm <= 0) { b = mid; }
            else { a = mid; fa = fm; }
        }
        return (a + b) / 2.0;
    }

    static List<Double> findDistinctRoots(double[] c, double lo, double hi) {
        List<Double> roots = new ArrayList<>();
        int n = c.length - 1;
        if (n == 0) return roots;

        List<Double> pts = new ArrayList<>();
        pts.add(lo);
        if (n >= 2) {
            pts.addAll(findDistinctRoots(deriv(c), lo, hi));
        }
        pts.add(hi);

        for (int i = 0; i < pts.size() - 1; i++) {
            double a = pts.get(i);
            double b = pts.get(i + 1);
            double fa = eval(c, a);
            double fb = eval(c, b);

            if (Math.abs(fa) < 1e-7) {
                if (roots.isEmpty() || Math.abs(roots.get(roots.size() - 1) - a) > 1e-8) {
                    roots.add(a);
                }
            }

            if (fa * fb < 0) {
                roots.add(bisect(c, a, b));
            }
        }

        double last = pts.get(pts.size() - 1);
        if (Math.abs(eval(c, last)) < 1e-7) {
            if (roots.isEmpty() || Math.abs(roots.get(roots.size() - 1) - last) > 1e-8) {
                roots.add(last);
            }
        }

        return roots;
    }

    static int multiplicity(double[] c, double r) {
        int k = 0;
        double[] poly = Arrays.copyOf(c, c.length);
        while (poly.length > 1 && Math.abs(eval(poly, r)) < 1e-5) {
            k++;
            poly = deriv(poly);
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] c = new double[n + 1];
        for (int i = 0; i <= n; i++) c[i] = sc.nextDouble();

        List<Double> distinct = findDistinctRoots(c, -101.0, 101.0);
        Collections.sort(distinct);

        List<Double> allRoots = new ArrayList<>();
        for (double r : distinct) {
            int mult = multiplicity(c, r);
            for (int i = 0; i < mult; i++) allRoots.add(r);
        }

        StringBuilder sb = new StringBuilder();
        for (double r : allRoots) {
            long rounded = Math.round(r);
            if (Math.abs(r - rounded) < 1e-6) {
                sb.append(rounded).append("\n");
            } else {
                sb.append(String.format(Locale.US, "%.8f", r)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
