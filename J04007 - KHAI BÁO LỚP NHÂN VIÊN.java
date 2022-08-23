package newclass;

import java.util.*;

public class NewClass {
    private String maNhanVien, hoTen, gioiTinh, ngaySinh, diaChi, maSoThue, ngayKiHopDong;

    public NewClass(String maNhanVien, String hoTen, String gioiTinh, String ngaySinh, String diaChi, String maSoThue, String ngayKiHopDong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKiHopDong = ngayKiHopDong;
    }
    
    
    @Override
    public String toString() {
        return this.maNhanVien + " " + this.hoTen + " " + this.gioiTinh + " " + this.ngaySinh + " "
                + this.diaChi + " " + this.maSoThue + " " + this.ngayKiHopDong;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            //String maNhanVien = sc.nextLine();
            String hoTen = sc.nextLine(), gioiTinh = sc.nextLine(), ngaySinh = sc.nextLine(), diaChi = sc.nextLine();
            String maSoThue = sc.nextLine();
            String ngayKiHopDong = sc.nextLine();
            NewClass x = new NewClass("00001", hoTen, gioiTinh, ngaySinh, diaChi, maSoThue, ngayKiHopDong);
            System.out.println(x);
        }
    }
}

//Nguyen Van Hoa
//Nam
//22/11/1982
//Mo Lao-Ha Dong-Ha Noi
//8333123456
//31/12/2013

