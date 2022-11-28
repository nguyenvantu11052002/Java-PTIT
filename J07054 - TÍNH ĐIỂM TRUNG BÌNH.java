TinhDiemTrungBinh/Main.java
package TinhDiemTrungBinh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        ArrayList<SinhVien> list = new ArrayList<>();
        ArrayList<Double> listDiemTB = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String s1 = sc.nextLine();
            int s2 = Integer.parseInt(sc.nextLine());
            int s3 = Integer.parseInt(sc.nextLine());
            int s4 = Integer.parseInt(sc.nextLine());
            SinhVien x = new SinhVien(s1, s2, s3, s4);
            list.add(x);
            listDiemTB.add(x.diemTrungBinhLamTron());
        }
        Collections.sort(list, new SortBy());
        Collections.sort(listDiemTB, Comparator.reverseOrder());
        for(SinhVien x : list){
            System.out.print(x);
            System.out.println(Support.rank(x.diemTrungBinhLamTron(), listDiemTB));
        }
        sc.close();
    }
}

//2
// ha Thi kieu     anh
//7
//6
//7
//Pham    THI  HAO
//6
//7
//6

TinhDiemTrungBinh/SinhVien.java
package TinhDiemTrungBinh;

public class SinhVien {
    private String maSinhVien, hoTen;
    private int diem1, diem2, diem3;

    private static int index = 1;

    public SinhVien( String hoTen, int diem1, int diem2, int diem3) {
        this.maSinhVien = "SV" + String.format("%02d", index ++);
        this.hoTen = Support.chuanHoa(hoTen);
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public String getMaSinhVien() {
        return this.maSinhVien;
    }
    
    public double diemTB(){
        double res = (double) (this.diem1 * 3 + this.diem2 * 3 + this.diem3 * 2) / 8;
        return res;
    }
    
    public double diemTrungBinhLamTron(){
        double res = (double) (this.diem1 * 3 + this.diem2 * 3 + this.diem3 * 2) / 8;
        return (double) Math.round(res * 100)/100;
    }

    @Override 
    public String toString(){
        return this.maSinhVien + " " + this.hoTen + " " + String.format("%.2f", (double) Math.round(this.diemTB() * 100)/100) + " ";
    }
}



TinhDiemTrungBinh/SortBy.java
package TinhDiemTrungBinh;

import java.util.Comparator;

public class SortBy implements Comparator<SinhVien> {
    @Override
    public int compare(SinhVien o1, SinhVien o2){
        if (o1.diemTB() != o2.diemTB()) {
            if (o1.diemTB() > o2.diemTB()) return -1;
            return 1;
        }
        else {
            if (o1.getMaSinhVien().compareTo(o2.getMaSinhVien()) < 0) return -1;
            return 1;
        }
    }
}

TinhDiemTrungBinh/Support.java
package TinhDiemTrungBinh;

import java.util.ArrayList;

public class Support {
    public static int rank(Double x,ArrayList<Double> listDiemTB ){
        for(int i = 0; i < listDiemTB.size(); i++){
            if(x.equals(listDiemTB.get(i))) return i +1;
        }
        return 0;
    }
    
    public static String chuanHoa(String s){
        String [] arr = s.trim().split("\\s+");
        String res = "";
        for(int i = 0; i < arr.length; i++){
            res += Character.toUpperCase(arr[i].charAt(0));
            for(int j = 1; j < arr[i].length(); j++){
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        
        return res.trim();
    }
}

