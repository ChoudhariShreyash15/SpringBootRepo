import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of Array: ");
        int size = s.nextInt();
        int[] n = new int[size];
        System.out.println("Enter the elements of Array: ");
        for (int i=0; i<n.length; i++)
            n[i] = s.nextInt();
        System.out.println("Given Array Elements: ");
        for (int i=0; i<n.length; i++)
            System.out.println(n[i]);
        System.out.println("Given Array Elements - foreach: ");
        for(int x : n)
            System.out.println(x);
    }
}