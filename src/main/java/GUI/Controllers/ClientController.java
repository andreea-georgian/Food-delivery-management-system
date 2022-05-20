package GUI.Controllers;

import BusinessLogic.DeliveryService;
import BusinessLogic.IDeliveryServiceProcessing;
import GUI.ClientGUI;
import GUI.LogIn;
import GUI.Message;
import Users.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientController {
    ClientGUI view;
    IDeliveryServiceProcessing idsp;
    LogIn loginView;
    Client client;
    Message message;

    public ClientController(ClientGUI view, IDeliveryServiceProcessing idsp, LogIn loginView, Client client) {
        this.view = view;
        this.idsp = idsp;
        this.loginView = loginView;
        this.client = client;
        view.addSearchListener(new searchListener());
        view.addOrderListener(new createListener());
        view.addBackListener(new backListener());
        DefaultListModel list = new DefaultListModel();
        String[] data = new String[8];
        if (((DeliveryService) idsp).getMenu() != null) {
            ((DeliveryService)idsp).getMenu().forEach((menuItem) -> {data[1] = menuItem.getTitle();
                data[2] = String.valueOf(menuItem.computeRating());
                data[3] = String.valueOf(menuItem.computeCalories());
                data[4] = String.valueOf(menuItem.computeProteins());
                data[5] = String.valueOf(menuItem.computeFats());
                data[6] = String.valueOf(menuItem.computeSodium());
                data[7] = String.valueOf(menuItem.computePrice());
                list.addElement(data[1] + " " + data[2]+ " " + data[3]+ " " + data[4]+ " " + data[5]+ " " + data[6]+ " " + data[7]);});
        }
        view.menu.setModel(list);
    }

    class searchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DefaultListModel list = idsp.searchProduct((String) view.fields.getSelectedItem(), view.textField.getText());
            view.menu.setModel(list);
        }
    }

    class createListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int[] index = view.menu.getSelectedIndices();
            try {
                idsp.createOrder(index, client);
                message = new Message("Comanda a fost creata cu succes!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class backListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            loginView.setVisible(true);
        }
    }
}
