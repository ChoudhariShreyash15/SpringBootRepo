import java.util.Scanner;

public class EvenOdd {

    String evenOdd(int a){
        if (a < 0) {
            return "Not a Valid Number";
        }
        else if (a % 2 == 0){
            return "Even Number";
        }
        else {
            return "Odd Number";
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int a = s.nextInt();
        EvenOdd e = new EvenOdd();
        String b = e.evenOdd(a);
        System.out.println(b);
    }
}
