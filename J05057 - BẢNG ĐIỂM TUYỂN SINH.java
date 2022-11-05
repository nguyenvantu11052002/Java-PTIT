Main.java
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
        
        for(ThiSinh x : list){
            System.out.println(x);
        }
    }
 
}


//3
//Luu Thuy Nhi
//9.3  9.0  7.1  6.5  6.2  6.0  8.2  6.7  4.8  5.5
//Le Van Tam
//8.0  8.0  5.5  9.0  6.8  9.0  7.2  8.3  7.2  6.8
//Nguyen Thai Binh
//9.0  6.4  6.0  7.5  6.7  5.5  5.0  6.0  6.0  6.0
Support.java

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

ThiSinh.java
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
    
    public double diemUuTien() {
        String res = this.maThiSinh.substring(0, 3);
        if (res.equals("KV1")) return 0.5;
        if (res.equals("KV2")) return 1.0;
        return 2.5;
    }
    
    public double tongDiemKhongTinhDiemUuTien() {
        return (double) Math.round((this.diemToan * 2 + this.diemLy + this.diemHoa) * 10) /10;
    }
    
    public String trangThai() {
        double res = this.tongDiemKhongTinhDiemUuTien() + this.diemUuTien();
        if (res >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }

    @Override
    public String toString() {
        return this.maThiSinh + " " + this.hoTen + " " + Support.chuyen(this.diemUuTien()) + 
                " " + Support.chuyen(this.tongDiemKhongTinhDiemUuTien()) + " " + this.trangThai();
    }

}

