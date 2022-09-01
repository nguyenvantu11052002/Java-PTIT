package javaptit;

import java.util.*;

public class NhanVien implements Comparable<NhanVien>  {

    private String maNhanVien, hoTen, ngaySinh, gioiTinh, diaChi, maSoThue, ngayKiHopDong;
    public static int id = 1;
    public NhanVien(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String maSoThue, String ngayKiHopDong) {
        this.maNhanVien = "000" + String.format("%02d", id++);
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKiHopDong = ngayKiHopDong;
    }
    public String getNgaySinh () {
        String[] arr = this.ngaySinh.trim().split("/");
        return arr[2] + arr[1] + arr[0];
    }
    
    @Override
    public String toString () {
        return this.maNhanVien + " " + this.hoTen + " " + this.gioiTinh + " " + this.ngaySinh + " " + 
                this.diaChi + " " + this.maSoThue + " " + this.ngayKiHopDong;
    }
    
    @Override
    public int compareTo (NhanVien other) {
        if (this.getNgaySinh().compareTo(other.getNgaySinh()) < 0) return -1;
        return 1;
    } 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            List<NhanVien> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine(),
                        s4 = sc.nextLine(), s5 = sc.nextLine(), s6 = sc.nextLine();
                NhanVien x = new NhanVien(s1, s2, s3, s4, s5, s6);
                list.add(x);
            }
            Collections.sort(list);
            for (NhanVien x : list) {
                System.out.println(x);
            }
        }
    }

}

//3
//Nguyen Van A
//Nam
//22/10/1982
//Mo Lao-Ha Dong-Ha Noi
//8333012345
//31/12/2013
//Ly Thi B
//Nu
//15/10/1988
//Mo Lao-Ha Dong-Ha Noi
//8333012346
//22/08/2011
//Hoang Thi C
//Nu
//04/02/1981
//Mo Lao-Ha Dong-Ha Noi
//8333012347
//22/08/2011
