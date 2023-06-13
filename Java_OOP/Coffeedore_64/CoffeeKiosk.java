import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public CoffeeKiosk addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        this.menu.add(newItem);
        return this;
    }

    public CoffeeKiosk displayMenu() {
        System.out.println("------ Menu ------");
        System.out.println("------------------");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.printf("%s %s -- $%.2f\n", i, menu.get(i).getName(), menu.get(i).getPrice());
        }
        System.out.println("------------------\n");
        return this;
    }

    public CoffeeKiosk newOrder() {
        System.out.print("Please enter the customer name for new order : ");
        String name = System.console().readLine();
        Order newOrder = name.equals("") ? new Order() : new Order(name);
        System.out.println();
        displayMenu();
        int itemNumber = itemSelectionPrompt();
        while (itemNumber != -1) {
            if (itemNumber >= 0){
                newOrder.addItem(this.menu.get(itemNumber));
                System.out.printf("%s has been added to order.\n", this.menu.get(itemNumber).getName());   
            } else {
               System.out.println("Invalid selection entered.  Please select again");
            }
            displayMenu(); 
            itemNumber = itemSelectionPrompt();
        }
        System.out.printf("Thank you, %s. Your order details are : \n", name);
        newOrder.display();
        this.orders.add(newOrder);
        return this;
    }

    public CoffeeKiosk displayAllOrders(){
        for (int i = 0; i < this.orders.size(); i++){
            this.orders.get(i).display();
        }
        return this;
    }

    public CoffeeKiosk addMenuItemByInput() {
        String itemName = newItemNamePrompt();
        double itemPrice = newItemPricePrompt();
        System.out.printf("Item to add : %s $%.2f\n", itemName, itemPrice);
        if (confirmEntry()){
            addMenuItem(itemName, itemPrice);
        } else {
            System.out.println("Add item cancelled.");
        }
        return this;
    }

    public CoffeeKiosk editMenu() {
        displayMenu();
        System.out.println("Edit Item");
        int itemNumber = itemSelectionPrompt();
        if (itemNumber >= 0) {
            String itemName = newItemNamePrompt();
            double itemPrice = newItemPricePrompt();
            System.out.printf("Item %s %s $%.2f is set to change to %s $%.2f.\n", itemNumber, this.menu.get(itemNumber).getName(), this.menu.get(itemNumber).getPrice(), itemName, itemPrice);
            if (confirmEntry()){
                menu.get(itemNumber).setName(itemName);
                menu.get(itemNumber).setPrice(itemPrice);
            } else {
                System.out.println("Edit Cancelled.");
            }
        }
        return this;
    }

    public CoffeeKiosk deleteMenuItem() {
        displayMenu();
        System.out.println("Delete Item.");     
        int itemNumber = itemSelectionPrompt();
        if (itemNumber >= 0){
            System.out.printf("Item %s %s $%.2f is queued for deletion.\n", itemNumber, this.menu.get(itemNumber).getName(), this.menu.get(itemNumber).getPrice());
            if (confirmEntry()){
                this.menu.remove(itemNumber);
            } else {
                System.out.println("Delete Cancelled");
            }           
        }
        return this;
    }

    private int itemSelectionPrompt(){
        System.out.print("Please enter an item number or q to quit : ");
        String itemNumber = System.console().readLine();
        if (isInteger(itemNumber) && Integer.parseInt(itemNumber) < this.menu.size()) {
            return Integer.parseInt(itemNumber);
        } else {
            return itemNumber.equals("q") ? -1 : -2;
        }
    }

    private String newItemNamePrompt() {
        System.out.print("\nEnter new item name : ");
        String itemName = System.console().readLine();
        while (itemName.equals("")) {
            System.out.println("Name can not be blank.");
            System.out.print("Enter item name : ");
            itemName = System.console().readLine();
        }
        return itemName;
    }

    private double newItemPricePrompt(){
        System.out.print("Enter item price : $");
        String itemPrice = System.console().readLine();
        while (!isDouble(itemPrice)) {
            System.out.println("Price must be numeric.");
            System.out.print("Enter item price : $");
            itemPrice = System.console().readLine();
            System.out.println();  
        }
        return Double.parseDouble(itemPrice);
    }

    private boolean confirmEntry() {
        System.out.print("Is this correct? (y to accept) : ");
        String answer = System.console().readLine();
        if (answer.toLowerCase().equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean isDouble(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}