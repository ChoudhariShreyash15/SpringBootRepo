package Number;

import java.util.Scanner;

public class bigTen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n,i = 1,big = 0;
        while (i <= 10) {
            System.out.print("Enter Number " + i + ": ");
            n = s.nextInt();
            if (n > big){
                big = n;
            }
            i++;
        }
        System.out.println("Biggest Number = " + big);
    }
}
