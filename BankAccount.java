public class BankAccount {
    // Fields
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor
    public BankAccount() {
        balance = 0.0; // Initialize balance to zero
    }

    // Setters and Getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Methods
    public void deposit(double amount) {
        balance += amount; // Add amount to balance
    }

    public void withdrawal(double amount) {
        if (balance >= amount) {
            balance -= amount; // Subtract amount from balance if sufficient funds
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void accountSummary() {
        System.out.println("Account Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + balance);
    }
}
