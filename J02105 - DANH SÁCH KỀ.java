package newclass;

import java.util.*;

public class NewClass {  
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 1) {
                        tmp.add(j + 1);
                    }
                }
                adj.add(tmp);
            }
            int id = 1;
            for (ArrayList<Integer> x : adj) {
                System.out.print("List(" + id + ") = ");
                id++;
                for (Integer y : x) {
                    System.out.print(y + " ");
                }
                System.out.println("");
            }
        }
    }
}

//6
//0 1 1 0 1 0
//1 0 1 0 1 0
//1 1 0 1 0 0
//0 0 1 0 1 1
//1 1 0 1 0 1
//0 0 0 1 1 0
