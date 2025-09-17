package Number;

import java.util.Scanner;

public class sumEvenOdd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int a = s.nextInt();
        if (a < 0) {
            System.out.println("Not a Valid Number");
        }
        else if (a % 2 == 0){
            System.out.println("Even Number");
        }
        else {
            System.out.println("Odd Number");
        }
    }
}
