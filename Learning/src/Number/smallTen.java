package Number;

import java.util.Scanner;

public class smallTen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n,i = 1,small = 0;
        while (i <= 10) {
            System.out.print("Enter Number " + i + ": ");
            n = s.nextInt();
            if (n < small){
                small = n;
            }
            i++;
        }
        System.out.println("Smallest Number = " + small);
    }
}
