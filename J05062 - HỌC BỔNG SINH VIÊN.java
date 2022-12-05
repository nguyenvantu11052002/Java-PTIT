Main.java
package javaptit;
 
import java.util.*;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Double> listDiem = new ArrayList<>();
        ArrayList<SinhVien> listSV = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String s1 = sc.nextLine();
            double s2 = sc.nextDouble();
            int s3 = sc.nextInt();
            listDiem.add(s2);
            listSV.add(new SinhVien(s1, s2, s3));
        }
        Collections.sort(listDiem, Comparator.reverseOrder());
        double diemMoc = listDiem.get(m - 1);
        for (SinhVien x : listSV) {
            if (x.getDiemTrungBinh() >= diemMoc && x.getDiemRenLuyen() >= 70) {
                System.out.println(x + Support.solve(x.getDiemTrungBinh(), x.getDiemRenLuyen()));
            }
            else{
                System.out.println(x + "KHONG");
            }
        }
    }
}
 

Support.java

package javaptit;

import java.util.ArrayList;
import java.util.Stack;

public class Support {

    public static String solve(double x, int y) {
        if (x >= 3.6 && y >= 90) return "XUATSAC";
        if (x >= 3.2 && y >= 80) return "GIOI";
        if (x >= 2.5 && y >= 70) return "KHA";
        return "KHONG";
    }
}

SinhVien.java
package javaptit;

import java.util.*;

public class SinhVien {
    private String hoTen;
    private double diemTrungBinh;
    private int diemRenLuyen;

    public SinhVien(String hoTen, double diemTrungBinh, int diemRenLuyen) {
        this.hoTen = hoTen;
        this.diemTrungBinh = diemTrungBinh;
        this.diemRenLuyen = diemRenLuyen;
    }
    
    public int getDiemRenLuyen() {
        return this.diemRenLuyen;
    }
    
    public double getDiemTrungBinh() {
        return this.diemTrungBinh;
    }
    
    @Override
    public String toString() {
        return this.hoTen + ": ";
    }

}

