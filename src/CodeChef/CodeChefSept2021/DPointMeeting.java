package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.*;

public class DPointMeeting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        double x[] = new double[n];
        double y[] = new double[n];


        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            x[i] *= 2;
        }

        for (int i = 0; i < n; i++) {
            y[i] = in.nextInt();
            y[i] *= 2;
        }

        int ans = getAns(n, x, y);
        out.println(ans);
    }

    public int getAns(int n, double[] x, double[] y) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double range = Integer.MAX_VALUE + 90000000;
            //horizontal
            Point p1 = new Point(x[i] - range, y[i]);
            Point p2 = new Point(x[i] + range, y[i]);
            lines.add(new Line(p1, p2));

            // vertical
            p1 = new Point(x[i], y[i] - range);
            p2 = new Point(x[i], y[i] + range);
            lines.add(new Line(p1, p2));

            // diagonal 1
            p1 = new Point(x[i] - range, y[i] - range);
            p2 = new Point(x[i] + range, y[i] + range);
            lines.add(new Line(p1, p2));

            // diagonal 2
            p1 = new Point(x[i] - range, y[i] + range);
            p2 = new Point(x[i] + range, y[i] - range);
            lines.add(new Line(p1, p2));
        }
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.size(); j++) {
                if (i == j) continue;
                Point p1 = lines.get(i).getPoint1();
                Point p2 = lines.get(i).getPoint2();
                Point p3 = lines.get(j).getPoint1();
                Point p4 = lines.get(j).getPoint2();
                Point intersection = lineIntersection(p1, p2, p3, p4);
                if (intersection.getX() == Double.MAX_VALUE && intersection.getY() == Double.MAX_VALUE) continue;
                map.compute(intersection, (key, value) -> value == null ? 1 : value + 1);
            }
        }

        List<Point2> maxPoints = new ArrayList();
        int ans2 = Integer.MAX_VALUE;
        for (Map.Entry entry : map.entrySet()) {
            int value = (int) entry.getValue();
            Point main = (Point) entry.getKey();

            if (value > 0) {
                List<Point> temp = new ArrayList<>();

                double x1 = (double) (main.x >= 0 ? main.x + 1 : main.x - 1);
                double x2 = (double) (main.x);
                double y1 = (double) (main.y >= 0 ? main.y + 1 : main.y - 1);
                double y2 = (double) (main.y);
                Point p1 = new Point(x1, y1);
                Point p3 = new Point(x1, y2);
                //same
                Point p2 = new Point(x2, y1);
                Point p4 = new Point(x2, y2);
                temp.add(p1);
                temp.add(p2);
                temp.add(p3);
                temp.add(p4);

                for (int i = 0; i < 4; i++) {
                    int tempAns = 0;
                    for (int j = 0; j < n; j++) {
                        Point p11 = temp.get(i);
//                        if(p11.getX() == 75 || p11.getX()==76) System.out.println(main.toString() + p11.toString() + " "+ x1+" "+ y1 +" "+x2+" "+y2);
                        tempAns += getOperations(x[j], y[j], (double) p11.getX(), (double) p11.getY());
                    }
//                    System.out.println(temp.get(i));
                    if (ans2 > tempAns) ans2 = tempAns;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
/*        for (int i = 0; i < maxPoints.size(); i++) {
            int tempAns = 0;
            for (int j = 0; j < n; j++) {
                Point2 p1 = maxPoints.get(i);
                double distance1 = Math.abs(x[j] - p1.getX());
                double distance2 = Math.abs(y[j] - p1.getY());
                if (distance2 == distance1 && distance2 == 0) continue;
                if (distance2 == distance1) tempAns += 1;
                else if (p1.getX() == x[j]) tempAns += 1;
                else if (p1.getY() == y[j]) tempAns += 1;
                else tempAns += 2;

            }
            if (ans > tempAns) ans = tempAns;
        }
*/
/*        for (int i = 0; i < n; i++) {
            int tempAns = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                double distance1 = Math.abs(x[i] - x[j]);
                double distance2 = Math.abs(y[i] - y[j]);
                if (distance2 == distance1) tempAns += 1;
                else if (x[i] == x[j]) tempAns += 1;
                else if (y[i] == y[j]) tempAns += 1;
                else tempAns += 2;

            }
            if (ans > tempAns) ans = tempAns;
        }*/
        for (int k = 0; k < n; k++) {
            double xx = x[k];
            for (int i = 0; i < n; i++) {
                double yy = y[i];
                int tempAns = 0;
                for (int j = 0; j < n; j++) {
                    tempAns += getOperations(x[j], y[j], xx, yy);

                }
//                System.out.println("Printing " + k+" "+i);
                if (ans > tempAns) ans = tempAns;
            }
        }
        ans = Math.min(ans, ans2);
        return ans;
    }

    public int getOperations(double x, double y, double xx, double yy) {
        int tempAns = 0;
        double distance1 = Math.abs(x - xx);
        double distance2 = Math.abs(y - yy);
        if (distance2 == distance1 && distance2 == 0) return tempAns;
        if (distance2 == distance1) tempAns += 1;
        else if (xx == x) tempAns += 1;
        else if (yy == y) tempAns += 1;
        else tempAns += 2;
        return tempAns;
    }

    static Point lineIntersection(Point A, Point B, Point C, Point D) {
        double a1 = B.y - A.y;
        double b1 = A.x - B.x;
        double c1 = a1 * (A.x) + b1 * (A.y);

        double a2 = D.y - C.y;
        double b2 = C.x - D.x;
        double c2 = a2 * (C.x) + b2 * (C.y);

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        } else {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            return new Point(x, y);
        }
    }

    static class Line {
        Point point1, point2;

        public Line(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
        }

        public Point getPoint1() {
            return point1;
        }

        public void setPoint1(Point point1) {
            this.point1 = point1;
        }

        public Point getPoint2() {
            return point2;
        }

        public void setPoint2(Point point2) {
            this.point2 = point2;
        }
    }

    static class Point {
        double x, y;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Point2 {
        int x, y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public Point2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
