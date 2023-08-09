import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BankAccount account = createAccount();

        while (true) {
            displayMenu();
            getOperation(account);
        }
    }

    private static BankAccount createAccount() {
        return new BankAccount("123456789", "Anna Karenina", 1000);
    }

    private static void displayMenu() {
        System.out.println("""
            
            Please enter the number of operations you want to perform:
            1. Check balance
            2. Deposit
            3. Withdraw
            4. Calculate interest
            5. Exit""");
    }

    private static void getOperation(BankAccount account) {
        int operation = scanner.nextInt();
        switch (operation) {
            case 1 -> checkBalance(account);
            case 2 -> deposit(account);
            case 3 -> withdraw(account);
            case 4 -> calculateInterest(account);
            case 5 -> System.exit(0);
            default -> System.out.println("Invalid operation. Please try again.");
        }
    }

    private static void checkBalance(BankAccount account) {
        System.out.printf("Your balance is: %d\n", account.getBalance());
    }

    private static void deposit(BankAccount account) {
        System.out.println("Please enter the amount you want to deposit:");
        int amount = scanner.nextInt();
        account.setBalance(account.getBalance() + amount);
        System.out.printf("Your balance is: %d\n", account.getBalance());
    }

    private static void withdraw(BankAccount account) {
        System.out.println("Please enter the amount you want to withdraw:");
        int amount = scanner.nextInt();
        if (amount > account.getBalance()) {
            System.out.println("You don't have enough money in your account.");
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.printf("Your balance is: %d\n", account.getBalance());
        }
    }

    private static void calculateInterest(BankAccount account) {
        System.out.println("Please enter the period in months:");
        double periodInMonths = Double.parseDouble(scanner.next());
        double interest = account.getBalance() * (account.getInterestRate() / 100) * (periodInMonths / 12);
        System.out.printf("Your interest is: %.2f\n", interest);
    }
}