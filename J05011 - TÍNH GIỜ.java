javaptit/GameThu.java
package javaptit;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class GameThu{
    private String maNguoiChoi, tenNguoiChoi;
    private Date gioVao, gioRa;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    
    public GameThu(String maNguoiChoi, String tenNguoiChoi, String gioVao, String gioRa) throws ParseException {
        this.maNguoiChoi = maNguoiChoi;
        this.tenNguoiChoi = tenNguoiChoi;
        this.gioVao = sdf.parse(gioVao);
        this.gioRa = sdf.parse(gioRa);
    }
    
    public String thoiGianChoi() {
        int soGio = (int) TimeUnit.MILLISECONDS.toHours(this.gioRa.getTime() - this.gioVao.getTime());
        int soPhut = (int) TimeUnit.MILLISECONDS.toMinutes(this.gioRa.getTime() - this.gioVao.getTime() - soGio * 60 * 60 * 1000);
        
        return this.maNguoiChoi + " " + this.tenNguoiChoi + " " + String.format("%d gio %d phut", soGio, soPhut);
    }
    
    public long thoiGianChoiSX() {
        return this.gioRa.getTime() - this.gioVao.getTime();
    }
    @Override
    public String toString () {
        return this.thoiGianChoi();
    }

}
javaptit/Main.java
package javaptit;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<GameThu> list = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            list.add(new GameThu(s1, s2, s3, s4));
        }
        Collections.sort(list, new SortByTime());
        for (GameThu x : list) {
            System.out.println(x);
        }
    } 
}

//3
//01T
//Nguyen Van An
//09:00
//10:30
//06T
//Hoang Van Nam
//15:30
//18:00
//02I
//Tran Hoa Binh
//09:05
//10:00
javaptit/SortByTime.java
package javaptit;

import java.util.*;

public class SortByTime implements Comparator<GameThu> {

    @Override
    public int compare(GameThu o1, GameThu o2) {
        if (o1.thoiGianChoiSX() > o2.thoiGianChoiSX()) return -1;
        return 1;
    }
}

