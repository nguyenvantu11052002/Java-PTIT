javaptit/Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> list = new ArrayList<>();
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String s1 = sc.nextLine();
            int s2 = sc.nextInt();
            int s3 = sc.nextInt();
            list.add(new SinhVien(s1, s2, s3));
        }
        Collections.sort(list, new SortBy());
        for (SinhVien x : list) {
            System.out.println(x);
        }
    } 
}

//3
//1 2 3 4
//2 3 4 5
//1 -2 5 -6




javaptit/SinhVien.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SinhVien {
    private String tenSinhVien;
    private int soBaiLamDung, soLuotSubMit;

    public SinhVien(String tenSinhVien, int soBaiLamDung, int soLuotSubMit) {
        this.tenSinhVien = tenSinhVien;
        this.soBaiLamDung = soBaiLamDung;
        this.soLuotSubMit = soLuotSubMit;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public int getSoBaiLamDung() {
        return soBaiLamDung;
    }

    public int getSoLuotSubMit() {
        return soLuotSubMit;
    }
    
    @Override
    public String toString() {
        return this.tenSinhVien + " " + this.soBaiLamDung + " " + this.soLuotSubMit;
    }
}
javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<SinhVien> {
    
    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        if (o1.getSoBaiLamDung() == o2.getSoBaiLamDung()) {
            if (o1.getSoLuotSubMit() == o2.getSoLuotSubMit()) {
                if (o1.getTenSinhVien().compareTo(o2.getTenSinhVien()) < 0) return -1;
                return 1;
            }
            else{
                if (o1.getSoLuotSubMit() < o2.getSoLuotSubMit()) return -1;
                return 1;
            }
        }
        else{
            if (o1.getSoBaiLamDung() > o2.getSoBaiLamDung()) return -1;
            return 1;
        }
    }
}

