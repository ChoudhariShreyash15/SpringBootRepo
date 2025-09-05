package Number;

public class Palindrome {
    public static void main(String[] args) {
        int a = 1231;
        int b = a;
        int palindrome = 0;

        while(a != 0){
            int c = a % 10;
            palindrome = palindrome * 10 + c;
            a /= 10;
        }

        if(b==palindrome){
            System.out.println(palindrome + " is Palindrome");
        }
        else {
            System.out.println(palindrome + " is not Palindrome");
        }
    }
}
