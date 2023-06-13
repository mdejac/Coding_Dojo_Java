public class TestBankAccount {
    public static void main(String args[]) {
        System.out.println("Account total should show 0 : " + BankAccount.getTotalAccounts());
        System.out.printf("Account total balance should show 0 : $%.2f\n\n", BankAccount.getTotalAccountsBalance());
        BankAccount account1 = new BankAccount(100.00, 50.00);
        BankAccount account2 = new BankAccount(1000.00, 5000.00);
        BankAccount account3 = new BankAccount(1500.00, 500.00);
        BankAccount account4 = new BankAccount(1200.00, 24050.00);
        System.out.println("Account total should show 4 : " + BankAccount.getTotalAccounts());
        System.out.printf("Account total balance should show $33400.00 : $%.2f\n\n", BankAccount.getTotalAccountsBalance());

        account1.displayBalances();
        account2.displayBalances();
        account3.displayBalances();
        account4.displayBalances();

        account1.deposit("checking", 1.99).displayBalances().withdrawl("Savings", 100.00).displayBalances();
        System.out.printf("Account total balance should show $33401.99 : $%.2f\n\n", BankAccount.getTotalAccountsBalance());

        System.out.printf("Account1 account number : %s\n", account1.getAccountNumber());
        System.out.printf("Account1 checking balance : $%.2f\n", account1.getCheckingTotal());
        System.out.printf("Account1 savings balance : $%.2f\n\n", account1.getSavingsTotal());

        account2.deposit("CHECKING", 0).deposit("savings", 50).displayBalances().withdrawl("savings", 50).displayBalances();

        BankAccount account5 = new BankAccount();
        System.out.println("Account total should show 5 : " + BankAccount.getTotalAccounts());
        System.out.printf("Account total balance should show $33401.99 : $%.2f\n", BankAccount.getTotalAccountsBalance());

    }
}