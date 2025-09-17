package TypeCasting;

public class UnBoxing {
    public static void main(String[] args) {
        Integer a = 10;
        int b = a;

        int y = a.intValue(); //Written Explicitly
        System.out.println(a + "\n" + b);
    }
}
