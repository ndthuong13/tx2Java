import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo các dịch vụ
        AuthService authService = new AuthServiceImpl();
        AccountService accountService = new AccountServiceImpl();

        // Menu chính
        while (true) {
            System.out.println("------ Main Menu ------");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc newline sau khi nhập số

            switch (choice) {
                case 1:
                    authService.login(scanner);
                    Account loggedInAccount = authService.getLoggedInAccount();

                    if (loggedInAccount != null) {
                        // Kiểm tra Role để hiển thị menu tương ứng
                        if (loggedInAccount.getRole() == Role.ADMIN) {
                            adminMenu(scanner, accountService, loggedInAccount);
                        } else if (loggedInAccount.getRole() == Role.USER) {
                            userMenu(scanner, loggedInAccount);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Menu cho ADMIN
    private static void adminMenu(Scanner scanner, AccountService accountService, Account loggedInAccount) {
        while (true) {
            System.out.println("\n------ Admin Menu ------");
            System.out.println("1. View all accounts");
            System.out.println("2. Create new account");
            System.out.println("3. Search account by username");
            System.out.println("4. Delete account");
            System.out.println("5. Change account status");
            System.out.println("6. View personal information");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc newline

            switch (choice) {
                case 1:
                    System.out.println("------ All Accounts ------");
                    for (Account account : accountService.getAllAccount()) {
                        System.out.println(account);
                    }
                    break;
                case 2:
                    System.out.print("Enter new account's username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter new account's password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Đọc newline
                    System.out.print("Enter birthday (yyyy-MM-dd): ");
                    String birthday = scanner.nextLine();
                    System.out.print("Enter street: ");
                    String street = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();

                    Address address = new Address(street, city);
                    Account newAccount = new Account("auto-generated-id", fullName, age, address, birthday, username, password, Role.USER, Status.ACTIVE);
                    accountService.createNewAccount(newAccount);
                    break;
                case 3:
                    System.out.print("Enter username to search: ");
                    String searchUsername = scanner.nextLine();
                    Account account = accountService.getAccountByUsername(searchUsername);
                    if (account != null) {
                        System.out.println(account);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter username to delete: ");
                    String deleteUsername = scanner.nextLine();
                    accountService.deleteAccount(deleteUsername);
                    break;
                case 5:
                    System.out.print("Enter username to change status: ");
                    String usernameToChangeStatus = scanner.nextLine();
                    System.out.print("Enter new status (ACTIVE/BAN): ");
                    String statusStr = scanner.nextLine();
                    Status newStatus = Status.valueOf(statusStr.toUpperCase());
                    accountService.changeStatus(usernameToChangeStatus, newStatus);
                    break;
                case 6:
                    System.out.println("\nPersonal Information of " + loggedInAccount.getFullName());
                    System.out.println(loggedInAccount);
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return; // Quay lại menu chính
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Menu cho USER
    private static void userMenu(Scanner scanner, Account loggedInAccount) {
        while (true) {
            System.out.println("\n------ User Menu ------");
            System.out.println("1. Change password");
            System.out.println("2. View personal information");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc newline

            switch (choice) {
                case 1:
                    System.out.print("Enter old password: ");
                    String oldPassword = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    // Thực hiện thay đổi mật khẩu
                    System.out.println("Password changed successfully.");
                    break;
                case 2:
                    System.out.println("\nPersonal Information of " + loggedInAccount.getFullName());
                    System.out.println(loggedInAccount);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return; // Quay lại menu chính
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
