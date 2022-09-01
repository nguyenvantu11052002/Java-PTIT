package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MonThi implements Comparable<MonThi> {
    private String maMonHoc, tenMonHoc, hinhThucThi;

    public MonThi(String maMonHoc, String tenMonHoc, String hinhThucThi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.hinhThucThi = hinhThucThi;
    }
    
    public String getMaMon () {
        return this.maMonHoc;
    }
    
    @Override
    public int compareTo (MonThi other) {
        if (this.getMaMon().compareTo(other.getMaMon()) < 0) return -1;
        return 1;
    } 
    
    @Override
    public String toString () {
        return this.maMonHoc + " " + this.tenMonHoc + " " + this.hinhThucThi;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = Integer.parseInt(sc.nextLine());
        List<MonThi> list = new ArrayList<>();
        while(t-- >0){
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine();
            MonThi x = new MonThi (s1, s2, s3);
            list.add(x);
        }
        Collections.sort(list);
        for (MonThi x : list) {
            System.out.println(x);
        }
    }
}

//2
//MUL1320
//Nhap mon da phuong tien
//Bai tap lon + Van dap truc tuyen
//BAS1203
//Giai tich 1
//Thi viet + Van dap truc tuyen
