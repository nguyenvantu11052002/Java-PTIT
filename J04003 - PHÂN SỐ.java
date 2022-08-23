package newclass;

import java.math.BigInteger;
import java.util.*;

public class NewClass {
    private long tuSo, mauSo;

    public NewClass(long tuSo, long mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    
    public void toiGian () {
        long a = this.tuSo, b = this.mauSo;
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        this.tuSo /= a;
        this.mauSo /= a;
    }
    
    @Override
    public String toString () {
        return this.tuSo + "/" + this.mauSo;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
       
        while (t-- > 0) {
            long tuSo = sc.nextLong();
            long mauSo = sc.nextLong();
            NewClass x = new NewClass(tuSo, mauSo);
            x.toiGian();
            System.out.println(x);
        }
    }
}
