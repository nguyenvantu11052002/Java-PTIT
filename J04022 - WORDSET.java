
import java.util.*;

public class WordSet {

    private TreeSet<String> set;

    public WordSet() {
        this.set = new TreeSet<>();
    }

    public WordSet(String s) {
        set = new TreeSet<>();
        s = s.toLowerCase();
        String[] arr = s.split("\\s+");
        for (String x : arr) {
            this.set.add(x);
        }
    }

    public WordSet union(WordSet other) {
        WordSet res = new WordSet();
        for (String x : this.set) {
            res.set.add(x);
        }
        for (String x : other.set) {
            res.set.add(x);
        }
        return res;
    }
    
    public WordSet intersection (WordSet other) {
        Map <String, Integer> map = new HashMap<>();
        for (String x : this.set) {
            map.put(x, 1);
        }
        for (String x : other.set) {
            if (map.containsKey(x)) {
                map.put(x, 2);
            }
        }
        WordSet res = new WordSet();
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            if (x.getValue() == 2) {
                res.set.add(x.getKey());
            }
        }
        return res;
    }
    
    @Override
    public String toString () {
        String res = "";
        for (String x : this.set) {
            res += x + " ";
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
    public static void main7229511(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}


//Lap trinh huong doi tuong
//Ngon ngu lap trinh C++
