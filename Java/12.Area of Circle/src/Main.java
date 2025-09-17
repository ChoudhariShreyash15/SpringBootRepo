import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double PI = 3.14;
        System.out.println("Enter Radius: ");
        int r = s.nextInt();
        double area = PI * r * r;
        System.out.println("Area of Circle: " + area);
    }
}