Main.java
package javaptit;
 
import java.text.ParseException;
import java.util.*;
 
public class Main {
    
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedHashMap<String, Pair<Integer, Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            int s4 = sc.nextInt();
            LuongMua tmp = new LuongMua(s1, s2, s3, s4);
            if(map.containsKey(s1)) {
                int thoiGian = map.get(s1).getFirst() + tmp.getPhut();
                int luongMua = map.get(s1).getSecond() + s4;
                Pair<Integer, Integer> x = new Pair<>(thoiGian, luongMua);
                map.put(s1, x);
            }
            else {
                int thoiGian = tmp.getPhut();
                int luongMua = s4;
                Pair<Integer, Integer> x = new Pair<>(thoiGian, luongMua);
                map.put(s1, x);
            } 
        }
        int index = 1;
        for (Map.Entry<String, Pair<Integer, Integer>> x : map.entrySet()) {
            System.out.print(String.format("T%02d ", index++));
            System.out.print(x.getKey() + " ");
            double res = (double) x.getValue().getSecond() / x.getValue().getFirst() * 60;
            double ans = (double)Math.round(res * 100) / 100;
            System.out.println(String.format("%.2f", ans));
        }
    }
}

//10
//Dong Anh
//07:30
//08:00
//60
//Cau Giay
//07:45
//08:12
//50
//Soc Son
//08:00
//09:15
//78
//Dong Anh
//18:50
//20:00
//88
//Cau Giay
//19:01
//20:00
//77
//Soc Son
//19:06
//20:21
//66
//Dong Anh
//21:00
//21:40
//49
//Cau Giay
//21:50
//22:20
//68
//Dong Anh
//22:15
//23:45
//30
//Cau Giay
//22:50
//23:45
//35
LuongMua.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class LuongMua {
    private String tenTram;
    private Date thoiDiemBatDau, thoiDiemKetThuc;
    private int luongMuaDoDuoc;

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    
    public LuongMua(String tenTram, String thoiDiemBatDau, String thoiDiemKetThuc, int luongMuaDoDuoc) throws ParseException {
        this.tenTram = tenTram;
        this.thoiDiemBatDau = sdf.parse(thoiDiemBatDau);
        this.thoiDiemKetThuc = sdf.parse(thoiDiemKetThuc);
        this.luongMuaDoDuoc = luongMuaDoDuoc;
    }
    
    public int getPhut() {
        long hieu = this.thoiDiemKetThuc.getTime() - this.thoiDiemBatDau.getTime();
        return (int)TimeUnit.MILLISECONDS.toMinutes(hieu);
    }
    
}

Pair.java


package javaptit;

public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

}

