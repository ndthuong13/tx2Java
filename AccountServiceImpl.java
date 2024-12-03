import java.util.List;
import java.util.ArrayList;

public class AccountServiceImpl implements AccountService {

    private static List<Account> accounts = new ArrayList<>();

    static {
        // Tạo một số tài khoản mẫu
        accounts.add(new Account("1", "John Doe", 30, new Address("123 Street", "City"), "1990-01-01", "john_doe", "password123", Role.ADMIN, Status.ACTIVE));
        accounts.add(new Account("2", "Jane Doe", 25, new Address("456 Avenue", "Town"), "1995-02-02", "jane_doe", "password456", Role.USER, Status.ACTIVE));
    }

    @Override
    public List<Account> getAllAccount() {
        return accounts;
    }

    @Override
    public void createNewAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    @Override
    public Account getAccountByUsername(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void deleteAccount(String username) {
        Account account = getAccountByUsername(username);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void changeStatus(String username, Status status) {
        Account account = getAccountByUsername(username);
        if (account != null) {
            account.setStatus(status);
            System.out.println("Account status changed successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
}
