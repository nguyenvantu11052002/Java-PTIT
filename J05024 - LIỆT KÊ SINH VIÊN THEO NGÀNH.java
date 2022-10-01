javaptit/CacHam.java

package javaptit;

public class CacHam {
   
    public static String haiKiTuDau (String s) {
        String[] arr = s.split("\\s+");
        String res = "";
        for (int i = 0; i < 2; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
        }
        return res;
    }
    
    
    
}

javaptit/DATA.txt

javaptit/Main.java
package javaptit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import static javaptit.CacHam.haiKiTuDau;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        Map<String, List<SinhVien>> map = new LinkedHashMap<>();

        while (t-- > 0) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine(), s4 = sc.nextLine();
            SinhVien x = new SinhVien(s1, s2, s3, s4);
            if (map.containsKey(x.getNganh())) {
                map.get(x.getNganh()).add(new SinhVien(s1, s2, s3, s4));
            } else {
                List<SinhVien> list = new ArrayList<>();
                list.add(new SinhVien(s1, s2, s3, s4));
                map.put(x.getNganh(), list);
            }
        }
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            String tmp = sc.nextLine();
            String s = haiKiTuDau(tmp);
            System.out.println("DANH SACH SINH VIEN NGANH " + tmp.toUpperCase() + ":");
            Set<String> set = map.keySet();
            if (s.equals("AT") || s.equals("CN")) {
                for (String x : set) {
                    if (s.equals(x)) {
                        for (SinhVien y : map.get(x)) {
                            if (y.getLop().startsWith("E") == false) {
                                System.out.println(y);
                            }                           
                        }
                        break;
                    }
                }
            }
            else {
                for (String x : set) {
                    if (s.equals(x)) {
                        for (SinhVien y : map.get(x)) {
                            System.out.println(y);
                        }
                        break;
                    }
                }
            }
        }
    }
}

//4
//B16DCCN011
//Nguyen Trong Duc Anh
//E16CNPM1
//sv1@stu.ptit.edu.vn
//B15DCCN215
//To Ngoc Hieu
//D15CNPM3
//sv2@stu.ptit.edu.vn
//B15DCKT150
//Nguyen Ngoc Son
//D15CQKT02-B
//sv3@stu.ptit.edu.vn
//B15DCKT199
//Nguyen Trong Tung
//D15CQKT02-B
//sv4@stu.ptit.edu.vn
//2
//Ke toan
//Cong nghe thong tin


javaptit/SinhVien.java

package javaptit;

public class SinhVien {
    private String maSinhVien, hoTen, lop, email;

    public SinhVien(String maSinhVien, String hoTen, String lop, String email) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
    }
    
    public String getNganh() {
        return this.maSinhVien.substring(5, 7);
    }
    
    public String getLop() {
        return this.lop;
    }
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.lop + " " + this.email;
    }
}

