package GUI.Controllers;

import BusinessLogic.DeliveryService;
import BusinessLogic.IDeliveryServiceProcessing;
import BusinessLogic.MenuItem;
import GUI.Admin.AddProduct;
import GUI.Admin.Administrator;
import GUI.Admin.Reports;
import GUI.LogIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AdminController {
    Administrator view;
    IDeliveryServiceProcessing idsp;
    LogIn loginView;

    public AdminController(Administrator view, IDeliveryServiceProcessing idsp, LogIn loginView) {
        this.view = view;
        this.idsp = idsp;
        this.loginView = loginView;
        view.addImportListener(new importListener());
        view.addDeleteListener(new deleteListener());
        view.addModifyListener(new modifyListener());
        view.addCreateListener(new createListener());
        view.addGenerateListener(new generateListener());
        view.addAddListener(new adddListener());
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

    class importListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            idsp.importProducts();
            DefaultListModel list = new DefaultListModel();
            String[] data = new String[8];
            ((DeliveryService)idsp).getMenu().forEach((menuItem) -> {data[1] = menuItem.getTitle();
                                                                    data[2] = String.valueOf(menuItem.computeRating());
                                                                    data[3] = String.valueOf(menuItem.computeCalories());
                                                                    data[4] = String.valueOf(menuItem.computeProteins());
                                                                    data[5] = String.valueOf(menuItem.computeFats());
                                                                    data[6] = String.valueOf(menuItem.computeSodium());
                                                                    data[7] = String.valueOf(menuItem.computePrice());
                                                                    list.addElement(data[1] + " " + data[2]+ " " + data[3]+ " " + data[4]+ " " + data[5]+ " " + data[6]+ " " + data[7]);
                                                                     });
            view.menu.setModel(list);
        }
    }

    class deleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int[] selectedValues = view.menu.getSelectedIndices();
            Arrays.stream(selectedValues).forEach(s -> {
                DefaultListModel list = (DefaultListModel) view.menu.getModel();
                list.remove(s);
                idsp.deleteProduct(s);
            });
        }
    }

    class modifyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int[] selectedValues = view.menu.getSelectedIndices();
            Arrays.stream(selectedValues).forEach(s -> {
                DefaultListModel list = (DefaultListModel) view.menu.getModel();
                idsp.modifyProduct((String) view.fields.getSelectedItem(), s, view.textField.getText());
                MenuItem mi = ((DeliveryService) idsp).getMenu().get(s);
                list.setElementAt(mi.getTitle() + " " + mi.getRating() + " " + mi.getCalories() + " " + mi.getProteins() + " " + mi.getFats() + " " + mi.getSodium() + " " + mi.getPrice(), s);
            });
        }
    }

    class createListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MenuItem newMI = idsp.createProduct(view.textField.getText(), view.menu.getSelectedIndices());
            DefaultListModel list = (DefaultListModel) view.menu.getModel();
            list.addElement(newMI.getTitle() + " " + newMI.computeRating() + " " + newMI.computeCalories() + " " + newMI.computeProteins() + " " + newMI.computeFats() + " " + newMI.computeSodium() + " " + newMI.computePrice());
        }
    }

    class generateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Reports reportsView = new Reports();
            ReportsController reportsController = new ReportsController(reportsView, idsp);
        }
    }

    class adddListener implements  ActionListener {
        public void actionPerformed(ActionEvent e) {
            AddProduct addView = new AddProduct();
            AddProductController addController = new AddProductController(addView, idsp, view);
        }
    }

    class backListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            loginView.setVisible(true);
        }
    }
}
