public class Person {
    int age;
    String name;
    double height;

    void walk(){
        System.out.println("Walking");
    }

    void eat(){
        System.out.println("Eating");
    }

    public static void main(String[] args){
        Person p = new Person();
        p.age = 20;
        p.name= "Shreyash";
        p.height = 5.7;
        p.walk();
        p.eat();
    }
}