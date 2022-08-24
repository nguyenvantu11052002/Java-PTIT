
package javaptit;

import java.util.*;

public class JavaPTIT {
    
    private double x, y;

    public JavaPTIT() {
    }

    public JavaPTIT(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public JavaPTIT (JavaPTIT p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double distance (JavaPTIT secondPoint) {
        return Math.sqrt(Math.pow(x - secondPoint.x, 2) + (y - secondPoint.y) * (y - secondPoint.y));
    }
    
    public static double distance (JavaPTIT p1, JavaPTIT p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble(), d = sc.nextDouble();
            JavaPTIT x = new JavaPTIT(a, b);
            JavaPTIT y = new JavaPTIT(c, d);
            double res = x.distance(y);
            System.out.printf("%.4f", res);
            System.out.println("");
        }
    }
}

