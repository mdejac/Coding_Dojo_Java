import java.util.ArrayList;

public class Order {
    private String name;
    private boolean isReady;
    private ArrayList<Item> items;

    public Order(){
        initializeOrder("Guest");
    }

    public Order(String name) {
        initializeOrder(name);
    }

    private void initializeOrder(String name){
        this.name = name;
        this.isReady = false;
        this.items = new ArrayList<Item>();
    }


    public String getName() {
        return this.name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public boolean getOrderStatus() {
        return this.isReady;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Order addItem(Item newItem){
        this.items.add(newItem);
        return this;
    }

    public Order updateOrderStatus(boolean isReady) {
        this.isReady = isReady;
        return this;
    }

    public String getStatusMessage() {
        return this.isReady ? "Your order is ready." : "Thank you for waiting.";
    }

    public double getOrderTotal() {
        double total = 0d;
        for (int i = 0; i < this.items.size(); i++) {
            total += this.items.get(i).getPrice();
        }
        return total;
    }

    public Order display() {
        System.out.printf("Customer name : %s\n", this.name);
        for (int i = 0; i < this.items.size(); i++) {
            System.out.printf("%s - $%.2f\n", this.items.get(i).getName(), this.items.get(i).getPrice());
        }
        System.out.printf("Total : $%.2f\n\n", getOrderTotal());
        return this;
    }
}