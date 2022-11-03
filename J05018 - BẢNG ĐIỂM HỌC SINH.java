javaptit/HocSinh.java
package javaptit;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HocSinh{
    private String maHocSinh, tenHocSinh;
    private double s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    public static int index = 1;

    public HocSinh(String tenHocSinh, double s1, double s2, double s3, double s4, double s5, double s6, double s7, double s8, double s9, double s10) {
        this.maHocSinh = "HS" + String.format("%02d", index++);
        this.tenHocSinh = tenHocSinh;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;
        this.s7 = s7;
        this.s8 = s8;
        this.s9 = s9;
        this.s10 = s10;
    }
    
    public double diemTrungBinh() {
        double res = (this.s1 * 2 + this.s2 * 2 + this.s3 + this.s4 + this.s5 + this.s6 + this.s7
                 + this.s8 + this.s9 + this.s10) / 12;
        
        return (double) Math.round(res * 10)/10;
    }
    
    public String xepHang() {
        if (this.diemTrungBinh() >= 9) return "XUAT SAC";
        if (this.diemTrungBinh() >= 8) return "GIOI";
        if (this.diemTrungBinh() >= 7) return "KHA";
        if (this.diemTrungBinh() >= 5) return "TB";
        return "YEU";
    }
    
    @Override
    public String toString() {
        return this.maHocSinh + " " + this.tenHocSinh + " " + this.diemTrungBinh() + " " + this.xepHang();
    }
    

}
javaptit/Main.java
package javaptit;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<HocSinh> list = new ArrayList<>();
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String s1 = sc.nextLine();
            double s2 = sc.nextDouble(), s3 = sc.nextDouble(), s4 = sc.nextDouble(), s5 = sc.nextDouble(), s6 = sc.nextDouble();
            double s7 = sc.nextDouble(), s8 = sc.nextDouble(), s9 = sc.nextDouble(), s10 = sc.nextDouble(), s11 = sc.nextDouble();
            list.add(new HocSinh(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11));
        }
        Collections.sort(list, new SortByTime());
        for (HocSinh x : list) {
            System.out.println(x);
        }
    } 
}


//3
//Luu Thuy Nhi
//9.3  9.0  7.1  6.5  6.2  6.0  8.2  6.7  4.8  5.5
//Le Van Tam
//8.0  8.0  5.5  9.0  6.8  9.0  7.2  8.3  7.2  6.8
//Nguyen Thai Binh
//9.0  6.4  6.0  7.5  6.7  5.5  5.0  6.0  6.0  6.0
javaptit/SortByTime.java
package javaptit;

import java.util.*;

public class SortByTime implements Comparator<HocSinh> {

    @Override
    public int compare(HocSinh o1, HocSinh o2) {
        if (o1.diemTrungBinh() > o2.diemTrungBinh()) return -1;
        return 1;
    }
}

