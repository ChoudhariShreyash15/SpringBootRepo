package Pattern;

import java.util.Scanner;

class InvertedTriangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = s.nextInt();
        for(int i=n; i>0; i--){
            for(int j=1; j<=i; j++){
                System.out.print(" * ");
            }

            System.out.println();
        }
    }
}