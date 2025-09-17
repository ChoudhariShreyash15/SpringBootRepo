package Number;

import java.util.Scanner;

public class CheckDiscount {
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
        double discount = 0;
        if (amount >= 1000 && amount < 2000){
            discount = 0.10 * amount;
        }
        else if (amount >= 2000 && amount < 3000) {
            discount = 0.15 * amount;
        }
        else if (amount >= 3000 && amount < 5000) {
            discount = 0.20 * amount;
        }
        else if (amount >= 5000){
            discount = 0.25 * amount;
        }
        else
            System.out.println("No Discount is there for desired amount");

        double netAmount = amount - discount;
        System.out.print("Item No: " + itemNo + "\n"
                + "Item Name: " + itemName + "\n"
                + "Amount: " + amount + "\n"
                + "Discount: " + discount + "\n"
                + "Net Amount: " + netAmount);
    }
}