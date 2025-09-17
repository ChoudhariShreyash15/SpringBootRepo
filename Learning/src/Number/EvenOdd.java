package Number;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = scanner.nextInt();
//        for(int i = 1; i<=num; i++){
//            if(i%2==0){
//                System.out.println(i + " is Even");
//            }
//            else{
//                System.out.println(i + " is Odd");
//            }
//        }
        if(num%2==0){
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
    }
}