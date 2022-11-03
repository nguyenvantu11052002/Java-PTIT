javaptit/Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            String s5 = sc.nextLine();
            list.add(new SinhVien(s1, s2, s3, s4, s5));
        }
        
        Collections.sort(list, new SortBy());
        
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            for (SinhVien x : list) {
                if (x.getDoanhNghiep().equals(s)) {
                    System.out.println(x);
                }
            }
        }
        
    } 
}


//6
//B17DCCN016 
//Le Khac Tuan Anh 
//D17HTTT2   
//test1@stu.ptit.edu.vn
//VIETTEL
//B17DCCN107 
//Dao Thanh Dat    
//D17CNPM5   
//test2@stu.ptit.edu.vn
//FPT
//B17DCAT092 
//Cao Danh Huy     
//D17CQAT04-B
//test3@stu.ptit.edu.vn
//FPT
//B17DCCN388 
//Cao Sy Hai Long  
//D17CNPM2   
//test4@stu.ptit.edu.vn
//VNPT
//B17DCCN461 
//Dinh Quang Nghia 
//D17CNPM2   
//test5@stu.ptit.edu.vn
//FPT
//B17DCCN554 
//Bui Xuan Thai    
//D17CNPM1    
//test6@stu.ptit.edu.vn
//GAMELOFT
//1
//FPT



javaptit/SinhVien.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SinhVien {
    private int soThuTu;
    private String maSinhVien, hoTen, lop, email, DoanhNghiep;

    public static int index = 1;
    
    public SinhVien(String maSinhVien, String hoTen, String lop, String email, String DoanhNghiep) {
        this.soThuTu = index++;
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
        this.DoanhNghiep = DoanhNghiep;
    }
    
    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    public String getDoanhNghiep() {
        return this.DoanhNghiep;
    }
    
    @Override
    public String toString() {
        return this.soThuTu + " " + this.maSinhVien + " " + this.hoTen + " " + 
                this.lop + " " + this.email + " " + this.DoanhNghiep;
    }
    
}
javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<SinhVien> {
    
    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        if (o1.getMaSinhVien().compareTo(o2.getMaSinhVien()) < 0) return -1;
        return 1;
    }
}

