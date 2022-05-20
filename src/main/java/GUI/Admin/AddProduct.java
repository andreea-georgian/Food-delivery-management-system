package GUI.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddProduct extends JFrame {
    JPanel panel = new JPanel();
    JLabel title = new JLabel("Nume: ");
    JLabel rating = new JLabel("Rating: ");
    JLabel calories = new JLabel("Calorii: ");
    JLabel proteins = new JLabel("Proteine: ");
    JLabel fats = new JLabel("Grasimi: ");
    JLabel sodium = new JLabel("Sodiu: ");
    JLabel price = new JLabel("Pret: ");
    public JTextField titleTF = new JTextField();
    public JTextField ratingTF = new JTextField();
    public JTextField caloriesTF = new JTextField();
    public JTextField proteinsTF = new JTextField();
    public JTextField fatsTF = new JTextField();
    public JTextField sodiumTF = new JTextField();
    public JTextField priceTF = new JTextField();
    JButton adauga = new JButton("Adauga produs nou");

    public AddProduct() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 350);
        this.setLocation(550, 250);
        this.setTitle("Adaugare produs");

        panel.setBackground(new Color(166, 238, 238, 224));
        panel.setLayout(new GridLayout(8, 2));

        title.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        rating.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        calories.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        proteins.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        fats.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        sodium.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        price.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));

        adauga.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 16));
        adauga.setBackground(new Color(234, 255, 255, 224));

        panel.add(title);
        panel.add(titleTF);
        panel.add(rating);
        panel.add(ratingTF);
        panel.add(calories);
        panel.add(caloriesTF);
        panel.add(proteins);
        panel.add(proteinsTF);
        panel.add(fats);
        panel.add(fatsTF);
        panel.add(sodium);
        panel.add(sodiumTF);
        panel.add(price);
        panel.add(priceTF);
        panel.add(adauga);

        this.add(panel);
        this.setVisible(true);
    }

    public void addAdaugareListener(ActionListener adaugareListener) { adauga.addActionListener(adaugareListener); }

}
