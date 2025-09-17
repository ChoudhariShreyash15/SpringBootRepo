package Number;

import java.util.Scanner;

public class CheckAge {

    String checkAge(int age){
        if (age >= 18)
            return "Major";
        else if (age > 0 && age < 18) {
            return "Minor";
        }
        else {
            return "Invalid Age";
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Age: ");
        int a = s.nextInt();
        CheckAge ca = new CheckAge();
        String ageCategory = ca.checkAge(a);
        System.out.println(ageCategory);
    }
}
