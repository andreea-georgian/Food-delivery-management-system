package GUI.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Administrator extends JFrame {
    JPanel panel = new JPanel();
    public JList menu = new JList();
    public JTextField textField = new JTextField();
    String[] fieldsCB = {"Nume", "Rating", "Calorii", "Proteine", "Grasimi", "Sodiu", "Pret"};
    public JComboBox fields = new JComboBox(fieldsCB);
    JButton importare = new JButton("Importa produse");
    JButton addd = new JButton("Adauga un produs nou");
    JButton delete = new JButton("Sterge produs");
    JButton modify = new JButton("Modifica produs");
    JButton create = new JButton("Creeaza un produs nou");
    JButton generate = new JButton("Generare rapoarte");
    JScrollPane scroll;
    JLabel data = new JLabel("Nume, Rating, Calorii, Proteine, Grasimi, Sodiu, Pret");
    JButton back = new JButton("LogIn");

    public Administrator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocation(450, 150);
        this.setTitle("Administrator");

        panel.setLayout(null);
        panel.setBackground(new Color(166, 238, 238, 224));

        textField.setBounds(20, 30, 200, 30);
        textField.setFont(new Font("Serif", Font.ITALIC, 14));
        fields.setBounds(20, 90, 200, 30);
        fields.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 14));
        importare.setBounds(240, 20, 150, 30);
        importare.setBackground(new Color(234, 255, 255, 224));
        importare.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 14));
        addd.setBounds(240, 60, 150, 30);
        addd.setBackground(new Color(234, 255, 255, 224));
        addd.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 12));
        delete.setBounds(240, 100, 150, 30);
        delete.setBackground(new Color(234, 255, 255, 224));
        delete.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 14));
        modify.setBounds(410, 20, 150, 30);
        modify.setBackground(new Color(234, 255, 255, 224));
        modify.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 14));
        create.setBounds(410, 60, 150, 30);
        create.setBackground(new Color(234, 255, 255, 224));
        create.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 11));
        generate.setBounds(410, 100, 150, 30);
        generate.setBackground(new Color(234, 255, 255, 224));
        generate.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 14));
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
        panel.add(importare);
        panel.add(addd);
        panel.add(delete);
        panel.add(modify);
        panel.add(create);
        panel.add(generate);
        panel.add(scroll);
        panel.add(data);
        panel.add(back);

        this.add(panel);
        this.setVisible(true);
    }

    public void addAddListener(ActionListener addListener) { addd.addActionListener(addListener); }
    public void addDeleteListener(ActionListener deleteListener) { delete.addActionListener(deleteListener); }
    public void addModifyListener(ActionListener modifyListener) { modify.addActionListener(modifyListener); }
    public void addCreateListener(ActionListener createListener) { create.addActionListener(createListener); }
    public void addImportListener(ActionListener importareListener) { importare.addActionListener(importareListener); }
    public void addGenerateListener(ActionListener generateListener) { generate.addActionListener(generateListener); }
    public void addBackListener(ActionListener backListener) { back.addActionListener(backListener); }

}
