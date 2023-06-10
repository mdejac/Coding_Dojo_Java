import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("Mocha", 2.15);
        Item item2 = new Item("Drip Coffee", 2.75);
        Item item3 = new Item("Latte", 3.15);
        Item item4 = new Item("Cappucino", 2.50);
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");
    
        // Application Simulations
        order1.addItem(item2).updateOrderStatus(true);
        order2.addItem(item1).updateOrderStatus(true);
        order3.addItem(item4);
        order4.addItem(item3).addItem(item3).addItem(item3);

        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: $%.2f\n", order1.total);
        System.out.printf("Ready: %s\n\n", order1.isReady);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: $%.2f\n", order2.total);
        System.out.printf("Ready: %s\n\n", order2.isReady);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: $%.2f\n", order3.total);
        System.out.printf("Ready: %s\n\n", order3.isReady);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: $%.2f\n", order4.total);
        System.out.printf("Ready: %s\n\n", order4.isReady);
    }
}
