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
import java.util.*;
import static javaptit.SupportFunctions.erathone;
import static javaptit.SupportFunctions.filterValidNumbers1;
import static javaptit.SupportFunctions.filterValidNumbers2;
import static javaptit.SupportFunctions.memset;
import static javaptit.SupportFunctions.printResults;


public class Main {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        erathone();
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> list1 = (List<Integer>) ois1.readObject();
        List<Integer> list2 = (List<Integer>) ois2.readObject();
        memset();
        filterValidNumbers1(list1);
        filterValidNumbers2(list2);
        printResults();
        
    }

}



javaptit/SupportFunctions.java
package javaptit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class SupportFunctions {

    public static int[] prime = new int[1000001];
    public static int maxSize = 1000001;
    public static boolean[] tick = new boolean[maxSize];
    public static void memset () {
        Arrays.fill(tick, false);
    }

    public static void erathone() {
		Arrays.fill(prime, 1);
		prime[0] = 0;
		prime[1] = 0;
		for(int i = 4; i < maxSize; i+=2)
			prime[i] = 0;
		for(int i = 3; i <= Math.sqrt(maxSize); i+=2) {
		          if (prime[i] == 1) {
                for (int j = i * i; j < maxSize; j += i) {
                    prime[j] = 0;
                }
            }
        }

    }

    public static void filterValidNumbers1(List<Integer> list) {
        for (Integer x : list) {
            if (x < (maxSize - 1) / 2 && prime[x] == 1) {
                tick[x] = true;
            }
        }
    }

    public static void filterValidNumbers2(List<Integer> list) {
        for (Integer x : list) {
            if (x > (maxSize - 1) / 2 && prime[x] == 1) {
                tick[x] = true;
            }
        }
    }

    public static void printResults() {
        for (int i = 3; i < (maxSize - 1) / 2; i += 2) {
            if (tick[i] == true && tick[maxSize - 1 - i] == true) {
                System.out.println(i + " " + (maxSize - 1 - i));
            }
        }
    }

}
