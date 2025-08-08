public class UpCasting_DownCasting {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.AnimalSound(); //UpCasting

        Cat c = (Cat) a;
        c.AnimalSound(); //DownCasting
    }
}