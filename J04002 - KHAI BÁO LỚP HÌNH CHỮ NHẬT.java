
import java.util.*;

public class Rectange {
    
    private double width, height;
    private static String color;

    public Rectange() {
        this.width = 1;
        this.height = 1;
    }

    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Rectange.color = color;
    }
    
    public double findArea () {
        return this.width * this.height;
    }
    
    public double findPerimeter () {
        return 2 * (this.width + this.height);
    }
    
    public void chuanHoa () {
        String res = "";
        for (int i = 0; i < this.color.length(); i++) {
            if (i == 0) res += Character.toUpperCase(this.color.charAt(i));
            else res += Character.toLowerCase(this.color.charAt(i));
        }
        this.color = res;
    }
    
    @Override
    public String toString() {
        return String.format("%.0f", findPerimeter()) + " " + String.format("%.0f", findArea()) + " " + this.color;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double rong = sc.nextDouble();
        double dai = sc.nextDouble();
        String mau = sc.next();
        if (rong <= 0 || dai <= 0) {
            System.out.println("INVALID");
            return;
        }
        Rectange x = new Rectange(rong, dai, mau);
        x.chuanHoa();
        System.out.println(x);
    }
}
