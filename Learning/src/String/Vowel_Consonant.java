package String;

import java.util.Scanner;

public class Vowel_Consonant {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Character: ");
//        char c = s.next().toLowerCase().charAt(0);
        String c = s.next();
        switch (c){
            case "a","e","i","o","u":
                System.out.println(c + " is a Vowel");
                break;
            default:
                System.out.println(c + " is a Consonent");
        }
    }
}

//import java.util.Scanner;
//
//public class String.Vowel_Consonant {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter an alphabet: ");
//        char ch = sc.next().toLowerCase().charAt(0);  // Convert to lowercase for simplicity
//
//        switch (ch) {
//            case 'a':
//            case 'e':
//            case 'i':
//            case 'o':
//            case 'u':
//                System.out.println(ch + " is a vowel.");
//                break;
//            default:
//                if ((ch >= 'a' && ch <= 'z'))
//                    System.out.println(ch + " is a consonant.");
//                else
//                    System.out.println("Invalid input. Please enter an alphabet.");
//        }
//
//        sc.close();
//    }
//}

