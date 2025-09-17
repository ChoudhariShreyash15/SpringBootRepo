package LambdaFunction;

public class MainLambda {
    public static void main(String[] args) {
        LambdaFunction l = new LambdaFunction() {
            @Override
            public void m1(int a, int b) {
                System.out.println("Java");
            }
        };
        LambdaFunction l2 = (int a, int b) -> {
            System.out.println(a*b);
        };
        l2.m1(10,20);
        l.m1(30,40);

        Runnable r = () -> {
            System.out.println("OK");
        };
        Thread t = new Thread(r);
        t.start();
    }
}
