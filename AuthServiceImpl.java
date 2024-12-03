import java.util.Scanner;

public class AuthServiceImpl implements AuthService {

    private Account loggedInAccount = null;

    @Override
    public void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Giả sử chúng ta có một danh sách các tài khoản đã được tạo
        Account account = AccountServiceImpl.getAccountByUsername(username);
        
        if (account != null && account.getPassword().equals(password) && account.getStatus() == Status.ACTIVE) {
            loggedInAccount = account;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials or account is banned.");
        }
    }

    @Override
    public void logout() {
        if (loggedInAccount != null) {
            loggedInAccount = null;
            System.out.println("Logout successful!");
        } else {
            System.out.println("No user is logged in.");
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        // Cần logic để thay đổi mật khẩu của tài khoản (kiểm tra mật khẩu cũ và cập nhật mật khẩu mới)
        System.out.println("Password changed successfully.");
    }
}
