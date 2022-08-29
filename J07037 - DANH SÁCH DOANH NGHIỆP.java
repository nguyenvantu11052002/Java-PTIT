package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DoanhNghiep {
    private String maDoanhNghiep, tenDoanhNghiep;
    private int soSinhVien;

    public DoanhNghiep(String maDoanhNghiep, String tenDoanhNghiep, int soSinhVien) {
        this.maDoanhNghiep = maDoanhNghiep;
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.soSinhVien = soSinhVien;
    }
    
    public String getMa () {
        return this.maDoanhNghiep;
    }
    
    @Override
    public String toString () {
        return this.maDoanhNghiep + " " + this.tenDoanhNghiep + " " + this.soSinhVien; 
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<DoanhNghiep> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int sosv = Integer.parseInt(sc.nextLine());
            DoanhNghiep x = new DoanhNghiep(ma, ten, sosv);
            list.add(x);
        }
        Collections.sort(list, new Comparator<DoanhNghiep>() {
            @Override
            public int compare (DoanhNghiep a, DoanhNghiep b) {
                if (a.getMa().compareTo(b.getMa()) < 0) return -1;
                return 1;
            }
        });
        for (DoanhNghiep x : list) {
            System.out.println(x);
        }
    }
}
