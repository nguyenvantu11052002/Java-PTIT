package javaptit;

import java.util.*;

public class MatHang {

    private String maHang, tenHang;
    private int soLuong, donGia;

    public MatHang(String maHang, String tenHang, int soLuong, int donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int tienChietKhau() {
        int res = this.donGia * this.soLuong;
        if (this.soLuong > 10) {
            return res / 20;
        }
        if (this.soLuong >= 8 && this.soLuong <= 10) {
            return res / 50;
        }
        if (this.soLuong >= 5 && this.soLuong < 8) {
            return res / 100;
        }
        return 0;
    }

    public int thanhTien() {
        return this.donGia * this.soLuong - this.tienChietKhau();
    }
    public static String getMaHang (String s) {
        String[] arr = s.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < 2; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
        }
        return res;
    }
    
    @Override
    public String toString() {
        return this.maHang + " " + this.tenHang + " " + this.tienChietKhau() + " " + this.thanhTien();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            Map<String, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                String tenHang = sc.nextLine();
                int soLuong = Integer.parseInt(sc.nextLine());
                int donGia = Integer.parseInt(sc.nextLine());
                String tmp = getMaHang(tenHang);
                if (map.containsKey(tmp)) {
                    int tanSuat = map.get(tmp);
                    tanSuat++;
                    map.put(tmp, tanSuat);
                    tmp = tmp + String.format("%02d", tanSuat);
                }
                else {
                    map.put(tmp, 1);
                    tmp = tmp + "01";
                }
                MatHang x = new MatHang(tmp, tenHang, soLuong, donGia);
                System.out.println(x);
            }
        }
    }
}
