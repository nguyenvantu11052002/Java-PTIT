package newclass;

import java.util.*;

public class NewClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n + 5][n + 5];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int j = 1; j <= n; j++) {
                    if (a[i][j] == 1 && i < j) {
                        tmp.add(j);
                    }
                }
                adj.add(tmp);
            }
            int id = 1;
            for (ArrayList<Integer> x : adj) {
                for (Integer y : x) {
                    System.out.println("(" + id + "," + y + ")");
                }
                id++;
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
