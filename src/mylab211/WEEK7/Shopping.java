package mylab211.WEEK7;

import java.util.ArrayList;
import java.util.List;

public class Shopping {
    private List<Fruit> fruits;
    private List<Order> orders;
    
    public Shopping(){
        fruits = new ArrayList<>();
        orders = new ArrayList<>();
    }
    
    public void createFruit(Fruit fruit){
        fruits.add(fruit);
    }
    
    public Fruit getFruitByName(String fruitName){
        for(Fruit fruit: fruits){
            if(fruit.getFruitName().equalsIgnoreCase(fruitName))
                return fruit;
        }
        return null;
    }
    
    public void createOrder(String customerName, ArrayList<OrderItem> item){
        Order order = new Order(customerName);
        for(OrderItem it: item){
            order.addItem(it);
        }
        orders.add(order);
    }
    
    public void viewOrders(){
        for(Order order: orders){
            order.viewOrder();
        }
    }
}
