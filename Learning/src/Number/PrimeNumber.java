package Number;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = scanner.nextInt();
        boolean isPrime = true;
        for(int i = 2; i<num/2;i++){
            if(num%2==0){
                isPrime=false;
                break;
            }
        }
        if (isPrime){
            System.out.println("Prime");
        }
        else {
            System.out.println("Not Prime");
        }
    }
}
