import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Item No:");
        int itemNo = s.nextInt();
        s.nextLine();
        System.out.println("Enter Item Name:");
        String itemName = s.nextLine();
        System.out.println("Enter Item Rate:");
        double rate = s.nextDouble();
        System.out.println("Enter Item Quantity:");
        int quantity = s.nextInt();
        double amount = rate * quantity;
        System.out.println("Item No: " + itemNo + "\n" + "Item Name: " + itemName + "\n" + "Amount: " + amount);
    }
}