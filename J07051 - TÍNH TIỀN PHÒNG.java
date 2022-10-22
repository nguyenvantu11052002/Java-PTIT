javaptit/KhachHang.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static javaptit.SupportFunctions.chuanHoa;


public class KhachHang implements Comparable<KhachHang> {
    private String tenKhachHang, soPhong, maKhachHang;
    private Date ngayNhanPhong, ngayTraPhong;
    private long tienDichVuPhatSinh;
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public static int index = 1;
    
    public KhachHang(String tenKhachHang, String soPhong, String ngayNhanPhong, String ngayTraPhong, long tienDichVuPhatSinh) throws ParseException {
        this.maKhachHang = "KH" + String.format("%02d", index++);
        this.tenKhachHang = chuanHoa(tenKhachHang);
        this.soPhong = soPhong;
        this.ngayNhanPhong = sdf.parse(ngayNhanPhong);
        this.ngayTraPhong = sdf.parse(ngayTraPhong);
        this.tienDichVuPhatSinh = tienDichVuPhatSinh;
    }
    
    public String getKiTuDauTien() {
        return this.soPhong.substring(0, 1);
    }
    
    public int giaTheoKiTuDauTien() {
        if (this.getKiTuDauTien().equals("1")) return 25;
        if (this.getKiTuDauTien().equals("2")) return 34;
        if (this.getKiTuDauTien().equals("3")) return 50;
        return 80;
    }
    
    public long getSoNgayO() {
        long res = (this.ngayTraPhong.getTime() - this.ngayNhanPhong.getTime()) / (60 * 60 * 24 * 1000) + 1;
        return res;
    }
    
    public long getThanhTien() {
        long res = this.giaTheoKiTuDauTien() * this.getSoNgayO() + this.tienDichVuPhatSinh;
        return res;
    }
    
    @Override
    public int compareTo(KhachHang other) {
        if (this.getThanhTien() > other.getThanhTien()) return -1;
        return 1;
    }
    
    @Override
    public String toString() {
        return this.maKhachHang + " " + this.tenKhachHang + " " +
                this.soPhong + " " + this.getSoNgayO() + " " + this.getThanhTien();
    }
}
    
    


javaptit/Main.java
package javaptit;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;


public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<KhachHang> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine(), s4 = sc.nextLine();
            long s5 = Long.parseLong(sc.nextLine());
            list.add(new KhachHang(s1, s2, s3, s4, s5));
        }
        Collections.sort(list);
        for (KhachHang x : list) {
            System.out.println(x);
        }
    }

}


javaptit/SupportFunctions.java
package javaptit;
import java.util.*;

public class SupportFunctions {
    
    public static String chuanHoa(String s) {
        String[] arr = s.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
            for (int j = 1; j < arr[i].length(); j++) {
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        return res.trim();
    }
}
