Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        ArrayList<GiaoVien> list = new ArrayList<>();
        int ht = 0;
        int hp = 0;
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int s3 = Integer.parseInt(sc.nextLine());
            GiaoVien x = new GiaoVien(s1, s2, s3);
            if (Support.check(s1) != 0) {
                if (Support.check(s1) == 1) {
                    ht += 1;
                    if (ht <= 1) list.add(x);
                }
                else {
                    hp += 1;
                    if (hp <= 2) list.add(x);
                }
            }
            else {
                list.add(x);
            }
        }
        
        //Collections.sort(list, new SortBy());
        
        for(GiaoVien x : list){
            System.out.println(x);
        }
    }
 
}


//3
//GV01
//Nguyen Kim Loan
//1420000
//HT05
//Hoang Thanh Tuan
//1780000
//GV02
//Tran Binh Nguyen
//1468000
Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static int check(String s) {
        String res = s.substring(0, 2);
        if (res.equals("HT")) return 1;
        if (res.equals("HP")) return 2;
        return 0;
    }
}

GiaoVien.java
package javaptit;

import java.util.*;

public class GiaoVien {

    private String maNganh, hoTen;
    private int luongCoBan;

    public GiaoVien(String maNganh, String hoTen, int luongCoBan) {
        this.maNganh = maNganh;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }
    
    public String getMaNganh() {
        return this.maNganh;
    }
    
    public long bacLuong() {
        return Long.parseLong(this.maNganh.substring(2, 4));
    }
    
    public long phuCap() {
        String res = this.maNganh.substring(0, 2);
        if (res.equals("HT")) return 2000000;
        if (res.equals("HP")) return 900000;
        return 500000;
    }
    
    public long thuNhap() {
        return this.luongCoBan * this.bacLuong() + this.phuCap();
    }

    @Override
    public String toString() {
        return this.maNganh + " " + this.hoTen + " " + this.bacLuong() + " " + this.phuCap() + " " + this.thuNhap();
    }

}

