package Users;

public class Client extends User{
    public Client(int id, String username, String password) {
        super(id, username, password, UsersTypes.CLIENT);
    }
}
