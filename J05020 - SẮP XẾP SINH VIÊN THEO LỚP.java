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
        List<SinhVien> list = new ArrayList<>();
        while (t --> 0) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine(), s4 = sc.nextLine();
            list.add(new SinhVien(s1, s2, s3, s4));
        }
        Collections.sort(list);
        for (SinhVien x : list) {
            System.out.println(x);
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
//D15CQKT03-B
//sv4@stu.ptit.edu.vn
javaptit/SinhVien.java

package javaptit;

public class SinhVien implements Comparable<SinhVien> {
    private String maSinhVien, hoTen, lop, email;

    public SinhVien(String maSinhVien, String hoTen, String lop, String email) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
    }
    
    
    @Override
    public int compareTo(SinhVien other) {
        if (this.lop.equals(other.lop)) {
            if (this.maSinhVien.compareTo(other.maSinhVien) < 0) return -1;
            return 1;
        }
        else {
            if (this.lop.compareTo(other.lop) < 0) return -1;
            return 1;
        }
    } 
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.lop + " " + this.email;
    }
}

