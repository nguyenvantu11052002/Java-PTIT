javaptit/Main.java
package javaptit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int t = 1;
        t = Integer.parseInt(sc.nextLine());
        List<SinhVien> list = new ArrayList<>();

        while (t-->0) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine(), s4 = sc.nextLine();
            list.add(new SinhVien(s1, s2, s3, s4));
        }
        Collections.sort(list);
        for (SinhVien x : list) {
            System.out.println(x);
        }
    }
}




javaptit/SinhVien.java

package javaptit;

public class SinhVien implements Comparable<SinhVien>{
    private String maSinhVien, hoTen, sdt, email;

    public SinhVien(String maSinhVien, String hoTen, String lop, String email) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.sdt = lop;
        this.email = email;
    }
    
    public String getTen() {
        String[] arr = this.hoTen.split("\\s+");
        return arr[arr.length - 1];
    }
    
    public String getHoVaTenDem() {
        String[] arr = this.hoTen.split("\\s+");
        String res = "";
        for (int i = 0; i < arr.length - 1; i++) {
            res += arr[i];
        }
        return res;
    }
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.sdt + " " + this.email;
    }

    @Override
    public int compareTo(SinhVien other) {
        if (this.hoTen.equals(other.hoTen)) {
            if (this.maSinhVien.compareTo(other.maSinhVien) < 0) return -1;
            return 1;
        }
        else {
            if (this.getTen().equals(other.getTen())) {
                if (this.getHoVaTenDem().compareTo(other.getHoVaTenDem()) < 0) return -1;
                return 1;
            }
            else {
                if (this.getTen().compareTo(other.getTen()) < 0) return -1;
                return 1;
            }
        }
    }
}

