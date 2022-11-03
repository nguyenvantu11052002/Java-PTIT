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
import static javaptit.Support.vietTatBoMon;



public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<GiangVien> list = new ArrayList<>();
        //LinkedHashMap<String, ArrayList<GiangVien>> map = new LinkedHashMap<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
//            String vietTat = vietTatBoMon(s2);// CNPM
//            ArrayList<GiangVien> listTrong = new ArrayList<>();
//            listTrong.add(new GiangVien(s1, s2));
//            if (map.containsKey(vietTat)) {
//                map.get(vietTat).add(new GiangVien(s1, s2));
//            }
//            else {
//                map.put(vietTat, listTrong);
//            }
            list.add(new GiangVien(s1, s2));
        }
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN BO MON " + vietTatBoMon(s) + ":");
            for (GiangVien x : list) {
                if (x.vietTatBoMon().equals(vietTatBoMon(s))) {
                    System.out.println(x);
                }
            }
        }
        
    } 
}

//4
//Nguyen Van Tu
//An toan thong tin
//Nguyen Manh Son
//Cong nghe phan mem
//Vu Hoai Nam
//Khoa hoc may tinh
//Dang Minh Tuan
//An toan thong tin
//2
//Cong nghe phan mem
//An toan thong tin

javaptit/Support.java

package javaptit;

public class Support {
    public static String vietTatBoMon(String s) {
        String res = "";
        String[] arr = s.trim().split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
        }
        return res;
    }
}

