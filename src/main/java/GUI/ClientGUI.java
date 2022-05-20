package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    JPanel panel = new JPanel();
    public JList menu = new JList();
    public JTextField textField = new JTextField();
    String[] fieldsCB = {"Nume", "Rating", "Calorii", "Proteine", "Grasimi", "Sodiu", "Pret"};
    public JComboBox fields = new JComboBox(fieldsCB);
    JButton search = new JButton("Cauta produse");
    JButton order = new JButton("Comanda produsele");
    JScrollPane scroll;
    JLabel data = new JLabel("Nume, Rating, Calorii, Proteine, Grasimi, Sodiu, Pret");
    JButton back = new JButton("LogIn");

    public ClientGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocation(450, 150);
        this.setTitle("Client");

        panel.setLayout(null);
        panel.setBackground(new Color(166, 238, 238, 224));

        textField.setBounds(50, 30, 200, 30);
        textField.setFont(new Font("Serif", Font.ITALIC, 14));
        fields.setBounds(50, 90, 200, 30);
        fields.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 14));
        search.setBounds(325, 20, 200, 40);
        search.setBackground(new Color(234, 255, 255, 224));
        search.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 16));
        order.setBounds(325, 80, 200, 40);
        order.setBackground(new Color(234, 255, 255, 224));
        order.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 16));
        menu.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        menu.setModel(new DefaultListModel());
        scroll = new JScrollPane(menu);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(5, 160, 575, 295);
        data.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 12));
        data.setBounds(10, 100, 300, 100);
        back.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 11));
        back.setBounds(0, 0, 80, 20);
        back.setBackground(new Color(255, 155, 155, 219));

        panel.add(textField);
        panel.add(fields);
        panel.add(scroll);
        panel.add(data);
        panel.add(back);
        panel.add(search);
        panel.add(order);

        this.add(panel);
        this.setVisible(true);
    }

    public void addSearchListener(ActionListener searchListener) { search.addActionListener(searchListener); }
    public void addOrderListener(ActionListener orderListener) { order.addActionListener(orderListener); }
    public void addBackListener(ActionListener backListener) { back.addActionListener(backListener); }

}
