import java.util.Scanner;

public class ATMSimulatorSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static double balance = 1000.0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the ATM Simulator System!");
            System.out.println("Please select an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    balanceInquiry();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM Simulator System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.");
            return;
        }

        balance -= amount;
        System.out.printf("Withdrawal of $%.2f successful. New balance is $%.2f.\n", amount, balance);
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
            return;
        }

        balance += amount;
        System.out.printf("Deposit of $%.2f successful. New balance is $%.2f.\n", amount, balance);
    }

    private static void balanceInquiry() {
        System.out.printf("Current balance is $%.2f.\n", balance);
    }
}
