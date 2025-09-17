package Number;

import java.util.Scanner;

public class Factorial {

    static int factorial(int a){
        int f=1;
        for(int i=a; i>=1 ;i--){
            f = f * i;
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = s.nextInt();
        int b = factorial(n);
        System.out.println(b);
    }
}
