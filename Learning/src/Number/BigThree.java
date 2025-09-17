package Number;

import java.util.Scanner;

public class BigThree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Three Numbers: ");
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        int num3 = s.nextInt();
//        if (num1 > num2 && num1 > num3)
//            System.out.println(num1 + " is Greatest");
//        else if (num2 > num3)
//            System.out.println(num2 + " is Greatest");
//        else
//            System.out.println(num3 + " is Greatest");

        //Using Ternary Operator / Conditional Operator
        int max = (num1 > num2)
                ? (num1 > num3 ? num1 : num3)
                : (num2 > num3 ? num2 : num3);
        System.out.println(max + " is Greatest");
    }
}
