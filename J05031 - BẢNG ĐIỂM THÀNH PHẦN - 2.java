javaptit/Main.java
package javaptit;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            double s4 = Double.parseDouble(sc.nextLine());
            double s5 = Double.parseDouble(sc.nextLine());
            double s6 = Double.parseDouble(sc.nextLine());
            list.add(new SinhVien(s1, s2, s3, s4, s5, s6));
        }
        
        Collections.sort(list, new SortBy());
        int cnt = 1;
        for (SinhVien x : list) {
            System.out.print(cnt + " ");
            cnt++;
            System.out.println(x);
        }
        
    } 
}


//3
//B20DCCN999
//Nguyen Van Nam
//D20CQCN04-B
//10.0
//9.0
//8.0
//B20DCAT001
//Le Van An
//D20CQAT02-B
//6.0
//6.0
//4.0
//B20DCCN111
//Nguyen Van Binh
//D20CQCN01-B
//9.0
//5.0
//6.0

javaptit/SinhVien.java
package javaptit;

import java.util.*;

public class SinhVien {
    private String maSinhVien, tenSinhVien, lop;
    private double diemMon1, diemMon2, diemMon3;

    public static int index = 1;
    
    public SinhVien(String maSinhVien, String tenSinhVien, String lop, double diemMon1, double diemMon2, double diemMon3) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.lop = lop;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
        this.diemMon3 = diemMon3;
    }

    public String getTenSinhVien() {
        return this.tenSinhVien;
    }
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.tenSinhVien + " " + this.lop +
                " " + String.format("%.1f %.1f %.1f", this.diemMon1, this.diemMon2, this.diemMon3);
    }
}
javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<SinhVien> {
    
    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        if (o1.getTenSinhVien().compareTo(o2.getTenSinhVien()) < 0) return -1;
        return 1;
    }
}

