package GUI.Controllers;

import BusinessLogic.DeliveryService;
import BusinessLogic.IDeliveryServiceProcessing;
import GUI.Admin.Administrator;
import GUI.ClientGUI;
import GUI.EmployeeGui;
import GUI.LogIn;
import GUI.Message;
import Users.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    LogIn view;
    List<User> users = new ArrayList<>();
    Message message;
    IDeliveryServiceProcessing idsp;

    public LoginController(LogIn view) {
        User u = new Admin(1, "admin1", "admin1");
        users.add(u);
        u = new Client(2, "user1", "user1");
        users.add(u);
        u = new Employee(3, "emp1", "emp1");
        users.add(u);
        this.view = view;
        idsp = new DeliveryService();
        view.addLoginListener(new loginListener());
        view.addRegisterListener(new registerListener());
    }

    boolean validsCredentials(String username, String password) {
        for (User u : users)
            if (u.getUsername().equals(username) && u.getPassword().equals(password))
                return true;
        return false;
    }

    class loginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.usernameTF.getText();
            String password = view.parolaTF.getText();
            if (validsCredentials(username, password)) {
                view.dispose();
                for (User u : users)
                    if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                        if (u.getRole() == UsersTypes.ADMIN) {
                            Administrator admView = new Administrator();
                            AdminController controller = new AdminController(admView, idsp, view);
                        }
                        if (u.getRole() == UsersTypes.CLIENT) {
                            ClientGUI clientView = new ClientGUI();
                            ClientController controller = new ClientController(clientView, idsp, view, (Client) u);
                        }
                        if (u.getRole() == UsersTypes.EMPLOYEE) {
                            EmployeeGui empView = new EmployeeGui();
                        }
                    }
            }
            else
                message = new Message("Username-ul sau parola sunt gresite!");
        }
    }

    class registerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean ok = true;
            String username = view.usernameTF.getText();
            String password = view.parolaTF.getText();
            for (User u : users)
                if (u.getUsername().equals(username)) {
                    message = new Message("Acest username exista deja!");
                    ok = false;
                }
            if (ok) {
                User newClient = new Client(users.size() + 1, username, password);
                users.add(newClient);
                message = new Message("Contul a fost creat cu succes!");
            }
        }
    }
}
