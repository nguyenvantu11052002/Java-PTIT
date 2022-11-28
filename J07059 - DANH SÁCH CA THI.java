DanhSachCaThi/CaThi.java
package DanhSachCaThi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaThi {
    private String maCaThi;
    private Date ngayThi, gioThi;
    private String phongThi;

    private static int index = 1;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat sd = new SimpleDateFormat("HH:mm");

    public CaThi( String ngayThi, String gioThi, String phongThi) throws ParseException {
        this.maCaThi = "C" + String.format("%03d", index ++);
        this.ngayThi = sdf.parse(ngayThi);
        this.gioThi = sd.parse(gioThi);
        this.phongThi = phongThi;
    }

    public String getMaCaThi(){
        return this.maCaThi;
    }

    public Date getNgayThi(){
        return this.ngayThi;
    }

    public Date getGioThi(){
        return this.gioThi;
    }
    
    @Override
    public String toString(){
        return this.maCaThi + " " + sdf.format(ngayThi) + " " + sd.format(gioThi) + " " + this.phongThi;
    }
}

DanhSachCaThi/Main.java
package DanhSachCaThi;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        ArrayList<CaThi> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while(n -- > 0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            list.add(new CaThi(s1, s2, s3));
        }
        Collections.sort(list, new SortBy());
        for(CaThi x : list){
            System.out.println(x);
        }
        sc.close();
    }
}


DanhSachCaThi/SortBy.java
package DanhSachCaThi;

import java.util.Comparator;

public class SortBy implements Comparator<CaThi>{
    @Override
    public int compare(CaThi o1, CaThi o2){ 
        if (!o1.getNgayThi().equals(o2.getNgayThi())) {
            if (o1.getNgayThi().getTime() < o2.getNgayThi().getTime()) return -1;
            return 1;
        }
        else {
            if (!o1.getGioThi().equals(o2.getGioThi())) {
                if (o1.getGioThi().getTime() < o2.getGioThi().getTime()) return -1;
                return 1;
            }
            else {
                if (o1.getMaCaThi().compareTo(o2.getMaCaThi()) < 0) return -1;
                return 1;
            }
        }
    }
}

