package TypeCasting;

public class UpCasting_DownCasting {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.AnimalSound(); //UpCasting

        Cat c = (Cat) a;
        c.AnimalSound(); //DownCasting
    }

    public static class Animal {
        public void AnimalSound(){
            System.out.println("AnimalSounds");
        }
    }

    public static class Cat extends Animal {
        public void AnimalSound(){
            System.out.println("Meow");
        }
    }
}