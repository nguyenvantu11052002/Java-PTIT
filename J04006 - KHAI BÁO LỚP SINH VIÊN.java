package newclass;

import java.util.*;

public class NewClass {
    private String maSinhVien, hoTen, lop, ngaySinh;
    private double gpa;

    public NewClass() {
        this.maSinhVien = this.hoTen = this.lop = this.ngaySinh = "";
        this.gpa = 0;
    }

    public NewClass(String maSinhVien, String hoTen, String lop, String ngaySinh, double gpa) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngaySinh = ngaySinh;
        this.gpa = gpa;
    }
    
    public void chuanHoa () {
        String[] arr = this.ngaySinh.split("/");
        if (arr[0].length() == 1) arr[0] = "0" + arr[0];
        if (arr[1].length() == 1) arr[1] = "0" + arr[1];
        this.ngaySinh = arr[0] + "/" + arr[1] + "/" + arr[2];
    }
    
    @Override
    public String toString() {
        return this.maSinhVien + " " + this.hoTen + " " + this.lop + " " + this.ngaySinh + " " + String.format("%.2f", this.gpa);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        //t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String hoTen = sc.nextLine();
            String lop = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double gpa = sc.nextDouble();
            NewClass x = new NewClass ("B20DCCN001", hoTen, lop, ngaySinh, gpa);
            x.chuanHoa();
            System.out.println(x);
        }
    }
}

//Nguyen Hoa Binh
//D20CQCN04-B
//2/2/2002
//2

