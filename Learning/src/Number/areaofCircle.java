package Number;

import java.util.Scanner;

public class areaofCircle {

    double areaofCircle(int r){
        double pi = 3.14;
        double area = pi * r * r;
        return area;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Radius: ");
        int r = s.nextInt();
        areaofCircle a = new areaofCircle();
        double b = a.areaofCircle(r);
        System.out.println(b);
    }
}
