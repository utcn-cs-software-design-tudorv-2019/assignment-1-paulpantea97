package model;

public class User {
    private String username;
    private String password;
    private Boolean is_admin;
    public User() {
        this.username=null;
        this.password=null;
        this.is_admin=null;
    }
    public User(String username,String password,Boolean is_admin)
    {
        this.username=username;
        this.password=password;
        this.is_admin=is_admin;
    }
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
    public Boolean getIs_admin() {
        return is_admin;
    }
    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }
    @Override
    public String toString() {
        return "User ("+username +","+ password+","+ is_admin+")\n";
    }
}
