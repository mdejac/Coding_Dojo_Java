import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
  public static void main(String[] args) {

    CafeUtil appTest = new CafeUtil();    

    /* ============ App Test Cases ============= */

    int weeks = 15;
    System.out.println("\n----- Streak Goal Test -----");
    System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());
    System.out.printf("Purchases needed by week %d: %s \n\n", weeks, appTest.getStreakGoal(weeks));

    System.out.println("----- Order Total Test -----");
    double[] lineItems = {3.5, 1.5, 4.0, 4.5};
    System.out.printf("Order total: $%.2f \n\n",appTest.getOrderTotal(lineItems));

    System.out.println("----- Display Menu Test -----");

    ArrayList<String> menu = new ArrayList<String>();
    menu.add("drip coffee");
    menu.add("cappuccino");
    menu.add("latte");
    menu.add("mocha");
    appTest.displayMenu(menu);

    // System.out.println("\n----- Add Customer Test-----");
    // ArrayList<String> customers = new ArrayList<String>();
    // // --- Test 4 times ---
    // for (int i = 0; i < 4; i++) {
    //   appTest.addCustomer(customers);
    //   System.out.println("\n");
    // }

    System.out.println("\n----- Print Price Chart Test -----");
    appTest.printPriceChart("Columbian Coffee Grounds", 2.0, 4);

    
    System.out.println("\n----- Display Menu Test -----");
    ArrayList<String> items = new ArrayList<String>();
    items.add("drip coffee");
    items.add("cappucino");
    items.add("latte");
    items.add("mocha");
    ArrayList<Double> prices = new ArrayList<Double>();
    prices.add(1.50);
    prices.add(3.50);
    prices.add(4.50);
    prices.add(3.50);
    appTest.displayMenu(items, prices);


    System.out.println("\n----- Add Customers Test -----");
    ArrayList<String> newCustomers = new ArrayList<String>();
    newCustomers = appTest.addCustomers();
    System.out.println("Customers added : " + newCustomers);
 }
}
