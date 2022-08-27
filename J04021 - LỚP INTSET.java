

import java.util.*;

public class IntSet {
    private TreeSet<Integer> set;

    public IntSet() {
        this.set = new TreeSet<>();
    }
    
    public IntSet (int[] a) {
        this.set = new TreeSet<>();
        for (int x : a) {
            this.set.add(x);
        }
    }
    
    public IntSet union (IntSet other) {
        IntSet res = new IntSet();
        for (int x : this.set) {
            res.set.add(x);
        }
        for (int x : other.set) {
            res.set.add(x);
        }
        return res;
    }
    
    @Override
    public String toString () {
        String res = "";
        for (int x : this.set) {
            res += x + " ";
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
    public static void main756274(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}

