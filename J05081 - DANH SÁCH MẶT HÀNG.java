
package javaptit;

import java.util.*;

public class MatHang {
    private String maMatHang, tenMatHang, donViTinh;
    private int giaMua, giaBan;
    private static int id = 1;
    public MatHang(String maMatHang, String tenMatHang, String donViTinh, int giaMua, int giaBan) {
        id++;
        this.maMatHang = maMatHang;
        this.tenMatHang = tenMatHang;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
    
    public int getLoiNhuan () {
        return this.giaBan - this.giaMua;
    }
    
    @Override
    public String toString () {
        return this.maMatHang + " " + this.tenMatHang + " " + this.donViTinh + " " 
                + this.giaMua + " " + this.giaBan + " " + this.getLoiNhuan();
    }
    
    public static String taoMaMatHang () {
        String tmp = Integer.toString(id);
        while (tmp.length() < 3) {
            tmp = "0" + tmp;
        }
        String res = "MH" + tmp;
        return res;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            int n = Integer.parseInt(sc.nextLine());
            //System.out.println("n " + n);
            ArrayList<MatHang> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String tenMatHang = sc.nextLine(), donViTinh = sc.nextLine();
                int giaMua = Integer.parseInt(sc.nextLine());
                int giaBan = Integer.parseInt(sc.nextLine());
                String maMatHang = taoMaMatHang();
                MatHang x = new MatHang(maMatHang, tenMatHang, donViTinh, giaMua, giaBan);
                arr.add(x);
            }
            Collections.sort(arr, new Comparator<MatHang> () {
                @Override
                public int compare (MatHang a, MatHang b) {
                    if (a.getLoiNhuan() == b.getLoiNhuan()) {
                        if (a.maMatHang.compareTo(b.maMatHang) < 0) return -1;
                        else return 1;
                    }
                    else {
                        if (a.getLoiNhuan() > b.getLoiNhuan()) return -1;
                        else return 1;
                    }
                }
            });
            for (MatHang x : arr) {
                System.out.println(x);
            }
        }
    }
}

//2
//Ao phong tre em
//Cai
//25000
//41000
//Ao khoac nam
//Cai
//240000
//515000
