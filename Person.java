public class Person {
    private String id;
    private String fullName;
    private int age;
    private Address address;
    private String birthday;

    // Constructor không tham số
    public Person() {}

    // Constructor đầy đủ tham số
    public Person(String id, String fullName, int age, Address address, String birthday) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    // toString method
    @Override
    public String toString() {
        return "ID: " + id + ", Full Name: " + fullName + ", Age: " + age + ", Address: " + address + ", Birthday: " + birthday;
    }
}
