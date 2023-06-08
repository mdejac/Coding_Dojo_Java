import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++){
            sum += i;
        }
        return sum;
    }

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0.0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name :");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s!\n", userName);
        System.out.printf("There are %d people in front of you.\n", customers.size());
        customers.add(userName);
        for (String name : customers) {
            System.out.println(name);
        }
    }

    public ArrayList<String> addCustomers() {
        String input = "";
        ArrayList<String> customerList = new ArrayList<String>();
        while (!input.equals("q")) {
            if (!input.equals("")) {
                customerList.add(input);
                System.out.printf("%s has been added\n", input);
                System.out.println("Current list of Customers : " + customerList);
            }
            System.out.println("Enter customer name, type 'q' to quit :");
            input = System.console().readLine();
        }
        return customerList;
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.printf("%d - $%.2f\n", i, price * i - .50 * (i-1));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        for (int i= 0; i < menuItems.size(); i++) {
            System.out.printf("%d %s -- $%.2f\n", i, menuItems.get(i), prices.get(i));
        }
        return true;
    }
}