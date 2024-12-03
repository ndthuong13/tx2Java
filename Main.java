import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthServiceImpl();
        AccountService accountService = new AccountServiceImpl();

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    authService.login(scanner);
                    Account loggedInAccount = authService.getLoggedInAccount();
                    if (loggedInAccount != null) {
                        if (loggedInAccount.getRole() == Role.ADMIN) {
                            adminMenu(scanner, accountService);
                        } else if (loggedInAccount.getRole() == Role.USER) {
                            userMenu(scanner);
                        }
                    }
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void adminMenu(Scanner scanner, AccountService accountService) {
        // Admin functions
    }

    private static void userMenu(Scanner scanner) {
        // User functions
    }
}
