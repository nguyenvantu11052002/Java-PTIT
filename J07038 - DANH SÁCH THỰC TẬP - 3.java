ThiCuoiKy/DoanhNghiep.java
package ThiCuoiKy;

public class DoanhNghiep {
    private String maDoanhNghiep, tenDoanhNghiep;
    private int soSinhVienCoTheNhan;

    public DoanhNghiep(String maDoanhNghiep, String tenDoanhNghiep, int soSinhVienCoTheNhan) {
        this.maDoanhNghiep = maDoanhNghiep;
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.soSinhVienCoTheNhan = soSinhVienCoTheNhan;
    }

    public String getTenDoanhNghiep() {
        return this.tenDoanhNghiep;
    }

    public int getSoSinhVienCoTheNhan() {
        return soSinhVienCoTheNhan;
    }
  
}

ThiCuoiKy/Main.java
package ThiCuoiKy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, SinhVien> mapSV = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine(), s4 = sc.nextLine();            
            SinhVien x = new SinhVien(s1, s2, s3, s4);
            mapSV.put(s1, x);
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////     
        sc = new Scanner(new File("DN.in"));
        HashMap<String, DoanhNghiep> mapDN = new HashMap<>();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            sc.nextLine();
            String s1 = sc.nextLine(), s2 = sc.nextLine();
            int s3 = sc.nextInt();
            DoanhNghiep x = new DoanhNghiep(s1, s2, s3);
            mapDN.put(s1, x);
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////
        sc = new Scanner(new File("THUCTAP.in"));
        HashMap<String, ArrayList<ThucTap> > mapTT = new HashMap<>();
        int p = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < p; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            ThucTap x = new ThucTap(arr[0], arr[1]);
            ArrayList<ThucTap> list = new ArrayList<>();
            list.add(x);
            if (mapTT.containsKey(arr[1])) {
                mapTT.get(arr[1]).add(x);
            }
            else {
                mapTT.put(arr[1], list);
            }
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            String ten = mapDN.get(s).getTenDoanhNghiep();
            System.out.println("DANH SACH THUC TAP TAI " + ten + ":"); 
            ArrayList<ThucTap> list = mapTT.get(s);
            ArrayList<String> listMSV = new ArrayList<>();
            for (ThucTap x : list) {
                listMSV.add(x.getMaSinhVien());
            }
            Collections.sort(listMSV);
            int soSinhVienCoTheNhan = mapDN.get(s).getSoSinhVienCoTheNhan();
///////////////////////////////////////////////////////////////////////////////////////////////
            if (listMSV.size() > soSinhVienCoTheNhan) {
                for (int j = 0; j < soSinhVienCoTheNhan; j++) {
                    SinhVien sv = mapSV.get(listMSV.get(j));
                    System.out.println(sv);
                }
            }
            else {
                for (String x : listMSV) {
                    SinhVien sv = mapSV.get(x);
                    System.out.println(sv);
                }
            }
        }
    }

}


ThiCuoiKy/SinhVien.java
package ThiCuoiKy;

public class SinhVien {
    private String maSinhVien, tenSinhVien, lop, email;

    public SinhVien(String maSinhVien, String tenSinhVien, String lop, String email) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = Support.chuanHoa(tenSinhVien);
        this.lop = lop;
        this.email = email;
    }

    public String toString() {
        return this.maSinhVien + " " + this.tenSinhVien + " " + this.lop;
    }
    
}

ThiCuoiKy/Support.java
package ThiCuoiKy;

public class Support {
    public static String chuanHoa(String s) {
        String res = "";
        String[] arr = s.trim().split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            res += Character.toUpperCase(arr[i].charAt(0));
            for (int j = 1; j < arr[i].length(); j++) {
                res += Character.toLowerCase(arr[i].charAt(j));
            }
            res += " ";
        }
        return res.trim();
    }
}

ThiCuoiKy/ThucTap.java
package ThiCuoiKy;

public class ThucTap {
    private String maSinhVien, maDoanhNghiep;

    public ThucTap(String maSinhVien, String maDoanhNghiep) {
        this.maSinhVien = maSinhVien;
        this.maDoanhNghiep = maDoanhNghiep;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getMaDoanhNghiep() {
        return maDoanhNghiep;
    }

    
}

