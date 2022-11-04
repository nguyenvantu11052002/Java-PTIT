Main.java
package javaptit;

import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<HocSinh> list = new ArrayList<>();
        
        ArrayList<Double> listDiemTB = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            double s2 = Double.parseDouble(sc.nextLine());
            listDiemTB.add(s2);
            
            list.add(new HocSinh(s1, s2));
        }
        Collections.sort(listDiemTB, Comparator.reverseOrder());
        
        int cnt = 1;
        for (HocSinh x : list) {
            System.out.print(x + " ");
            System.out.println(Support.chiSo(x.getDiemTrungBinh(), listDiemTB));
            
        }
    }
}

//7
//Tran Minh Hieu
//5.9
//Nguyen Bao Trung
//8.6
//Le Hong Ha
//9.2
//Nguyen van Tu
//8.6
//le cao Hoang
//8.6
//nga afdsh asdfh
//5.9
//fasd asdf hafsd
//4.0


HocSinh.java
package javaptit;

import java.util.*;
 
public class HocSinh {
 
    private String maHocSinh, hoTen;
    private double diemTrungBinh; 
    
    private static int index = 1;
    
    public HocSinh(String hoTen, double diemTrungBinh) {
        this.maHocSinh = "HS" + String.format("%02d", index++);
        this.hoTen = hoTen;
        this.diemTrungBinh = diemTrungBinh;
    }
    
    public double getDiemTrungBinh() {
        return this.diemTrungBinh;
    }
    
    public String xepLoai() {
        if (this.diemTrungBinh >= 9) return "Gioi";
        if (this.diemTrungBinh >= 7) return "Kha";
        if (this.diemTrungBinh >= 5) return "Trung Binh";
        return "Yeu";
    } 
    
    @Override
    public String toString() {
        return this.maHocSinh + " " + this.hoTen + " " + this.diemTrungBinh + " " + this.xepLoai();
    }
}
Support.java

package javaptit;
import java.util.*;

public class Support {
    public static int chiSo(Double x, ArrayList<Double> list) {
        for (int i = 0; i < list.size(); i++) {
            if (x.equals(list.get(i))) return i + 1;
        }
        return 0;
    }
}

