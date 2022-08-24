
package javaptit;

import java.util.*;

public class Time {
    private int gio, phut, giay;

    public Time(int gio, int phut, int giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }
    
    public int tongGiay () {
        return this.gio * 3600 + this.phut * 60 + this.giay;
    }
    
    @Override
    public String toString () {
        return this.gio + " " + this.phut + " " + this.giay;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-->0) {
            int n = sc.nextInt();
            ArrayList<Time> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int gio = sc.nextInt(), phut = sc.nextInt(), giay = sc.nextInt();
                Time x = new Time(gio, phut, giay);
                arr.add(x);
            }
            Collections.sort(arr, new Comparator<Time>() {
                @Override
                public int compare (Time a, Time b) {
                    return (a.tongGiay() - b.tongGiay());
                }
            });
            for (Time x : arr) {
                System.out.println(x);
            }
        }
    }
}

//3
//11 20 20
//14 20 14
//11 15 12
