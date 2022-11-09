Main.java
package javaptit;

import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
        }
        int m = Integer.parseInt(sc.nextLine());
        HashMap<String, GiangVien> mapGV = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] arr = s.trim().split("\\s+");
            String s2 = "";
            for (int j = 1; j < arr.length; j++) {
                s2 += arr[j] + " ";
            }
            GiangVien x = new GiangVien(arr[0], s2.trim());
            mapGV.put(arr[0], x);
        }
        
        int p = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, Double> mapHP = new LinkedHashMap<>();
        
        for (int i = 0; i < p; i++) {
            String[] arr = sc.nextLine().trim().split("\\s+");
            if (mapHP.containsKey(arr[0])) {
                mapHP.put(arr[0], mapHP.get(arr[0]) + Double.parseDouble(arr[2]));
            }
            else {
                mapHP.put(arr[0], Double.parseDouble(arr[2]));
            }
        }
        for (Map.Entry<String, Double> x : mapHP.entrySet()) {
            GiangVien s1 = mapGV.get(x.getKey());
            double s2 = x.getValue();
            HocPhan hp = new HocPhan(s1, s2);
            System.out.println(hp);
        }
    }
}




//2
//INT1155 Tin hoc co so 2
//INT1306 Cau truc du lieu va giai thuat
//3
//GV01 Nguyen Van An
//GV02 Hoang Binh Minh
//GV03 Nguyen Nguyen Van Tu Tu
//3
//GV01 INT1155 113.2
//GV02 INT1306 126.72
//GV01 INT1306 150.2

GiangVien.java
package javaptit;

import java.util.*;

public class GiangVien {
    private String maGiangVien, tenGiangVien;

    public GiangVien(String maGiangVien, String tenGiangVien) {
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
    }
  
    public String getTenGiangVien() {
        return this.tenGiangVien;
    }
    
    @Override
    public String toString() {
        return this.tenGiangVien;
    }
    
}

HocPhan.java
package javaptit;

import java.util.*;

public class HocPhan {
    private GiangVien giangVien;
    private double gioChuan;

    public HocPhan(GiangVien giangVien, double gioChuan) {
        this.giangVien = giangVien;
        this.gioChuan = gioChuan;
    }
 
    @Override
    public String toString() {
        return this.giangVien + " " + String.format("%.2f", this.gioChuan);
    }
    
}

