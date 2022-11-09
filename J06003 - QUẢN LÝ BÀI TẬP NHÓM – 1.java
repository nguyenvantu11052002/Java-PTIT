Main.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        HashMap<String, ArrayList<SinhVien>> map = new HashMap<>();
        ArrayList<BTL> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            SinhVien x = new SinhVien(s1, s2, s3, s4);
            ArrayList<SinhVien> listSV = new ArrayList<>();
            listSV.add(x);
            if (map.containsKey(s4)) {
                map.get(s4).add(x);
            }
            else {
                map.put(s4, listSV);
            }
        }
        
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            list.add(new BTL(s));
        }
        
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            System.out.println("DANH SACH NHOM " + s + ":");
            for (SinhVien x : map.get(s)) {
                System.out.println(x);
            }
            System.out.println("Bai tap dang ky: " + list.get(Integer.parseInt(s) - 1).getBtl());
        }
        
    }
}

//5 2
//B17DTCN001
//Nguyen Chi  Linh
//0987345543
//1
//B17DTCN011
//Vu Viet Thang
//0981234567
//1
//B17DTCN023
//Pham Trong Thang
//0992123456
//1
//B17DTCN022
//Nguyen Van  Quyet
//0977865432
//2
//B17DTCN031
//Ngo Thanh Vien
//0912313111
//2
//Xay dung website ban dien thoai truc tuyen
//Xay dung ung dung quan ly benh nhan Covid-19
//1
//1
BTL.java
package javaptit;

import java.util.*;

public class BTL {
    private String btl;

    public BTL(String btl) {
        this.btl = btl;
    }

    public String getBtl() {
        return this.btl;
    }
    
}

SinhVien.java
package javaptit;

import java.util.*;

public class SinhVien {
    private String maSinhVien, hoTen, soDienThoai, soThuTuNhom;

    public SinhVien(String maSinhVien, String hoTen, String soDienThoai, String soThuTuNhom) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soThuTuNhom = soThuTuNhom;
    }
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.soDienThoai;
    }
    
}

