Main.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        ArrayList<SinhVien> listSV = new ArrayList<>();
        
        ArrayList<BTL> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            SinhVien x = new SinhVien(s1, s2, s3, s4);
            listSV.add(x);
        }
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            list.add(new BTL(s));
        }
        Collections.sort(listSV, new SortBy());
        for (SinhVien x : listSV) {
            System.out.print(x + " ");
            System.out.println(list.get(Integer.parseInt(x.getSoThuTuNhom()) - 1).getBtl());
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
    
    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    public String getSoThuTuNhom() {
        return this.soThuTuNhom;
    }
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.soDienThoai + " " + this.soThuTuNhom;
    }
    
}

SortBy.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class SortBy implements Comparator<SinhVien>{
    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        if (o1.getMaSinhVien().compareTo(o2.getMaSinhVien()) < 0) return -1;
        return 1;
    }
}

