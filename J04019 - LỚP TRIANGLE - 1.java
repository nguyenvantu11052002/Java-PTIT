package javaptit;

import java.util.*;

class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public static Point nextPoint (Scanner sc) {
        Point a = new Point(0, 0);
        a.x = sc.nextDouble();
        a.y = sc.nextDouble();
        return a;
    }
    
    public double getX () {
        return this.x;
    }
    
    public double getY () {
        return this.y;
    }
}

class Triangle{
    private Point A,B,C;

    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    public double KC (Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
    
    public double AB () {
        return this.KC(this.A, this.B);
    }
    
    public double BC () {
        return this.KC(this.B, this.C);
    }
    
    public double AC () {
        return this.KC (this.A, this.C);
    }
    
    public boolean valid () {
        double AB = this.AB();
        double BC = this.BC();
        double AC = this.AC();
        if (AB + BC <= AC || AB + AC <= BC || BC + AC <= AB || AB <= 0 || BC <= 0 || AC <= 0) return false;
        return true;
    }
    
    public String getPerimeter () {
        String res = String.format("%.3f", this.AB() + this.BC() + this.AC());
        return res;
    }
    
}

public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
    public static void main5038347(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}




