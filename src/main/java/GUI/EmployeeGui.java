package GUI;

import javax.swing.*;
import java.awt.*;

public class EmployeeGui extends JFrame implements Observer {
    JPanel panel = new JPanel();
    JLabel label = new JLabel();

    public void update(int n) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350, 100);
        this.setTitle("Employee");
        panel.setLayout(null);

        label.setBounds(0, 0, 350, 100);
        panel.setBackground(new Color(166, 238, 238, 224));
        label.setText("Comanda cu numarul " + n + " a fost creata!");
        label.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 16));

        panel.add(label);
        this.add(panel);
        this.setVisible(true);
    }
}
