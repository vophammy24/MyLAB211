package mylab211.WEEK7;

public class Fruit {
    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit(String fruitId, String fruitName, double price, int quantity, String Origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = Origin;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String Origin) {
        this.origin = Origin;
    }
}
