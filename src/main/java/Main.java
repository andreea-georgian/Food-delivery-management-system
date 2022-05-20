import GUI.Controllers.LoginController;
import GUI.LogIn;

public class Main {
    public static void main(String args[]) {
        LogIn view = new LogIn();
        LoginController controller = new LoginController(view);
    }
}
