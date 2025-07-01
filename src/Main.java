import Bank.Account;
import Bank.CurrentAccount;
import Bank.FixedDeposit;
import Bank.SavingsAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Account");
            System.out.println("2. Debit");
            System.out.println("3. Credit");
            System.out.println("4. Transfer");
            System.out.println("5. Show Account Info");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Select Account Type:");
                System.out.println("1. Savings Account");
                System.out.println("2. Current Account");
                System.out.println("3. Fixed Deposit");
                System.out.print("Enter type: ");
                int type = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter account id: ");
                String id = scanner.nextLine();
                System.out.print("Enter account name: ");
                String name = scanner.nextLine();
                System.out.print("Set password: ");
                String password = scanner.nextLine();
                System.out.print("Enter initial balance: ");
                double initialBalance = scanner.nextDouble();
                scanner.nextLine();

                Account acc = null;
                if (type == 1) {
                    acc = new SavingsAccount(id, name, password, initialBalance);
                } else if (type == 2) {
                    acc = new CurrentAccount(id, name, password, initialBalance);
                } else if (type == 3) {
                    acc = new FixedDeposit(id, name, password, initialBalance);
                } else {
                    System.out.println("Invalid account type.");
                }

                if (acc != null) {
                    accounts.put(id, acc);
                    System.out.println("Account created.");
                }
            } else if (choice == 2) {
                System.out.print("Enter account id: ");
                String id = scanner.nextLine();
                Account acc = accounts.get(id);
                if (acc == null) {
                    System.out.println("Account does not exist.");
                } else {
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (!acc.checkPassword(password)) {
                        System.out.println("Incorrect password.");
                        continue;
                    }
                    System.out.print("Enter amount to debit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    acc.debit(amount);
                }
            } else if (choice == 3) {
                System.out.print("Enter account id: ");
                String id = scanner.nextLine();
                Account acc = accounts.get(id);
                if (acc == null) {
                    System.out.println("Account does not exist.");
                } else {
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (!acc.checkPassword(password)) {
                        System.out.println("Incorrect password.");
                        continue;
                    }
                    System.out.print("Enter amount to credit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    acc.credit(amount);
                }
            } else if (choice == 4) {
                System.out.print("Enter source account id: ");
                String fromId = scanner.nextLine();
                System.out.print("Enter destination account id: ");
                String toId = scanner.nextLine();
                Account from = accounts.get(fromId);
                Account to = accounts.get(toId);
                if (from == null || to == null) {
                    System.out.println("One or both accounts do not exist.");
                } else {
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (!from.checkPassword(password)) {
                        System.out.println("Incorrect password.");
                        continue;
                    }
                    System.out.print("Enter amount to transfer: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    from.transferTo(to, amount);
                }
            } else if (choice == 5) {
                System.out.print("Enter account id: ");
                String id = scanner.nextLine();
                Account acc = accounts.get(id);
                if (acc == null) {
                    System.out.println("Account does not exist.");
                } else {
                    System.out.println(acc);
                }
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option...");
            }
        }
    }
}
