package codsoft.atm;
import java.util.Scanner;


public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice) {
        @SuppressWarnings("resource")
         Scanner scanner = new Scanner(System.in);
            switch (choice) {
            case 1:
                System.out.println("Your balance is: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter the amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                boolean success = bankAccount.withdraw(withdrawAmount);
                if (success) {
                    System.out.println("Withdrawal successful. Remaining balance: $" + bankAccount.getBalance());
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
            case 3:
                System.out.print("Enter the amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: $" + bankAccount.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
    BankAccount bankAccount = new BankAccount(1000.0);
    ATM atm = new ATM(bankAccount);

    try (Scanner scanner = new Scanner(System.in)) {
        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.performTransaction(choice);
        }
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}
}
