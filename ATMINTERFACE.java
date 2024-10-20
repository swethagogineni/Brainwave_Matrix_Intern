import java.util.ArrayList;
import java.util.Scanner;

public class ATMINTERFACE {
    static ArrayList<String> users = new ArrayList<>();
    static ArrayList<String> mails = new ArrayList<>();
    static ArrayList<String> phoneNumbers = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();
    static ArrayList<Integer> balances = new ArrayList<>();

    // Initial Data (Same as in your Python code)
    static {
        users.add("a");
        users.add("b");
        users.add("c");
        users.add("d");
        mails.add("a@gmail.com");
        mails.add("b@gmail.com");
        mails.add("c@gmail.com");
        mails.add("d@gmail.com");
        phoneNumbers.add("9848485773");
        phoneNumbers.add("3859274644");
        phoneNumbers.add("2937593758");
        phoneNumbers.add("9346226370");
        passwords.add("123");
        passwords.add("456");
        passwords.add("789");
        passwords.add("101");
        balances.add(100);
        balances.add(200);
        balances.add(300);
        balances.add(400);
    }

    // Signup Method
    public static void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter confirm password: ");
        String confirmPassword = sc.nextLine();
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }
        System.out.print("Enter mail id: ");
        String mail = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter deposit amount: ");
        int amount = sc.nextInt();

        users.add(name);
        mails.add(mail);
        phoneNumbers.add(phoneNumber);
        passwords.add(password);
        balances.add(amount);

        System.out.println("Signup successful!");
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to login or signup? ");
            String choice = sc.nextLine().toLowerCase();

            if (choice.equals("login")) {
                System.out.print("Enter your username: ");
                String username = sc.nextLine();
                
                if (users.contains(username)) {
                    int i = users.indexOf(username);
                    System.out.print("Enter your password: ");
                    String password = sc.nextLine();
                    
                    if (password.equals(passwords.get(i))) {
                        System.out.println("Login successful!");

                        // Banking operations
                        while (true) {
                            System.out.println("Enter your choice: 1) Withdraw 2) Deposit 3) Check Balance 4) Logout");
                            int ch = sc.nextInt();

                            switch (ch) {
                                case 1:
                                    System.out.println("Withdraw");
                                    System.out.print("Enter how much amount you want to withdraw: ");
                                    int withdrawAmount = sc.nextInt();
                                    if (withdrawAmount > balances.get(i)) {
                                        System.out.println("You don't have enough balance in your account.");
                                    } else {
                                        balances.set(i, balances.get(i) - withdrawAmount);
                                        System.out.println("Withdrawal successful! Remaining balance: " + balances.get(i));
                                    }
                                    break;

                                case 2:
                                    System.out.println("Deposit");
                                    System.out.print("Enter how much you want to deposit: ");
                                    int depositAmount = sc.nextInt();
                                    balances.set(i, balances.get(i) + depositAmount);
                                    System.out.println("Deposit successful! New balance: " + balances.get(i));
                                    break;

                                case 3:
                                    System.out.println("Check Balance");
                                    System.out.println("Your balance is: " + balances.get(i));
                                    break;

                                case 4:
                                    System.out.println("Logging out...");
                                    sc.nextLine(); // Consume newline
                                    break;

                                default:
                                    System.out.println("Choose a valid option.");
                            }

                            if (ch == 4) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Invalid password.");
                    }
                } else {
                    System.out.println("User not found.");
                }
            } else if (choice.equals("signup")) {
                signup();
            } else {
                System.out.println("Please choose a valid option (login/signup).");
            }
        }
    }
}
