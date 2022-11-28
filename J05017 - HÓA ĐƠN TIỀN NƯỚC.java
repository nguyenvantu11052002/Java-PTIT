HoaDonTienNuoc/KhachHang.java
package HoaDonTienNuoc;

public class KhachHang{
    private String maKhachHang, tenKhachHang;
    private int chiSoCu, chiSoMoi;

    private static int index = 1;

    public KhachHang( String tenKhachHang, int chiSoCu, int chiSoMoi) {
        this.maKhachHang = "KH" + String.format("%02d", index ++);
        this.tenKhachHang = tenKhachHang;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }

    public int soNuoc(){
        return this.chiSoMoi - this.chiSoCu;
    }

    public long tongSoTien(){
        if(soNuoc() > 100) return 50 * 100 + 50 * 150 + (soNuoc() -100) * 200;
        if(soNuoc() >= 51) return 50 * 100 + (soNuoc() - 50) * 150;
        return soNuoc() * 100;
    }

    public double phuPhi(){
        if(soNuoc() > 100) return Math.round(tongSoTien() * 0.05);
        if(soNuoc() >= 51) return Math.round(tongSoTien() * 0.03);
        return Math.round(tongSoTien() * 0.02);
    }

    public long thanhTien(){
        return (long) (tongSoTien() + phuPhi());
    }

    @Override
    public String toString(){
        return this.maKhachHang + " " + this.tenKhachHang + " " + thanhTien();
    }
}
HoaDonTienNuoc/Main.java
package HoaDonTienNuoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachHang> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            int s2 = Integer.parseInt(sc.nextLine());
            int s3 = Integer.parseInt(sc.nextLine());
            list.add(new KhachHang(s1, s2, s3));
        }
        Collections.sort(list, new SortBy());
        for(KhachHang x : list){
            System.out.println(x);
        }
        sc.close();
    }
}

// 3
// Le Thi Thanh
// 468
// 500
// Le Duc Cong
// 160
// 230
// Ha Hue Anh
// 410
// 612
HoaDonTienNuoc/SortBy.java
package HoaDonTienNuoc;

import java.util.Comparator;

public class SortBy  implements Comparator<KhachHang>{
    @Override
    public int compare(KhachHang o1, KhachHang o2){
        if(o1.thanhTien() > o2.thanhTien()) return -1;
        return 1;
    }
    
}

