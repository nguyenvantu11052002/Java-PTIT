DanhSachKhachHangTrongFile/KhachHang.java
package DanhSachKhachHangTrongFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KhachHang {
    private String maKhachHang, hoTen, gioiTinh;
    private Date ngaySinh;
    private String diaChi;

    public static int index = 1;
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public KhachHang( String hoTen, String gioiTinh, String ngaySinh, String diaChi) throws ParseException {
        this.maKhachHang = "KH" + String.format("%03d", index ++);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = sdf.parse(ngaySinh);
        this.diaChi = diaChi;
    }

    public Date Tuoi(){
        return this.ngaySinh;
    }

    public String chuanHoa(String s){
        String [] arr = s.trim().split("\\s+");
        String res = "";
        for(int i = 0; i < arr.length; i++){
            res += Character.toUpperCase(arr[i].charAt(0));
            for(int j = 1; j < arr[i].length(); j++){
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " " ;
        }
        return res;
    }

    @Override
    public String toString(){
        return this.maKhachHang + " " + chuanHoa(this.hoTen) + " " + this.gioiTinh + " " + 
           this.diaChi + " " + sdf.format(ngaySinh) ;
    }

}

DanhSachKhachHangTrongFile/Main.java
package DanhSachKhachHangTrongFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        ArrayList<KhachHang> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            list.add(new KhachHang(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortBy());
        for(KhachHang x :list){
            System.out.println(x);
        }
        sc.close();
    }
}


// 2
//  nGuyen VAN     nAm
// Nam
// 12/12/1997
// Mo Lao-Ha Dong-Ha Noi
//  TRan    vAn     biNh
// Nam
// 14/11/1995
// Phung Khoang-Nam Tu Liem-Ha Noi
DanhSachKhachHangTrongFile/SortBy.java
package DanhSachKhachHangTrongFile;

import java.util.Comparator;

public class SortBy implements Comparator<KhachHang>{
    @Override
    public int compare(KhachHang o1, KhachHang o2){
        if(o1.Tuoi().getTime() < o2.Tuoi().getTime()) return -1;
        return 1;
    }
    
}

