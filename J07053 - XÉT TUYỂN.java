KetQuaXetTuyen/Main.java
package KetQuaXetTuyen;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("XETTUYEN.in"));
        ArrayList<ThiSinh> list = new ArrayList<>();
 
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n ; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            double s3 = Double.parseDouble(sc.nextLine());
            double s4 = Double.parseDouble(sc.nextLine());
            list.add(new ThiSinh(s1, s2, s3, s4));
        }
        // Collections.sort(list, new SortBy());
        for(ThiSinh x : list){
            System.out.println(x);
        }
        sc.close();
    }
}
KetQuaXetTuyen/SortBy.java
package KetQuaXetTuyen;

import java.util.Comparator;

public class SortBy implements Comparator<ThiSinh> {
    @Override
    public int compare(ThiSinh o1, ThiSinh o2){
        if(o1.diemTB() == o2.diemTB()){
            if(o1.getMaThiSinh().compareTo(o2.getMaThiSinh()) < 0) return -1;
            return 1;
        }
        if(o1.diemTB() > o2.diemTB()) return -1;
        return 1;
    }
    
}

KetQuaXetTuyen/ThiSinh.java
package KetQuaXetTuyen;
 
public class ThiSinh{
    private String maThiSinh, hoTen, ngaySinh;
    private double diemLyThuyet, diemThucHanh;
 
    private  static int index = 1;
 
    public ThiSinh( String hoTen, String ngaySinh, double diemLyThuyet, double diemThucHanh) {
        this.maThiSinh = "PH" + String.format("%02d", index ++);
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diemLyThuyet = diemLyThuyet;
        this.diemThucHanh = diemThucHanh;
    }
 
    public String getMaThiSinh(){
        return this.maThiSinh;
    }
 
    public String chuanHoa(){
        String [] arr = this.hoTen.trim().split("\\s+");
        String res = "";
        for(int i = 0; i < arr.length; i++){
            res += Character.toUpperCase(arr[i].charAt(0));
            for(int j = 1; j < arr[i].length(); j++ ){
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        res.trim();
        return res;
    }
 
    public long tuoi(){
        String [] arr = this.ngaySinh.trim().split("/");
        return 2021 - Integer.parseInt(arr[2]);
    }
 
    public double diemThuong(){
        if(this.diemLyThuyet >=8 && this.diemThucHanh >=8) return 1.0;
        if(this.diemLyThuyet >= 7.5 && this.diemThucHanh >=7.5) return 0.5;
        return 0.0;
    }
 
    public long diemTB(){
        double res = (this.diemLyThuyet + this.diemThucHanh) / 2 + diemThuong();
        if(res > 10) return 10;
        return  Math.round(res);
    }
 
    public String xepLoai(){
        if(diemTB() == 9 || diemTB() == 10) return "Xuat sac";
        if(diemTB() <= 6 && diemTB() >= 5) return "Trung binh";
        if(diemTB() == 7) return "Kha";
        if(diemTB() == 8 ) return "Gioi";
        return "Truot";
    }
 
    @Override 
    public String toString(){
        return this.maThiSinh + " " + chuanHoa() + " " + tuoi() + " " + 
            diemTB() +  " " + xepLoai();
    }
}
