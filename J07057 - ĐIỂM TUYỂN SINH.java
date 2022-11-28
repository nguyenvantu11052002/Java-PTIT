DiemTuyenSinh/Main.java
package DiemTuyenSinh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("THISINH.in"));
        ArrayList<ThiSinh> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while(n --> 0){
            String s1 = sc.nextLine();
            double s2 = Double.parseDouble(sc.nextLine());
            String s3 = sc.nextLine();
            int s4 = Integer.parseInt(sc.nextLine());
            list.add(new ThiSinh(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortBy());
        for(ThiSinh x : list){
            System.out.println(x);
        }
        sc.close();
    }
}

//2
//Nguyen  hong ngat
//22
//Kinh
//1
//  Chu thi MINh
//14
//Dao
//3

DiemTuyenSinh/SortBy.java
package DiemTuyenSinh;

import java.util.Comparator;

public class SortBy implements Comparator<ThiSinh>{

    @Override
    public int compare(ThiSinh o1, ThiSinh o2) {
        if(o1.tongDiem() == o2.tongDiem()){
            if(o1.getMaThiSinh().compareTo(o2.getMaThiSinh()) < 0) return -1;
            return 1;
        }
        else {
            if (o1.tongDiem() > o2.tongDiem()) return -1;
            return 1;
        }
    }
}

DiemTuyenSinh/Support.java

package DiemTuyenSinh;

import java.util.*;

public class Support {
    
    public static String chuanHoa(String s){
        String [] arr = s.trim().split("\\s+");
        String res = "";
        for(int i = 0; i < arr.length; i++){
            res += Character.toUpperCase(arr[i].charAt(0));
            for(int j = 1; j < arr[i].length(); j++){
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        return res.trim();
    }
}

DiemTuyenSinh/ThiSinh.java
package DiemTuyenSinh;

import java.util.*;

public class ThiSinh {
    private String maThiSinh, hoTen;
    private double diemThi;
    private String danToc;
    private int khuVuc;
    
    private static int index = 1;
    
    public ThiSinh( String hoTen, double diemThi, String danToc, int khuVuc) {
        this.maThiSinh = "TS" + String.format("%02d", index ++);
        this.hoTen = Support.chuanHoa(hoTen);
        this.diemThi = diemThi;
        this.danToc = danToc;
        this.khuVuc = khuVuc;
    }

    public String getMaThiSinh() {
        return this.maThiSinh;
    }
    
    public double diemUuTienKhuVuc() {
        if (this.khuVuc == 1) return 1.5;
        if (this.khuVuc == 2) return 1.0;
        return 0.0;
    }

    public double diemUuTienDanToc() {
        if (this.danToc.equals("Kinh")) return 0.0;
        return 1.5;
    }
    
    public double tongDiem(){
        return this.diemThi + this.diemUuTienDanToc() + this.diemUuTienKhuVuc();
    }

    public String trangThai() {
        if (tongDiem() >= 20.5) return "Do";
        return "Truot";
    }

    @Override
    public String toString(){
        return this.maThiSinh + " " + this.hoTen + " " + String.format("%.1f", tongDiem()) + " " + trangThai();
    }
}
