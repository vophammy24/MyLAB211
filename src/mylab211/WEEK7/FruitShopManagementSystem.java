package mylab211.WEEK7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FruitShopManagementSystem {
    Shopping shopping = new Shopping();
    Scanner sc = new Scanner(System.in);
    
    public boolean createFruit(){
        while(true){
            System.out.print("Enter Fruit ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Fruit Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Origin: ");
            String origin = sc.nextLine();
            shopping.createFruit(new Fruit(id, name, price, quantity, origin));
            System.out.print("Do you want to continue (Y/N): ");
            String action = sc.nextLine();
            if(action.equalsIgnoreCase("N")) 
                return false;
            else if(!action.equalsIgnoreCase("Y")) 
                System.out.println("Wrong action");
        }
    }
    
    public void shoppingFruit(){
        System.out.println("List of Fruit:");
        System.out.println("Item\tFruitName\tOrigin\tPrice\t");
        List<Fruit> fruits = shopping.getFruits();
        for(int i = 0; i < fruits.size(); i++){
            Fruit fruit = fruits.get(i);
            System.out.println(i + 1 + "\t" + fruit.getFruitName() + "\t"
                        + fruit.getOrigin() + "\t" + fruit.getPrice() + "$\t");
        }
        
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        while(true){
            System.out.print("Enter item number: ");
            int itemIndex = sc.nextInt() - 1;
            sc.nextLine();
            if(itemIndex < 0 || itemIndex >= fruits.size()){
                System.out.println("Invalid selection");
                continue;
            }
            Fruit selectedFruit = fruits.get(itemIndex);
            System.out.println("You selected: " + selectedFruit.getFruitName());
            System.out.println("Please input quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            if(quantity > selectedFruit.getQuantity()){
                System.out.println("Out of stock");
                continue;
            }
            
            orderItems.add(new OrderItem(selectedFruit.getFruitName(),
                                selectedFruit.getPrice(), quantity));
            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            System.out.print("Do you want to order now (Y/N): ");
            String action = sc.nextLine();
            if(action.equalsIgnoreCase("N")) continue;
            else if(action.equalsIgnoreCase("Y")) 
                break;
        }
        double total = 0;
        System.out.println("Product\tQuantity\tPrice\tAmount\t");
        for(OrderItem item: orderItems){
            total += item.getAmount();
            System.out.println(item.getProductName() + "\t" 
                    + item.getQuantity() + "\t" 
                    + item.getPrice() + "$\t"
                    + item.getAmount() + "$");
        }
        System.out.println("Total: " + total + "$");
        System.out.println("Input your name: ");
        String cusName = sc.nextLine();
        shopping.createOrder(cusName, orderItems);
    }
    public Shopping getShopping(){
        return shopping;
    }
    
}
