public class Sample {
    int m;
    void xxx(){
        int n = 10;
        System.out.println(n);
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        System.out.println(s.m);
        s.xxx();
    }
}
