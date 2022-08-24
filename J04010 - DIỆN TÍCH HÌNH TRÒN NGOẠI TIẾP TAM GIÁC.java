
package javaptit;

import java.util.*;

public class Point {
    
    private double x, y;

    public Point() {
            
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point (Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double distance (Point secondPoint) {
        return Math.sqrt(Math.pow(x - secondPoint.x, 2) + Math.pow(y - secondPoint.y, 2));
    }
    
    public static double distance (Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
    
    public static boolean check (double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a || a <= 0 || b <= 0 || c <= 0) return false;
        return true;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble(), d = sc.nextDouble(), e = sc.nextDouble(), f = sc.nextDouble();
            Point x = new Point(a, b);
            Point y = new Point(c, d);
            Point z = new Point(e, f);
            double ab = distance(x, y);
            double bc = distance(x, z);
            double ac = distance(y, z);
            if (check(ab, bc, ac)) {
                double p = 1.0 * (ab + bc + ac) / 2;
                double dienTich = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
                double banKinh = (ab * bc * ac) / (4 * dienTich);
                double res = banKinh * banKinh * Math.PI;
                System.out.printf("%.3f", res);
                System.out.println("");
            }
            else {
                System.out.println("INVALID");
            }
        }
    }
}

//3
//0 0 0 5 0 199
//1 1 1 1 1 1
//0 0 0 5 5 0
