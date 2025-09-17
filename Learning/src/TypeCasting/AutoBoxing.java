package TypeCasting;

public class AutoBoxing {
    public static void main(String[] args) {
        int a = 10;
        Integer b = a;
        Integer c = Integer.valueOf(a); //Written Explicitly

        System.out.println(a + " " + b +" "+ c);
    }
}