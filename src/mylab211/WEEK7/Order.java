package mylab211.WEEK7;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<OrderItem> orderItems;

    public Order(String customerName) {
        this.customerName = customerName;
        this.orderItems = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getOrderItem() {
        return orderItems;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItems = orderItem;
    }
    
    public void addItem(OrderItem item){
        orderItems.add(item);
    }
    
    public void viewOrder(){
        double totalAmount = 0;
        System.out.println("Customer Name: " + customerName);
        System.out.println("Product\tQuantity\tPrice\tAmount");
        for(OrderItem item: orderItems){
            System.out.printf(item.getProductName() +"\t"+ item.getQuantity()+"\t"+
                                item.getPrice() +"\t"+ item.getAmount());
            totalAmount += item.getAmount();
        }
        System.out.println("Total: " + totalAmount + "$");
    }
    
}
