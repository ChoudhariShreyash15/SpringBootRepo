import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter First No: ");
        int a = s.nextInt();
        System.out.println("Enter Second No: ");
        int b = s.nextInt();
        System.out.println("Enter Third No: ");
        int c = s.nextInt();
        int big = (a > b && a > c) ? a : (b > c) ? b : c;
        System.out.println("Biggest No: " + big);
    }
}