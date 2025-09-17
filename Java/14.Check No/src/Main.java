import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter The Number: ");
        int num = s.nextInt();
        if (num > 0)
            System.out.println("Number is Positive");
        else
            if(num < 0)
                System.out.println("Number is Negative");
            else
                System.out.println("Number is Zero");
    }
}