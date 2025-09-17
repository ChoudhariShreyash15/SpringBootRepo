package Number;

import java.util.Scanner;

public class sumTen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n,i = 1,sum = 0;
        while (i <= 10) {
            System.out.print("Enter Number " + i + ": ");
            n = s.nextInt();
            sum += n;
            i++;
        }
        System.out.println("Sum = " + sum);
    }
}
