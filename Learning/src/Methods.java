public class Methods {
    int m;
    void xxx(){
        int n = 10;
        System.out.println(n);
    }

    public static void main(String[] args) {
        Methods s = new Methods();
        System.out.println(s.m);
        s.xxx();
    }
}
