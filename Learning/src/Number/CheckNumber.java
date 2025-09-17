package Number;

import java.util.Scanner;

public class CheckNumber {

    String checkNo(int a){
        if (a > 0){
            return a + " is Positive Number";
        }
        else if (a < 0){
            return a + " is Negative Number";
        }
        else {
            return "Zero";
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int num = s.nextInt();
        CheckNumber c = new CheckNumber();
        String b = c.checkNo(num);
        System.out.println(b);
    }
}
