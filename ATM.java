import java.util.Scanner;

public class ATM {
    private static double balance = 0;
    private static int pin = 9218;
    private static int attemptsLeft = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = input.nextInt();

        while (attemptsLeft > 0) {
            System.out.print("Enter PIN (" + attemptsLeft + " attempts left): ");
            int enteredPin = input.nextInt();
            attemptsLeft--;

            if (enteredPin == pin) {
                System.out.println("Login successful.");
                break;
            } else {

                System.out.println("Invalid PIN.");
                if (attemptsLeft == 0) {
                    System.out.println("Maximum login attempts exceeded.");
                    return;
                }
            }
        }

        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    deposit(input);
                    break;
                case 2:
                    withdraw(input);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    changePin(input);
                    break;
                case 5:
                    System.out.println("thank you for using the ATM Simulator System.");
                    return;
                default:
                    System.out.println("invalid choice.");
                    break;
            }
        }
    }

    private static void deposit(Scanner input) {
        System.out.print("enter amount to deposit: ");
        double amount = input.nextDouble();
        balance += amount;
        System.out.println("deposit successful. Current balance is $" + balance);
    }

    private static void withdraw(Scanner input) {
        System.out.print("enter amount to withdraw: ");
        double amount = input.nextDouble();

        if (amount > balance) {
            System.out.println("insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("withdrawal successful. current balance is $" + balance);
        }
    }

    private static void checkBalance() {
        System.out.println("current balance is $" + balance);
    }

    private static void changePin(Scanner input) {
        System.out.print("enter new PIN: ");
        int newPin = input.nextInt();
        System.out.print("confirm new PIN: ");
        int confirmedPin = input.nextInt();

        if (newPin == confirmedPin) {
            pin = newPin;
            System.out.println("PIN change successful.");
        } else {
            System.out.println("PINs do not match. PIN change unsuccessful.");
        }
    }
}

