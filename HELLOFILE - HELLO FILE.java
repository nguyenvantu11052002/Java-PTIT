package javaptit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.math.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaPTIT1 {
    
    public void writeLine () {
        try {
                FileWriter fw = new FileWriter("data.txt");
                BufferedWriter bw = new BufferedWriter(fw);
               
                bw.close();
                fw.close();
            } catch (Exception e) {

            }
    }
    
    public static void readFile () {
        try {
                FileReader fr = new FileReader("data.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) break;
                    System.out.println(line);
                }
            } catch (Exception e) {
                
            }
    }
    
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
           
            try {
                FileReader fr = new FileReader("Hello.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) break;
                    System.out.println(line);
                }
            } catch (Exception e) {
                
            }
        }
    }
}
