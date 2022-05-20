package Users;

public class Admin extends User{
    public Admin(int id, String username, String password) {
        super(id, username, password, UsersTypes.ADMIN);
    }
}
