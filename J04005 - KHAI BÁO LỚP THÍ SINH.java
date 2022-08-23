package newclass;

import java.math.BigInteger;
import java.util.*;

public class NewClass {
    private String hoTen, ngaySinh;
    private double d1, d2, d3;

    public NewClass(String hoTen, String ngaySinh, double d1, double d2, double d3) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
    
    @Override
    public String toString () {
        return this.hoTen + " " + this.ngaySinh + " " + String.format("%.1f", this.d1 + this.d2 + this.d3);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
       
        while (t-- > 0) {
            String hoTen = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double d1 = sc.nextDouble(), d2 = sc.nextDouble(), d3 = sc.nextDouble();
            NewClass x = new NewClass(hoTen, ngaySinh, d1, d2, d3);
            System.out.println(x);
        }
    }
}


//Nguyen Hoang Ha
//11/10/2001
//4.5
//10.0
//5.5
