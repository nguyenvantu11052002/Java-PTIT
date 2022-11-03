Main.java
package javaptit;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Nguoi> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.trim().split("\\s+");
            list.add(new Nguoi(arr[0], arr[1]));
        }
        // tre nhat la getTime lon nhat
        
        long treNhat = 0;
        long giaNhat = (long) Math.pow(10, 18);
        for (Nguoi x : list) {
            treNhat = Math.max(treNhat, x.getTime1());
            giaNhat = Math.min(giaNhat, x.getTime1());
        }
        for (Nguoi x : list) {
            if (x.getTime1() == treNhat) {
                System.out.println(x.getTen());
                break;
            }
        }
        for (Nguoi x : list) {
            if (x.getTime1() == giaNhat) {
                System.out.println(x.getTen());
                break;
            }
        }
        
    } 
}

//5
//Nam 01/10/1991
//An 30/12/1990
//Binh 15/08/1993
//Tam 18/09/1990
//Truong 20/09/1990


Nguoi.java
package javaptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Nguoi {
    private String ten;
    private Date ngayThangNamSinh;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Nguoi(String ten, String ngayThangNamSinh) throws ParseException {
        this.ten = ten;
        this.ngayThangNamSinh = sdf.parse(ngayThangNamSinh);
    }
    
    public String getTen() {
        return this.ten;
    }
    
    public long getTime1() {
        return this.ngayThangNamSinh.getTime();
    }
}
