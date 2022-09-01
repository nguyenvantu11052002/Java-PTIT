package javaptit;

import java.util.*;

public class ThiSinh implements Comparable<ThiSinh>  {

    private String maThiSinh, hoTen, ngaySinh;
    private double diemMonMot, diemMonHai, diemMonBa;
    public static int id = 1;

    public ThiSinh(String hoTen, String ngaySinh, double diemMonMot, double diemMonHai, double diemMonBa) {
        this.maThiSinh = Integer.toString(id++);
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diemMonMot = diemMonMot;
        this.diemMonHai = diemMonHai;
        this.diemMonBa = diemMonBa;
    }
    
    public double tongDiem () {
        return this.diemMonBa + this.diemMonHai + this.diemMonMot;
    }
    
    public String getMa () {
        return this.maThiSinh;
    }
    
    @Override 
    public int compareTo (ThiSinh other) {
        if (this.tongDiem() == other.tongDiem()) {
            if (this.getMa().compareTo(other.getMa()) < 0) {
                return -1;
            }
            return 1;
        }
        else {
            if (this.tongDiem() > other.tongDiem()) return -1;
            return 1;
        }
    }
    
    @Override
    public String toString () {
        return this.maThiSinh + " " + this.hoTen + " " + this.ngaySinh + " " + this.tongDiem();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            List<ThiSinh> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s1 = sc.nextLine(), s2 = sc.nextLine();
                double s3 = Double.parseDouble(sc.nextLine());
                double s4 = Double.parseDouble(sc.nextLine());
                double s5 = Double.parseDouble(sc.nextLine());
                ThiSinh x = new ThiSinh(s1, s2, s3, s4, s5);
                list.add(x);
            }
            Collections.sort(list);
            double maxDiem = 0.0;
            for (ThiSinh x : list) {
                maxDiem = Math.max(maxDiem, x.tongDiem());
            }
            for (ThiSinh x : list) {
                if (x.tongDiem() == maxDiem) {
                    System.out.println(x);
                }
            }
        }
    }
}
