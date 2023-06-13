import java.lang.Math;

public class BankAccount {
    private static int totalAccounts = 0;
    private static double totalAccountsBalance = 0d;

    private String accountNumber;
    private double checkingTotal;
    private double savingsTotal;

    public BankAccount() {
        this(0, 0);
    }
    
    public BankAccount(double checkingTotal, double savingsTotal) {
        this.accountNumber = accountNumberGenerator();
        this.checkingTotal = checkingTotal;
        this.savingsTotal = savingsTotal;
        totalAccounts++;
        totalAccountsBalance += (savingsTotal + checkingTotal);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static double getTotalAccountsBalance() {
        return totalAccountsBalance;
    }

    private String accountNumberGenerator() {
        String accountNumber = "";
        for (int i = 0; i < 10; i++){
            accountNumber += Integer.toString((int)(Math.random()*9)+1);
        }
        return accountNumber;
    }
    
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getCheckingTotal() {
        return this.checkingTotal;
    }

    public double getSavingsTotal() {
        return this.savingsTotal;
    }

    public BankAccount deposit(String accountType, double amount) {
        if (amount <= 0) {
            System.out.println("Deposit must be greater than $0.00\n");
            return this;
        }
        boolean isValidAccountType = true;
        switch (accountType.toLowerCase()) {
            case "checking" :
                this.checkingTotal += amount;
                break;
            case "savings" :
                this.savingsTotal += amount;
            default:
                System.out.println("Invalid account type.");
                isValidAccountType = false;
                break;
        }
        if (isValidAccountType) {
            totalAccountsBalance += amount;
        }
        return this;
    }

    public BankAccount withdrawl(String accountType, double amount) {
        boolean isValidAccountType = false;
        switch (accountType.toLowerCase()) {
            case "checking" :
                if (this.checkingTotal >= amount){
                    this.checkingTotal += amount;
                    isValidAccountType = true;
                } else {
                    System.out.println("Insufficent funds\n");
                }
                break;
            case "savings" :
                if (this.savingsTotal >= amount){
                    this.savingsTotal += amount;
                    isValidAccountType = true;
                } else {
                    System.out.println("Insuffient funds\n");
                }
                break;
            default:
                System.out.println("Invalid account type.");
                break;
        }
        if (isValidAccountType) {
            totalAccountsBalance -= amount;
        }
        return this;
    }

    public BankAccount displayBalances() {
        System.out.printf("Your account number is : %s\n", this.accountNumber);
        System.out.printf("Your total checking account balance is : $%.2f\n", this.checkingTotal);
        System.out.printf("Your total savings account balance is : $%.2f\n\n", this.savingsTotal);
        return this;
    }

}