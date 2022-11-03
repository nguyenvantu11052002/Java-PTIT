javaptit/Main.java
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
        Collections.sort(list, new SortBy());
        System.out.println(list.get(0).getTen());
        System.out.println(list.get(n - 1).getTen());
    } 
}

//5
//Nam 01/10/1991
//An 30/12/1990
//Binh 15/08/1993
//Tam 18/09/1990
//Truong 20/09/1990


javaptit/Nguoi.java
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
javaptit/SortBy.java

package javaptit;

import java.util.*;

public class SortBy implements Comparator<Nguoi> {
    
    @Override
    public int compare(Nguoi o1, Nguoi o2) {
        if (o1.getTime1() > o2.getTime1()) return -1;
        return 1;
    }
}

