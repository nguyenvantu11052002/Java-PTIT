package javaptit;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;

public class SinhVien {
    private String maSinhVien, hoTen, lop, email;

    public SinhVien(String maSinhVien, String hoTen, String lop, String email) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
    }
    
    public void chuanHoa () {
        this.hoTen = this.hoTen.trim();
        String[] arr = this.hoTen.split("\\s+");
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
            for (int j = 1; j < arr[i].length(); j++) {
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            if (i != arr.length - 1) res += " ";
        }
        //System.out.println("res ne" + res);
        this.hoTen = res;
    }
    
    public String getMaSinhVien () {
        return this.maSinhVien;
    }
    
    @Override
    public String toString () {
        return this.maSinhVien + " " + this.hoTen + " " + this.lop + " " + this.email;
    }
    
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String maSinhVien = sc.nextLine();
            String hoTen = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            SinhVien x = new SinhVien(maSinhVien, hoTen, lop, email);
            x.chuanHoa();
            list.add(x);
        }
        Collections.sort(list, new Comparator<SinhVien> () {      
            @Override
            public int compare (SinhVien a, SinhVien b) {
                if (a.getMaSinhVien().compareTo(b.getMaSinhVien()) < 0) {
                    return -1;
                }
                else return 1;
            }
        });
        for (SinhVien x : list) {
            System.out.println(x);
        }
        sc.close();
    }
}

