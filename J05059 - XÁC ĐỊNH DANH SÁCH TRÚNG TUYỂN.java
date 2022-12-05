XacDinhDanhSachTrungTuyen/Main.java
package XacDinhDanhSachTrungTuyen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (System.in);
        ArrayList<ThiSinh> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while(n --> 0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            double s3 = Double.parseDouble(sc.nextLine());
            double s4 = Double.parseDouble(sc.nextLine());
            double s5 = Double.parseDouble(sc.nextLine());
            list.add(new ThiSinh(s1, s2, s3, s4, s5));
        }
        Collections.sort(list, new SortBy());
        int h = sc.nextInt();
        double diemChuan = list.get(h - 1).diemXetTuyen();
        System.out.printf("%.1f\n", diemChuan);
        for(ThiSinh x : list){
            // System.out.println(x);
            if(x.diemXetTuyen() >= diemChuan) {
                System.out.println(x + " TRUNG TUYEN");
            }
            else {
                System.out.println(x + " TRUOT");
            }
        sc.close();
    }
}
}


// 2
// KV2A002
// Hoang THAnh tuan
// 5
// 6
// 5
// KV3B123
//  LY Thi   THU ha
// 8
// 6.5
// 7
// 1
XacDinhDanhSachTrungTuyen/SortBy.java
package XacDinhDanhSachTrungTuyen;

import java.util.Comparator;

public class SortBy implements Comparator<ThiSinh>{
    @Override 
    public int compare(ThiSinh o1, ThiSinh o2)  {
        if(o1.diemXetTuyen() == o2.diemXetTuyen()){
            if(o1.getMaThiSinh().compareTo(o2.getMaThiSinh()) < 0) return -1;
            return 1;
        }
        if(o1.diemXetTuyen() > o2.diemXetTuyen()) return -1;
        return 1;
    }
    
}

XacDinhDanhSachTrungTuyen/ThiSinh.java
package XacDinhDanhSachTrungTuyen;

public class ThiSinh {
    private String maThiSinh, hoTen;
    private double diemToan, diemLy, diemHoa;
   

    public ThiSinh(String maThiSinh, String hoTen, double diemToan, double diemLy, double diemHoa) {
        this.maThiSinh = maThiSinh;
        this.hoTen = hoTen;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public String getMaThiSinh() {
        return this.maThiSinh;
    }

    public double diemUuTien() {
        String res = this.maThiSinh.substring(0, 3);
        if (res.equals("KV1")) return 0.5;
        if (res.equals("KV2")) return 1.0;
        return 2.5;
    }
    
    public double diemXetTuyen() {
        return this.diemToan * 2 + this.diemLy + this.diemHoa + diemUuTien();
    }

    public String chuanHoa(String s ) {
        String [] arr = s.trim().split("\\s+");
        String res = "";
        for(int i = 0; i < arr.length; i++){
            res += Character.toUpperCase(arr[i].charAt(0));
            for(int j = 1; j < arr[i].length(); j++){
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        return res.trim();
    }

    public String chuyenDoi(double x ) {
        if(x == (int) x) {
            return String.format("%.0f", x);
        }
        return String.format("%.1f", x);
    }

    @Override
    public String toString() {
        return this.maThiSinh + " " + chuanHoa(this.hoTen) + " " + chuyenDoi(diemUuTien()) + " " + chuyenDoi(diemXetTuyen()) ;
    }
}

