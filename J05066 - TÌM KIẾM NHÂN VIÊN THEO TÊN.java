TimKiemNhanVienTheoTen/Main.java
package TimKiemNhanVienTheoTen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        // int gd = 0, tp = 0, pp = 0;
        
        while(n-->0){
            String [] arr = sc.nextLine().trim().split("\\s+");
            String res = "";
            int soHieu = Integer.parseInt(arr[0].substring(4));
            for(int i = 1; i < arr.length; i++){
                res += arr[i] + " ";
            }
            if(arr[0].startsWith("GD") && soHieu > 1){
                arr[0] = "NV" + arr[0].substring(2);
            }
            else{
                if(arr[0].startsWith("TP") && soHieu > 3){
                    arr[0] = "NV" + arr[0].substring(2);
                }
                else {
                    if(arr[0].startsWith("PP") && soHieu > 3){
                        arr[0] = "NV" + arr[0].substring(2);
                    }
                }
            }
            list.add(new NhanVien(arr[0], res.trim()));
        }
        Collections.sort(list, new SortBy());

        int q = Integer.parseInt(sc.nextLine());
        while(q-->0){
            String s = sc.nextLine();
            for(NhanVien x : list){
                if(x.getTenNhanVien().toLowerCase().contains(s.toLowerCase())){
                    System.out.println(x);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

// 6
// GD08001 Nguyen Kim Loan
// TP05002 Hoang Thanh Tuan
// TP05001 Tran Binh Nguyen
// PP06002 Phan Trung Tuan
// PP06001 Tran Quoc Huy
// NV04003 Vo Van Lan
// 2
// OA
// aN
TimKiemNhanVienTheoTen/NhanVien.java
package TimKiemNhanVienTheoTen;

public class NhanVien {
    private String maNhanVien, tenNhanVien;

    public NhanVien(String maNhanVien, String tenNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenNhanVien() {
        return this.tenNhanVien;
    }

    public String chucVu() {
        return this.maNhanVien.substring(0, 2);
    }

    public String heSoLuong() {
        return this.maNhanVien.substring(2, 4);
    }

    public String soHieu() {
        return this.maNhanVien.substring(4);
    }
    
    @Override
    public String toString() {
        return this.tenNhanVien + " " + chucVu() + " " + soHieu() + " " + heSoLuong();
    }

}

TimKiemNhanVienTheoTen/SortBy.java
package TimKiemNhanVienTheoTen;

import java.util.Comparator;

public class SortBy implements Comparator<NhanVien> {
    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if(o1.heSoLuong().equals( o2.heSoLuong())) {
            if(o1.soHieu().compareTo(o2.soHieu()) < 0) return -1;
            return 1;
        }
        else {
            if(o1.heSoLuong().compareTo(o2.heSoLuong()) > 0) return -1;
            return 1; 
        }
    }
}


