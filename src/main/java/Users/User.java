package Users;

public abstract class User {
    int id;
    String username;
    String password;
    UsersTypes role;

    public User(int id, String username, String password, UsersTypes role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UsersTypes getRole() {
        return role;
    }

    public void setRole(UsersTypes role) {
        this.role = role;
    }
}
