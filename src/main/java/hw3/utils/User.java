package hw3.utils;

public class User {
    private String userName;
    private String password;
    private String fullName;

    public void setUserName(String name) {
        userName = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String name) {
        fullName = name;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
}
