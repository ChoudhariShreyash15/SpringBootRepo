package ScannerPackage;

import java.util.Scanner;

class EComStore {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Item No:");
        int itemNo = s.nextInt();
        s.nextLine();
        System.out.print("Enter Item Name:");
        String itemName = s.nextLine();
        System.out.print("Enter Item Rate:");
        double rate = s.nextDouble();
        System.out.println("Enter Item Quantity:");
        int quantity = s.nextInt();
        double amount = rate * quantity;
        System.out.print("Item No: " + itemNo + "\n" + "Item Name: " + itemName + "\n" + "Amount: " + amount);
    }
}