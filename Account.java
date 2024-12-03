public class Account extends Person {
    private String username;
    private String password;
    private Role role;
    private Status status;

    // Constructor không tham số
    public Account() {}

    // Constructor đầy đủ tham số
    public Account(String id, String fullName, int age, Address address, String birthday, 
                   String username, String password, Role role, Status status) {
        super(id, fullName, age, address, birthday);
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + ", Username: " + username + ", Role: " + role + ", Status: " + status;
    }
}
