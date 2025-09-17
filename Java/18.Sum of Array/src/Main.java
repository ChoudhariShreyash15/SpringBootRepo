import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Size of Array: ");
        int size = s.nextInt();
        int[] n = new int[size];
        int sum = 0;
        System.out.println("Enter Elements in Array: ");
        for(int i=0; i<n.length; i++){
            n[i] = s.nextInt();
            sum = sum + n[i];
        }
        System.out.println("Sum of Array: " + sum);
    }
}

