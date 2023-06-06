public class CafeJava {
    public static void main (String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly.\n";
        String readyMessage = ", your order is ready.\n";
        String displayTotalMessage = "Your total is $";
        
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        double mochaPrice = 2.75;
        double dripCoffee = 3.23;
        double latte = 4.15;
        double cappucino = 5.99;

        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        System.out.println(generalGreeting + customer1 + (isReadyOrder1 ? readyMessage + displayTotalMessage + String.format("%.2f",dripCoffee) + ".\n" : pendingMessage));
        System.out.println(generalGreeting + customer4 + (isReadyOrder4 ? readyMessage + displayTotalMessage + String.format("%.2f",cappucino) + ".\n" : pendingMessage));
        System.out.println(generalGreeting + customer2 + (isReadyOrder2 ? readyMessage + displayTotalMessage + String.format("%.2f",(latte*2)) + ".\n" : pendingMessage));
        System.out.println(generalGreeting + customer3 + ". " + displayTotalMessage + String.format("%.2f",(latte - dripCoffee)) + ".\n");
    }
}
