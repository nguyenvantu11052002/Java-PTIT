Main.java
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
        //Collections.sort(list, new SortBy());
        for (NongSan x : list) {
            System.out.println(x);
        }
    }
}

//2
//Ao phong tre em
//Cai
//25000
//41000
//Ao khoac nam
//Cai
//240000
//515000



NongSan.java
package javaptit;

import java.util.*;
 
public class NongSan {
 
    private String maNongSan;
    private int soLuongNhap;

    public NongSan(String maNongSan, int soLuongNhap) {
        this.maNongSan = maNongSan;
        this.soLuongNhap = soLuongNhap;
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
