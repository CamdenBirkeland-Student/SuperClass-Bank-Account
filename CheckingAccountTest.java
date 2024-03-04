public class CheckingAccountTest {
    public static void main(String[] args) {
        // Creating CheckingAccount object
        CheckingAccount checkingAccount = new CheckingAccount();

        // Setting account information
        checkingAccount.setFirstName("Camden");
        checkingAccount.setLastName("Birkeland");
        checkingAccount.setAccountID(1001);
        checkingAccount.setInterestRate(0.5); // Example interest rate

        // Depositing and withdrawing from account
        checkingAccount.deposit(1000);
        checkingAccount.withdrawal(1020); // Attempting to withdraw more than balance

        // Displaying account information
        checkingAccount.displayAccount();
    }
}
