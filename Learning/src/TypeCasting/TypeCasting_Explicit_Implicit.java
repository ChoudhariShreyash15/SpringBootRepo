package TypeCasting;

public class TypeCasting_Explicit_Implicit {
    public static void main(String[] args) {
        int a = 10;
        long b = a; // Widening or Implicit

        long c = a;
        int s = (int)c; // Narrowing or Explicit
        float f1 = 3.14f;
        float f2 = 3.14F;
        float f3 = (float) 3.14;
        System.out.println(f1 + " " + f2 + " " + f3);
    }
}
