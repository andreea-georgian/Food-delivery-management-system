package GUI.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Reports extends JFrame {
    JPanel panel = new JPanel();
    String[] rapoarteS = new String[]{"Comenzile plasate intre orele date", "Produsele comandate de cel putin numarul dat de ori",
                                        "Clientii care au plasat comenzi de minim numarul dat de ori", "Produsele comandate in data introdusa"};
    public JComboBox rapoarte = new JComboBox(rapoarteS);
    public JTextField textField1 = new JTextField();
    public JTextField textField2 = new JTextField();
    JButton generate = new JButton("Generare raport");

    public Reports() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rapoarte");
        this.setSize(400, 300);
        this.setLocation(570, 250);

        panel.setLayout(null);
        panel.setBackground(new Color(166, 238, 238, 224));

        textField1.setBounds(50, 50, 300, 30);
        textField2.setBounds(50, 80, 300, 30);
        rapoarte.setBounds(6, 130, 375, 30);
        generate.setBounds(90, 180, 200, 50);
        generate.setBackground(new Color(234, 255, 255, 224));
        generate.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));

        panel.add(textField1);
        panel.add(textField2);
        panel.add(rapoarte);
        panel.add(generate);
        this.add(panel);
        this.setVisible(true);
    }

    public void addGenerateListener(ActionListener generateListener) { generate.addActionListener(generateListener); }
}
