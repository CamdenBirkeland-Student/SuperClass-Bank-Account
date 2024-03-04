public class CheckingAccount extends BankAccount {
    // Additional attribute
    private double interestRate;

    // Constructor
    public CheckingAccount() {
        super(); // Call superclass constructor
    }

    // Setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Method to process withdrawal with overdraft fee
    @Override
    public void withdrawal(double amount) {
        double overdraftFee = 30.0;
        if (getBalance() >= amount) {
            // Sufficient balance, perform withdrawal
            super.withdrawal(amount);
        } else if ((getBalance() - amount) >= -overdraftFee) {
            // Overdraft with overdraft fee
            super.withdrawal(amount + overdraftFee);
            System.out.println("Overdraft fee charged: $30");
            System.out.println("Negative balance including fee: $" + (getBalance() - amount));
        } else {
            // Insufficient funds including overdraft fee
            System.out.println("Insufficient funds (including overdraft fee)!");
        }
    }

    // Method to display account information including interest rate
    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate);
    }
}
