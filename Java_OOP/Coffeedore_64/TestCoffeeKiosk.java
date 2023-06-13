public class TestCoffeeKiosk {
    public static void main(String[] args) {
        CoffeeKiosk cafe = new CoffeeKiosk();
        
        cafe.addMenuItem("Mocha", 2.15);
        cafe.addMenuItem("Drip Coffee", 2.75);
        cafe.addMenuItem("Latte", 3.15);
        cafe.addMenuItem("Cappucino", 2.50);
        cafe.addMenuItem("Muffin", 4.00);
        cafe.addMenuItem("Fresh Fruit Bowl", 5.50);
        
        cafe.newOrder();
        cafe.newOrder();

        cafe.displayAllOrders();

        cafe.addMenuItemByInput().displayMenu();

        cafe.editMenu().displayMenu();

        cafe.deleteMenuItem().displayMenu();
    }
}
