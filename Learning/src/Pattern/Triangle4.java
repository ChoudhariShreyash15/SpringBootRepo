package Pattern;

import java.util.Scanner;

public class Triangle4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int n = scanner.nextInt();
        for (int i=1; i<=n; i++){
            for (int k=n-i; k>0; k--){
                System.out.print("   ");
            }
            for (int j=1; j<=i; j++){
                System.out.print(" * ");
            }
            for (int l=1; l<i; l++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        for (int i=n-1; i>=1; i--){
            for (int k=n-i; k>0; k--){
                System.out.print("   ");
            }
            for (int j=1; j<=i; j++){
                System.out.print(" * ");
            }
            for (int l=1; l<i; l++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
