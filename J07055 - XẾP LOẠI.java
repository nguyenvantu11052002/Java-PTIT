XepLoai/Main.java
package XepLoai;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        ArrayList<SinhVien> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            double s2 = Double.parseDouble(sc.nextLine());
            double s3 = Double.parseDouble(sc.nextLine());
            double s4 = Double.parseDouble(sc.nextLine());
            list.add(new SinhVien(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortBy());
        for(SinhVien x : list){
            System.out.println(x);
        }
        sc.close();
    }
}

// 2
//  ha Thi kieu     anh
// 7
// 6
// 7
// Pham    THI  HAO
// 6
// 7
// 6
XepLoai/SinhVien.java
package XepLoai;

public class SinhVien {
    private String maSinhVien, hoTen;
    private double diemLuyenTap, diemThucHanh, diemThi;

    private static int index = 1;

    public SinhVien( String hoTen, double diemLuyenTap, double diemThucHanh, double diemThi) {
        this.maSinhVien = "SV" + String.format("%02d", index++);
        this.hoTen = hoTen;
        this.diemLuyenTap = diemLuyenTap;
        this.diemThucHanh = diemThucHanh;
        this.diemThi = diemThi;
    }

    public double diemTongKet(){
        return this.diemLuyenTap * 0.25 + this.diemThucHanh * 0.35 + this.diemThi * 0.4;
    }
    
    public String xepLoai(){
        if(diemTongKet() >= 8) return "GIOI";
        if(diemTongKet() >= 6.5) return "KHA";
        if(diemTongKet() >= 5) return "TRUNG BINH";
        return "KEM";
    }

    public String chuanHoa(){
        String [] arr = this.hoTen.trim().split("\\s+");
        String res = "";
        for(int i = 0; i < arr.length; i++){
            res += Character.toUpperCase(arr[i].charAt(0));
            for(int j = 1; j < arr[i].length(); j++){
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        return res;
    }

    @Override
    public String toString(){
        return this.maSinhVien + " " + chuanHoa() + " " + String.format("%.2f", diemTongKet()) + " " + xepLoai();
    }
}

XepLoai/SortBy.java
package XepLoai;

import java.util.Comparator;

public class SortBy implements Comparator<SinhVien>{
    @Override
    public int compare(SinhVien o1, SinhVien o2){
        if(o1.diemTongKet() > o2.diemTongKet()) return -1;
        return 1;
    }
}

