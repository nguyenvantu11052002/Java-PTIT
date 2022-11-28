HoaDonKhachSan/KhachHang.java
package HoaDonKhachSan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KhachHang {
    private String maKhachHang, tenKhachHang, soPhong;
    private Date ngayNhanPhong, ngayTraPhong;
    private int tienDichVu;

    private static int index = 1;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public KhachHang( String tenKhachHang, String soPhong, String ngayNhanPhong, String ngayTraPhong,
            int tienDichVu) throws ParseException {
        this.maKhachHang = "KH" + String.format("%02d", index++);
        this.tenKhachHang = tenKhachHang;
        this.soPhong = soPhong;
        this.ngayNhanPhong = sdf.parse(ngayNhanPhong);
        this.ngayTraPhong = sdf.parse(ngayTraPhong);
        this.tienDichVu = tienDichVu;
    }

    public long donGia(){
        String res = this.soPhong.substring(0,1);
        if(res.equals("1")) return 25;
        if(res.equals("2")) return 34;
        if(res.equals("3")) return 50;
        return 80;
    }

    public long soNgayO(){
        return ((this.ngayTraPhong.getTime() - this.ngayNhanPhong.getTime()) ) / (60 * 60 * 1000 * 24) + 1;
    }

    public long thanhTien(){
        return soNgayO() * donGia() + this.tienDichVu;
    }

    @Override
    public String toString(){
        return this.maKhachHang + " " + this.tenKhachHang + " " + soPhong + " " + soNgayO() + " " + thanhTien();
    }
}


HoaDonKhachSan/Main.java
package HoaDonKhachSan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachHang> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            int s5 = Integer.parseInt(sc.nextLine());
            list.add(new KhachHang(s1, s2, s3, s4, s5));
        }
        Collections.sort(list, new SortBy());
        for(KhachHang x : list){
            System.out.println(x);
        }
        sc.close();
    }
}

// 3
// Huynh Van Thanh   
// 103 
// 05/06/2010   
// 05/06/2010   
// 15
// Le Duc Cong  
// 106 
// 08/03/2010   
// 01/05/2010   
// 220
// Tran Thi Bich Tuyen   
// 207 
// 10/04/2010   
// 21/04/2010   
// 96
HoaDonKhachSan/SortBy.java
package HoaDonKhachSan;

import java.util.Comparator;

public class SortBy implements Comparator<KhachHang> {
    @Override
    public int compare(KhachHang o1, KhachHang o2){
        if(o1.thanhTien() > o2.thanhTien()) return -1;
        return 1;
    }
}

