javaptit/Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<MatHang> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            int s2 = Integer.parseInt(sc.nextLine());
            int s3 = Integer.parseInt(sc.nextLine());
            String s4 = Support.haiKiTuDauMaHang(s1);
            if (map.containsKey(s4)) {
                map.put(s4, map.get(s4) + 1);
            }
            else {
                map.put(s4, 1);
            }
            s4 += String.format("%02d", map.get(s4));
            //System.out.println("s4    " + s4);
            list.add(new MatHang(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortBy());
        
        for (MatHang x : list) {
            System.out.println(x);
        }
    } 
}

//3
//May lanh SANYO
//12
//4000000
//Dien thoai Samsung
//30
//3230000
//Dien thoai Nokia
//18
//1240000

javaptit/MatHang.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MatHang {
    private String maHang, tenHang;
    private int soLuong, donGia;

    public MatHang(String tenHang, int soLuong, int donGia, String maHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public double phanTramChietKhau() {
        if (this.soLuong > 10) return 0.05;
        if (this.soLuong >= 8) return 0.02;
        if (this.soLuong  >= 5) return 0.01;
        return 0;
    }
    
    public long tienChietKhau() {
        return (long) (this.donGia * this.soLuong * this.phanTramChietKhau());
    }
    
    public long thanhTien() {
        return this.donGia * this.soLuong - this.tienChietKhau();
    }
    
    @Override
    public String toString() {
        return this.maHang + " " + this.tenHang + " " + this.tienChietKhau() + " " + this.thanhTien();
    }
}
javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<MatHang> {
    
    @Override
    public int compare(MatHang o1, MatHang o2) {
        if (o1.tienChietKhau() > o2.tienChietKhau()) return -1;
        return 1;
    }
}

javaptit/Support.java

package javaptit;

public class Support {
    public static String haiKiTuDauMaHang(String s) {
        String[] arr = s.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < 2; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
        }
        return res;
    }
}

