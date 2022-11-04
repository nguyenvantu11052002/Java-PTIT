Main.java
package javaptit;

import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachHang> list = new ArrayList<>();
        //System.out.println("TEst " + Math.round(123.656));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            int s2 = Integer.parseInt(sc.nextLine());
            int s3 = Integer.parseInt(sc.nextLine());
            list.add(new KhachHang(s1, s2, s3));
        }
        
        //Collections.sort(list, new SortBy());
        
        for (KhachHang x : list) {
            System.out.println(x);
        }
    }
}

//3
//KD
//400
//555
//NN
//58
//400
//CN
//150
//700


KhachHang.java
package javaptit;

import java.util.*;
 
public class KhachHang {
 
    private String maKhachHang, loaiSD;
    private int chiSoCu, chiSoMoi;
    private static int index = 1;
    
    public KhachHang(String loaiSD, int chiSoCu, int chiSoMoi) {
        this.maKhachHang = "KH" + String.format("%02d", index++);
        this.loaiSD = loaiSD;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }
    
    public long heSo() {
        if (this.loaiSD.equals("KD")) return 3;
        if (this.loaiSD.equals("NN")) return 5;
        if (this.loaiSD.equals("TT")) return 4;
        return 2;
    } 
    
    public long thanhTien() {
        return (this.chiSoMoi - this.chiSoCu) * this.heSo() * 550;
    }
    
    public long phuTroi() {
        long res = this.chiSoMoi - this.chiSoCu;
        if (res > 100) return this.thanhTien();
        if (res >= 50) return Math.round(this.thanhTien()/100.00 * 35);
        return 0;
    }
 
    public long tongTienPhaiTra() {
        return this.phuTroi() + this.thanhTien();
    }
    
    @Override
    public String toString() {
        return this.maKhachHang + " " + this.heSo() + " " + 
                this.thanhTien() + " " + this.phuTroi() + " " + this.tongTienPhaiTra();
    }
}
