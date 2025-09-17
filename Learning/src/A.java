public class A {
    void display(A obj) {
        System.out.println("Object passed: " + obj);
    }

    void show() {
        display(this); // passing current object
    }

    public static void main(String[] args) {
        A a = new A();
        a.display(a);
        a.show();
    }
}