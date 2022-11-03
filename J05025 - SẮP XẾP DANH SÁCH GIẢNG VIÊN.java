javaptit/GiangVien.java
package javaptit;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class GiangVien{
    private String maGiangVien, tenGiangVien, boMon;

    public static int index = 1;
    
    public GiangVien(String tenGiangVien, String boMon) {
        this.maGiangVien = "GV" + String.format("%02d", index++);
        this.tenGiangVien = tenGiangVien;
        this.boMon = boMon;
    }
    
    public String vietTatBoMon() {
        String res = "";
        String[] arr = this.boMon.trim().split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
        }
        return res;
    }
    
    public String getTen() {
        String[] arr = this.tenGiangVien.trim().split("\\s+");
        int n = arr.length;
        return arr[n - 1];
    }
    
    @Override
    public String toString() {
        return this.maGiangVien + " " + this.tenGiangVien + " " + this.vietTatBoMon();
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
        ArrayList<GiangVien> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            list.add(new GiangVien(s1, s2));
        }
        Collections.sort(list, new SortByTime());
        for (GiangVien x : list) {
            System.out.println(x);
        }
    } 
}

//3
//Nguyen Manh Son
//Cong nghe phan mem
//Vu Hoai Nam
//Khoa hoc may tinh
//Dang Minh Tuan
//An toan thong tin

javaptit/SortByTime.java
package javaptit;

import java.util.*;

public class SortByTime implements Comparator<GiangVien> {

    @Override
    public int compare(GiangVien o1, GiangVien o2) {
        if (o1.getTen().compareTo(o2.getTen()) < 0) return -1;
        return 1;
    }
}

