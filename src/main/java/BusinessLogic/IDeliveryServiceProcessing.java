package BusinessLogic;

import Users.Client;

import javax.swing.*;
import java.io.IOException;

public interface IDeliveryServiceProcessing {
    void importProducts();
    void addProduct(MenuItem baseProduct);
    void deleteProduct(int index);
    void modifyProduct(String modifyBy, int index, String modifiedValue);
    MenuItem createProduct(String title, int[] index);
    void generateReports1(int d1, int d2) throws IOException;
    void generateReports2(int n) throws IOException;
    void generateReports3(int nrMinComenzi, int valoareMinima) throws IOException;
    void generateReports4(int n) throws IOException;

    void createOrder(int[] index, Client client) throws IOException;
    DefaultListModel searchProduct(String searchBy, String searchProducts);
}
