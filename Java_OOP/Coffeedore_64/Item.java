public class Item {
    private String name;
    private double price;

    public Item(String name, double price) { 
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice(){
        return this.price;
    }

    public Item setPrice(double price) {
        this.price = price;
        return this;
    }
}