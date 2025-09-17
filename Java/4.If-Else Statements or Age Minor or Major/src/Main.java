import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Age: ");
        int age = s.nextInt();
        if(age >= 18){
            System.out.println("You are an adult");
        }
        else if (age <= 18 && age >= 1) {
            System.out.println("You are not an adult");
        }
        else{
            System.out.println("Invalid Age");
        }
    }
}
