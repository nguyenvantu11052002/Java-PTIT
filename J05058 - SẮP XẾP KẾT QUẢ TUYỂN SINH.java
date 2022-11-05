javaptit/Main.java
package javaptit;

import java.util.Collection;
import java.util.Scanner;
import java.util.*;
 
public class Main {
    public static void main(String [] agrs){
        Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinh> list = new ArrayList<>();
 
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            double s3 = Double.parseDouble(sc.nextLine());
            double s4 = Double.parseDouble(sc.nextLine());
            double s5 = Double.parseDouble(sc.nextLine());
            list.add(new ThiSinh(s1, s2, s3, s4, s5));
        }
        Collections.sort(list, new SortBy());
        for(ThiSinh x : list){
            System.out.println(x);
        }
    }
 
}


//2
//KV2A002
//Hoang Thanh Tuan
//5
//6
//5
//KV2B123
//Ly Thi Thu Ha
//8
//6.5
//7
javaptit/SortBy.java
package javaptit;

import java.util.*;

public class SortBy implements Comparator<ThiSinh> {
    @Override
    public int  compare(ThiSinh o1, ThiSinh o2){
        if (o1.diemXetTuyen() == o2.diemXetTuyen()) {
            if (o1.getMaThiSinh().compareTo(o2.getMaThiSinh()) < 0) return -1;
            return 1;
        }
        else {
            if (o1.diemXetTuyen() > o2.diemXetTuyen()) return -1;
            return 1;
        }
        
    }
}

javaptit/Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static String chuyen(double x) {
        if (x == (int) (x)) {
            return String.format("%.0f", x);
        }
        return String.format("%.1f", x);
    }
}

javaptit/ThiSinh.java
package javaptit;

import java.util.*;

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
    
    public double tongDiemKhongTinhDiemUuTien() {
        return (double) Math.round((this.diemToan * 2 + this.diemLy + this.diemHoa) * 10) /10;
    }
    
    public double diemXetTuyen() {
        return this.tongDiemKhongTinhDiemUuTien() + this.diemUuTien();
    }
    
    public String trangThai() {
        double res = this.tongDiemKhongTinhDiemUuTien() + this.diemUuTien();
        if (res >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }

    @Override
    public String toString() {
        return this.maThiSinh + " " + this.hoTen + " " + Support.chuyen(this.diemUuTien()) + 
                " " + Support.chuyen(this.diemXetTuyen()) + " " + this.trangThai();
    }

}

