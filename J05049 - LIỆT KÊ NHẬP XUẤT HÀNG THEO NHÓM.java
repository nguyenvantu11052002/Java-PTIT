javaptit/Main.java
package javaptit;

import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NongSan> list = new ArrayList<>();
 
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            int s2 = Integer.parseInt(sc.nextLine());
            list.add(new NongSan(s1, s2));
        }
        String tmp = sc.nextLine();
        Collections.sort(list, new SortBy());
        for (NongSan x : list) {
            if (x.getMaNongSan().startsWith(tmp)) {
                System.out.println(x);
            }
        }
    }
}

//3
//A001Y
//1000
//B012N
//2500
//B003Y
//4582



javaptit/NongSan.java
package javaptit;

import java.util.*;
 
public class NongSan {
 
    private String maNongSan;
    private int soLuongNhap;

    public NongSan(String maNongSan, int soLuongNhap) {
        this.maNongSan = maNongSan;
        this.soLuongNhap = soLuongNhap;
    }
    
    public String getMaNongSan() {
        return this.maNongSan;
    }
    
    public long soLuongXuat() {
        if (this.maNongSan.substring(0, 1).equals("A")) {
            return Math.round(this.soLuongNhap * 0.6);
        }
        return Math.round(this.soLuongNhap * 0.7);
    }
    
    public long donGia() {
        if (this.maNongSan.endsWith("Y")) {
            return 110000;
        }
        return 135000;
    }
    
    public long tien() {
        return this.donGia() * this.soLuongXuat();
    }
    
    public long thue() {
        String c = this.maNongSan;
        if (c.startsWith("A") && c.endsWith("Y")) return Math.round(0.08 * this.tien());
        if (c.startsWith("A") && c.endsWith("N")) return Math.round(0.11 * this.tien());
        if (c.startsWith("B") && c.endsWith("Y")) return Math.round(0.17 * this.tien());
        return Math.round(0.22 * this.tien());
    }
 
    @Override
    public String toString() {
        return this.maNongSan + " " + this.soLuongNhap + " " + this.soLuongXuat() + " " + this.donGia() +
                " " + this.tien() + " " + this.thue();
 
    }
}
javaptit/SortBy.java
package javaptit;

import java.util.*;

public class SortBy implements Comparator<NongSan> {
    @Override
    public int compare(NongSan o1, NongSan o2) {
        if (o1.thue() > o2.thue()) return -1;
        return 1;
    }
}

