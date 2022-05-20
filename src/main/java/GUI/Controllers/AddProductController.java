package GUI.Controllers;

import BusinessLogic.BaseProduct;
import BusinessLogic.IDeliveryServiceProcessing;
import BusinessLogic.MenuItem;
import GUI.Admin.AddProduct;
import GUI.Admin.Administrator;
import GUI.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductController {
    AddProduct view;
    Administrator viewAdmin;
    IDeliveryServiceProcessing idsp;
    Message message;

    public AddProductController(AddProduct view, IDeliveryServiceProcessing idsp, Administrator viewAdmin) {
        this.view = view;
        this.idsp = idsp;
        this.viewAdmin = viewAdmin;
        view.addAdaugareListener(new adaugareListener());
    }

    class adaugareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String title;
            int calories, proteins, fats, sodium;
            float rating, price;
            if (!view.titleTF.getText().equals("") && !view.ratingTF.getText().equals("") && !view.caloriesTF.getText().equals("") && !view.proteinsTF.getText().equals("") && !view.fatsTF.getText().equals("") && !view.sodiumTF.getText().equals("") && !view.priceTF.getText().equals("")) {
                title = view.titleTF.getText();
                try {
                    rating = Float.parseFloat(view.ratingTF.getText());
                    calories = Integer.parseInt(view.caloriesTF.getText());
                    proteins = Integer.parseInt(view.caloriesTF.getText());
                    fats = Integer.parseInt(view.fatsTF.getText());
                    sodium = Integer.parseInt(view.sodiumTF.getText());
                    price = Float.parseFloat(view.priceTF.getText());
                    MenuItem newMI = new BaseProduct(title, rating, calories, proteins, fats, sodium, price);
                    idsp.addProduct(newMI);
                    DefaultListModel list = (DefaultListModel) viewAdmin.menu.getModel();
                    list.addElement(newMI.getTitle() + " " + newMI.computeRating() + " " + newMI.computeCalories() + " " + newMI.computeProteins() + " " + newMI.computeFats() + " " + newMI.computeSodium() + " " + newMI.computePrice());
                    message = new Message("Produsul a fost adaugat cu succes!");
                } catch (NumberFormatException nfe){
                    message = new Message("Valori incorecte!");
                }
            }
            else
                message = new Message("Nicio valoare nu poate fi nula!");
        }
    }
}
