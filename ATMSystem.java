import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
        return false;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you for using our service!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void handleCheckBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
}

// Main class to run the ATM system
public class ATMSystem {
    public static void main(String[] args) {
        // Initialize user's bank account with a starting balance
        BankAccount userAccount = new BankAccount(500.00);  // Initial balance of $500
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
