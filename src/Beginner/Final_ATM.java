package Beginner;
import java.util.Scanner;

public class Final_ATM {

    // Variables to store balance
    private double balance;

    // Constructor to initialize balance
    public Final_ATM() {
        this.balance = 10000;
    }

    // Method to display the menu
    private void showMenu() {
        System.out.println("\n===== ATM Menu =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to check balance
    private void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", balance);
    }

    // Method to deposit money
    private void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully!%n", amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }    

    // Method to withdraw money
    private void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully!%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

	public static void main(String[] args) {
			// Main method to run the ATM system
			
			       Final_ATM atm = new Final_ATM();
			        Scanner scanner = new Scanner(System.in);

			        while (true) {
			            atm.showMenu();
			            int choice = scanner.nextInt();

			            switch (choice) {
			                case 1:
			                    atm.checkBalance();
			                    break;
			                case 2:
			                    atm.depositMoney(scanner);
			                    break;
			                case 3:
			                    atm.withdrawMoney(scanner);
			                    break;
			                case 4:
			                    System.out.println("Thank you for using the ATM. Goodbye!");
			                    scanner.close();
			                    return;
			                default:
			                    System.out.println("Invalid choice! Please try again.");
			            }
			        }
			    }
}


