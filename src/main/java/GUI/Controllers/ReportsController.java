package GUI.Controllers;

import BusinessLogic.IDeliveryServiceProcessing;
import GUI.Admin.Reports;
import GUI.Message;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReportsController {
    Reports view;
    IDeliveryServiceProcessing idsp;
    Message message;

    public ReportsController(Reports view,IDeliveryServiceProcessing idsp) {
        this.view = view;
        this.idsp = idsp;
        view.addGenerateListener(new generateListener());
    }

    class generateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(view.rapoarte.getSelectedItem().equals("Comenzile plasate intre orele date")) {
                try {
                    idsp.generateReports1(Integer.parseInt(view.textField1.getText()), Integer.parseInt(view.textField2.getText()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    message = new Message("Valori incorecte");
                }
            }
            if(view.rapoarte.getSelectedItem().equals("Produsele comandate de cel putin numarul dat de ori")) {
                try {
                    idsp.generateReports2(Integer.parseInt(view.textField1.getText()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    message = new Message("Valori incorecte");
                }
            }
            if(view.rapoarte.getSelectedItem().equals("Clientii care au plasat comenzi de minim numarul dat de ori")) {
                try {
                    idsp.generateReports3(Integer.parseInt(view.textField1.getText()), Integer.parseInt(view.textField2.getText()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    message = new Message("Valori incorecte");
                }
            }
            if(view.rapoarte.getSelectedItem().equals("Produsele comandate in data introdusa")) {
                try {
                    idsp.generateReports4(Integer.parseInt(view.textField1.getText()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    message = new Message("Valori incorecte");
                }
            }
        }
    }
}
