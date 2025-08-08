public class Threads extends Thread {
    public void run(){
        System.out.println("Running Thread");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }    }

    public static void main(String[] args) {
        Threads t1 = new Threads();
        t1.start();
        System.out.println(t1.getPriority());
        t1.setPriority(5);
        System.out.println(t1.getPriority());

    }
}