LopHocPhan2/LopHocPhan.java
package LopHocPhan2;

public class LopHocPhan {
    private String maMonHoc, tenLop, nhom, tenGiangVien;

    public LopHocPhan(String maMonHoc, String tenLop, String nhom, String tenGiangVien) {
        this.maMonHoc = maMonHoc;
        this.tenLop = tenLop;
        this.nhom = nhom;
        this.tenGiangVien = tenGiangVien;
    }

    public String getNhom() {
        return this.nhom;
    }
    public String getMaMonHoc() {
        return this.maMonHoc;
    }

    public String getTenGiangVien() {
        return this.tenGiangVien;
    }
    @Override
    public String toString() {
        return this.maMonHoc + " " + this.tenLop + " " + this.nhom;
    }
}

LopHocPhan2/Main.java
package LopHocPhan2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<LopHocPhan> list = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        while(n --> 0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            list.add(new LopHocPhan(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortBy());
        int q = Integer.parseInt(sc.nextLine());
        while(q --> 0){
            String ten = sc.nextLine();
            boolean check = false;
            for(LopHocPhan x : list){
                if(x.getTenGiangVien().equals(ten)){
                    if(!check){
                        check = true;
                        System.out.println("Danh sach cho giang vien " + x.getTenGiangVien() + ":");
                    }
                    System.out.println(x);
                }
            }
        }
        sc.close();
    }
}


//4
//THCS2D20
//Tin hoc co so 2 - D20
//01
//Nguyen Binh An
//CPPD20
//Ngon ngu lap trinh C++ - D20
//01
//Le Van Cong
//THCS2D20
//Tin hoc co so 2 - D20
//02
//Nguyen Trung Binh
//LTHDTD19
//Lap trinh huong doi tuong - D19
//01
//Nguyen Binh An
//1
//Nguyen Binh An
LopHocPhan2/SortBy.java
package LopHocPhan2;

import java.util.Comparator;

public class SortBy implements Comparator<LopHocPhan> {
    @Override
    public int compare(LopHocPhan o1, LopHocPhan o2) {
        if(o1.getMaMonHoc().equals(o2.getMaMonHoc())) {
            if(o1.getNhom().compareTo(o2.getNhom()) < 0) return -1;
            return 1;
        }
        else {
            if(o1.getMaMonHoc().compareTo(o2.getMaMonHoc()) < 0) return -1;
            return 1;
        }
    }
    

}

