import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApplication extends JFrame {
    private JTextField balanceField;
    private JTextField depositField;
    private JTextField withdrawField;

    private BankAccount bankAccount;

    public BankBalanceApplication() {
        setTitle("Bank Balance Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JPanel panel = new JPanel();
        JLabel balanceLabel = new JLabel("Current Balance:");
        balanceField = new JTextField(10);
        JButton showBalanceButton = new JButton("Show Balance");
        JLabel depositLabel = new JLabel("Deposit Amount:");
        depositField = new JTextField(10);
        JButton depositButton = new JButton("Deposit");
        JLabel withdrawLabel = new JLabel("Withdraw Amount:");
        withdrawField = new JTextField(10);
        JButton withdrawButton = new JButton("Withdraw");

        // Add components to panel
        panel.add(balanceLabel);
        panel.add(balanceField);
        panel.add(showBalanceButton);
        panel.add(depositLabel);
        panel.add(depositField);
        panel.add(depositButton);
        panel.add(withdrawLabel);
        panel.add(withdrawField);
        panel.add(withdrawButton);

        // Add panel to frame
        add(panel);

        // Initialize BankAccount
        bankAccount = new BankAccount();

        // Add action listeners
        showBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                balanceField.setText(String.valueOf(bankAccount.getBalance()));
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(depositField.getText());
                bankAccount.deposit(amount);
                balanceField.setText(String.valueOf(bankAccount.getBalance()));
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(withdrawField.getText());
                double previousBalance = bankAccount.getBalance();
                bankAccount.withdrawal(amount);
                double newBalance = bankAccount.getBalance();
                
                if (newBalance < previousBalance) {
                    double overdraftFee = previousBalance - newBalance;
                    JOptionPane.showMessageDialog(null, "Withdrawal amount exceeds balance.\nOverdraft fee charged: $" + overdraftFee + "\nNew Balance: $" + newBalance);
                } else {
                    balanceField.setText(String.valueOf(newBalance));
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankBalanceApplication().setVisible(true);
            }
        });
    }
}