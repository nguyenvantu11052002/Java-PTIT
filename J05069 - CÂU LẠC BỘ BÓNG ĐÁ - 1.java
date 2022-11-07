Main.java
package javaptit;

import java.util.*;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, CLB> map = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int s3 = Integer.parseInt(sc.nextLine());
            map.put(s1, new CLB(s1, s2, s3));
        }    
        ArrayList<TranDau> list = new ArrayList<>();     
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] arr = s.trim().split("\\s+");
            String s1 = arr[0];
            int s2 = Integer.parseInt(arr[1]);
            list.add(new TranDau(s1, s2));
        }
        Support.solve(map, list);
    }
}
 
//2
//AC
//AC Milan
//12
//MU
//Manchester United
//10
//2
//IAC1 80000
//EMU2 60000
CLB.java
package javaptit;

import java.util.*;

 
public class CLB {
    private String maCLB, tenCLB;
    private int giaVe;

    public CLB(String maCLB, String tenCLB, int giaVe) {
        this.maCLB = maCLB;
        this.tenCLB = tenCLB;
        this.giaVe = giaVe;
    }
    
    public String getTenCLB() {
        return this.tenCLB;
    }
    
    public int getGiaVe() {
        return this.giaVe;
    }
    
}

InRa.java

package javaptit;

public class InRa {
    private String maTran, tenDoi;
    private long doanhThu;

    public InRa(String maTran, String tenDoi, long doanhThu) {
        this.maTran = maTran;
        this.tenDoi = tenDoi;
        this.doanhThu = doanhThu;
    }
    
    @Override
    public String toString() {
        return this.maTran + " " + this.tenDoi + " " + this.doanhThu;
    }
}

TranDau.java

package javaptit;
import java.util.*;

public class TranDau {
    private String maTranDau;
    private int soCoDongVien;

    public TranDau(String maTranDau, int soCoDongVien) {
        this.maTranDau = maTranDau;
        this.soCoDongVien = soCoDongVien;
    }
    
    public String getMaTranDau() {
        return this.maTranDau;
    }
    
    public int getSoCoDongVien() {
        return this.soCoDongVien;
    }
}

Support.java

package javaptit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Support {
    public static void solve(HashMap<String, CLB> map, ArrayList<TranDau> list) {
        ArrayList<InRa> listInRa = new ArrayList<>();
        for (TranDau x : list) {
            String s1 = x.getMaTranDau();
            String s2 = map.get(s1.substring(1, 3)).getTenCLB();
            long s3 = x.getSoCoDongVien() * map.get(s1.substring(1, 3)).getGiaVe();
            listInRa.add(new InRa(s1, s2, s3));
        }
        for (InRa x : listInRa) {
            System.out.println(x);
        }
    }
}
