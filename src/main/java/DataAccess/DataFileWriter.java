package DataAccess;

import BusinessLogic.MenuItem;
import BusinessLogic.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataFileWriter {
    private FileWriter file;

    public void generateBill(Order o, List<MenuItem> menuItems) throws IOException {
        file = new FileWriter("Bill" + o.getOrderID() + ".txt");
        file.append("Comanda numarul " + o.getOrderID() + "\n");
        file.append("Client " + o.getClientID() + "\n\n");
        file.append("Produsele comandate:\n");
        float total = 0;
        for (MenuItem mi : menuItems) {
            file.append(mi.getTitle() + "    " + mi.getPrice() + "lei\n");
            total += mi.computePrice();
        }
        file.append("\t\tTotal: " + total + "lei\n");
        file.append("\nMultumim pentru incredere! :)");
        file.close();
    }

    public void generateReport1(List<Order> orders) throws IOException {
        file = new FileWriter("Raport.txt");
        for (Order o : orders)
            file.append("Comanda numarul " + o.getOrderID() + " facuta de clientul " + o.getClientID() + ".\n");
        file.close();
    }

    public void generateReport2(int n, List<MenuItem> menuItems) throws IOException {
        file = new FileWriter("Raport.txt");
        file.append("Produse care au fost comandate de mai mult de " + n + " ori:\n\n");
        for(MenuItem mi : menuItems)
            file.append(mi.getTitle() + "\n");
        file.close();
    }

    public void generateReport3(List<Integer> list1, List<Integer> list2, int n1, int n2) throws IOException {
        file = new FileWriter("Raport.txt");
        file.append("Clienti care au comandat de minim " + n1 + " si valoarea totala a comenzilor este cel putin " + n2 + "lei: \n");
        for(Integer i : list1) {
            if (list2.contains(i))
                file.append(("Clientul " + i + "\n"));
        }
        file.close();
    }

    public void generateReport4(Map<MenuItem, Integer> aparitii, int n) throws IOException {
        file = new FileWriter("Raport.txt");
        file.append("Produsele care s-au comandat in data de " + n + ": \n\n");
        for (Map.Entry<MenuItem, Integer> entry : aparitii.entrySet()) {
            file.append(entry.getKey().getTitle() + "de " + entry.getValue() + " ori\n");
        }
        file.close();
    }
}
