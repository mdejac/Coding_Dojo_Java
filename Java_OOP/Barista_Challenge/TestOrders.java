import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("Mocha", 2.15);
        Item item2 = new Item("Drip Coffee", 2.75);
        Item item3 = new Item("Latte", 3.15);
        Item item4 = new Item("Cappucino", 2.50);
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Jimmy");
        Order order4 = new Order("Noah");
        Order order5 = new Order("Sam");

        //Method Tests
        order1.addItem(item1).addItem(item2);
        order2.addItem(item2).addItem(item3);
        order3.addItem(item3).addItem(item4);
        order4.addItem(item4).addItem(item1);
        order5.addItem(item2).addItem(item2);

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        System.out.println(order1.updateOrderStatus(true).getStatusMessage());
        System.out.println(order2.updateOrderStatus(false).getStatusMessage());
        System.out.println(order3.updateOrderStatus(true).getStatusMessage());
        System.out.println(order4.updateOrderStatus(false).getStatusMessage());
        System.out.println(order5.updateOrderStatus(true).getStatusMessage());

        System.out.printf("Order1 total : $%.2f\n", order1.getOrderTotal());
        System.out.printf("Order2 total : $%.2f\n", order2.getOrderTotal());
        System.out.printf("Order3 total : $%.2f\n", order3.getOrderTotal());
        System.out.printf("Order4 total : $%.2f\n", order4.getOrderTotal());
        System.out.printf("Order5 total : $%.2f\n", order5.getOrderTotal());
    
    }
}
