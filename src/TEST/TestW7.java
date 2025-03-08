package TEST;

import java.util.Scanner;
import mylab211.WEEK7.FruitShopManagementSystem;
import mylab211.WEEK7.Shopping;

public class TestW7 {
    public static void main(String[] args) {
        FruitShopManagementSystem fsm = new FruitShopManagementSystem();
        Shopping shopping = new Shopping();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nFRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View Orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    fsm.createFruit();
                    break;
                case 2:
                    fsm.getShopping().viewOrders();
                    break;
                case 3:
                    fsm.shoppingFruit();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
