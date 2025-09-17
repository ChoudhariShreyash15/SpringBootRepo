package String;

public class Palindrome {
    public static void check(){
        int x = 0;
        int y = 10;
        while(x<=y){
            System.out.println(x);
            x++;
        }
    }

    public static void main(String[] args) {
        String a = "aba";
        int x=0;
        int y=a.length()-1;
        while(x<=y){
            if(a.charAt(x)!=a.charAt(y)){
                System.out.println("not pallindrome");
                break;
            }
            x++;
            y--;
        }
        check();
    }
}
