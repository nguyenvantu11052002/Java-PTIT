package javaptit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.*;
import java.util.*;

public class JavaPTIT1 {
      
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            try {
                FileWriter fw = new FileWriter("DATA.in");
                BufferedWriter bw = new BufferedWriter(fw);
                String line = "";
                while (true) {
                     line = sc.nextLine();
                     bw.write(line);
                }
            } catch (Exception e) {
                
            }
            
            try {
                FileReader fr = new FileReader("DATA.in");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                     line = br.readLine();
                     if (line.equals(null)) break;
                     System.out.println(line);
                }
            } catch (Exception e) {
                
            }
        }
    }
}

