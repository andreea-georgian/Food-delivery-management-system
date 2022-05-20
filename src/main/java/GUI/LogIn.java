package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {
    public JPanel panel = new JPanel();
    public JLabel username = new JLabel("Username: ");
    public JLabel parola = new JLabel("Parola: ");
    public JTextField usernameTF = new JTextField();
    public JTextField parolaTF = new JTextField();
    public JButton login = new JButton("LOGIN");
    public JButton register = new JButton("Creeaza un cont nou");

    public LogIn() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 350);
        this.setLocation(515, 240);

        panel.setBackground(new Color(166, 238, 238, 224));
        panel.setLayout(null);

        username.setBounds(35, 60, 125, 50);
        username.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        parola.setBounds(35, 110, 125, 50);
        parola.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));

        login.setBackground(new Color(234, 255, 255, 224));
        login.setBounds(250, 200, 100, 50);
        login.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));

        register.setBackground(new Color(234, 255, 255, 224));
        register.setBounds(20, 200, 200, 50);
        register.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));

        usernameTF.setBounds(150, 70, 220, 30);
        parolaTF.setBounds(150, 120, 220, 30);

        panel.add(username);
        panel.add(parola);
        panel.add(login);
        panel.add(register);
        panel.add(usernameTF);
        panel.add(parolaTF);

        this.add(panel);
        this.setVisible(true);
    }

    public void addLoginListener(ActionListener loginListener) { login.addActionListener(loginListener); }
    public void addRegisterListener (ActionListener registerListener) { register.addActionListener(registerListener); }
}
