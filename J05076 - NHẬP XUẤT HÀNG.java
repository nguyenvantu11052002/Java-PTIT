JavaPTIT/Main.java

package JavaPTIT;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, MatHang> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine();
            MatHang x = new MatHang(s1, s2, s3);
            map.put(s1, x);
        }
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<ThongKe> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            ThongKe x = new ThongKe(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), 
                                            Integer.parseInt(arr[3]));
            list.add(x);
        }
        Table x = new Table(map, list);
        System.out.println(x);
    }
    
}

//2
//A001
//Tu lanh
//A
//P002
//May giat
//B
//2
//A001 500 100 300
//P002 1000 1000 500


JavaPTIT/MatHang.java

package JavaPTIT;

public class MatHang {
    private String maMatHang, tenMatHang, xepLoai;

    public MatHang(String maMatHang, String tenMatHang, String xepLoai) {
        this.maMatHang = maMatHang;
        this.tenMatHang = tenMatHang;
        this.xepLoai = xepLoai;
    }
    
    public double kyVongLaiSuat() {
        if (this.xepLoai.equals("A")) return 1.08;
        if (this.xepLoai.equals("B")) return 1.05;
        return 1.02;
    }

    public String inMatHang() {
        return this.maMatHang + " " + this.tenMatHang;
    }
}

JavaPTIT/Table.java

package JavaPTIT;
import java.util.*;

public class Table {
    private HashMap<String, MatHang> map;
    private ArrayList<ThongKe> list;

    public Table(HashMap<String, MatHang> map, ArrayList<ThongKe> list) {
        this.map = map;
        this.list = list;
    }
    
    public String solve() {
        String res = "";
        for (ThongKe x : this.list) {
            MatHang y = map.get(x.getMaHang());
            res += y.inMatHang() + " " + String.valueOf((long) x.getDonGiaNhap() * x.getSoLuongNhap()) + " " + 
                    String.valueOf((long) (x.getDonGiaNhap() * y.kyVongLaiSuat() * x.getSoLuongXuat())) + "\n";
        }
        return res;
    }
    
    @Override
    public String toString() {
        return this.solve();
    }
}

JavaPTIT/ThongKe.java

package JavaPTIT;

public class ThongKe {
    private String maHang;
    private int soLuongNhap, donGiaNhap, soLuongXuat;

    public ThongKe(String maHang, int soLuongNhap, int donGiaNhap, int soLuongXuat) {
        this.maHang = maHang;
        this.soLuongNhap = soLuongNhap;
        this.donGiaNhap = donGiaNhap;
        this.soLuongXuat = soLuongXuat;
    }

    public String getMaHang() {
        return maHang;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public int getDonGiaNhap() {
        return donGiaNhap;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }
   
    
    
}

