import java.util.ArrayList;

public class Order {
    String name;
    double total;
    boolean isReady;
    ArrayList<Item> items;

    public Order(String name){
        this.name = name;
        this.total = 0d;
        this.isReady = false;
        this.items = new ArrayList<Item>();
    }

    public Order addItem(Item newItem){
        this.items.add(newItem);
        this.total += newItem.price;
        return this;
    }

    public Order updateOrderStatus(boolean isReady) {
        this.isReady = isReady;
        return this;
    }

}