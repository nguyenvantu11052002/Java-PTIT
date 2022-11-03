javaptit/DoanhNghiep.java
package javaptit;

import java.util.*;

public class DoanhNghiep {
    private String maDoanhNghiep, tenDoanhNghiep;
    private int soSV;

    public DoanhNghiep(String maDoanhNghiep, String tenDoanhNghiep, int soSV) {
        this.maDoanhNghiep = maDoanhNghiep;
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.soSV = soSV;
    }
    
    public int getSoSV() {
        return this.soSV;
    }
    
    public String getMaDoanhNghiep() {
        return this.maDoanhNghiep;
    }
    
    @Override
    public String toString() {
        return this.maDoanhNghiep + " " + this.tenDoanhNghiep + " " + this.soSV;
    }
}
javaptit/Main.java
package javaptit;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DoanhNghiep> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int s3 = Integer.parseInt(sc.nextLine());
            list.add(new DoanhNghiep(s1, s2, s3));
        }

        //System.out.println(list);
        Collections.sort(list, new SortBy());
        for (DoanhNghiep x : list) {
            System.out.println(x);
        }
        
    } 
}

//4
//VIETTEL
//TAP DOAN VIEN THONG QUAN DOI VIETTEL
//40
//FSOFT
//CONG TY TNHH PHAN MEM FPT - FPT SOFTWARE
//300
//VNPT
//TAP DOAN BUU CHINH VIEN THONG VIET NAM
//200
//SUN
//SUN*
//50
javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<DoanhNghiep> {
    
    @Override
    public int compare(DoanhNghiep o1, DoanhNghiep o2) {
        if (o1.getSoSV() == o2.getSoSV()) {
            if (o1.getMaDoanhNghiep().compareTo(o2.getMaDoanhNghiep()) < 0) return -1;
            return 1;
        } else {
            if (o1.getSoSV() > o2.getSoSV()) return -1;
            return 1;
        }
    }
}

