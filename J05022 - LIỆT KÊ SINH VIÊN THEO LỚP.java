javaptit/DATA.txt

javaptit/Main.java
package javaptit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        Map<String, List<SinhVien> > map = new LinkedHashMap<>();
        
        while (t --> 0) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine(), s4 = sc.nextLine();
            if (map.containsKey(s3)) {
                map.get(s3).add(new SinhVien(s1, s2, s3, s4));
            }
            else {
                List<SinhVien> list = new ArrayList<>();
                list.add(new SinhVien(s1, s2, s3, s4));
                map.put(s3, list);
            }
        }
        int q = Integer.parseInt(sc.nextLine());
        while (q --> 0) {
            String tmp = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + tmp + ":");
            Set<String> set = map.keySet();
            for (String x : set) {
                if (tmp.equals(x)) {
                    for (SinhVien y : map.get(x)) {
                        System.out.println(y);
                    }
                    break;
                }
            }
        }
    }
}

//4
//B16DCCN011
//Nguyen Trong Duc Anh
//D16CNPM1
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
//1
//D15CQKT02-B
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
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.lop + " " + this.email;
    }
}

