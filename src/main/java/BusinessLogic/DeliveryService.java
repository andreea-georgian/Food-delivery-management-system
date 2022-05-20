package BusinessLogic;

import DataAccess.DataFileWriter;
import DataAccess.Serializator;
import GUI.EmployeeGui;
import GUI.Observer;
import Users.Client;

import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService  implements IDeliveryServiceProcessing{
    private Map<Order, List<MenuItem>> delivery = new HashMap<>();
    private List<MenuItem> menu = new ArrayList<>();
    private Observer obs;

    public void importProducts() {
        Serializator s = new Serializator();
        menu = s.getMenuItems();
    }

    private boolean invariant() {
        return menu != null;
    }

    /**
     * Metoda pentru adaugarea unui produs in menu
     * @param baseProduct
     */
    public void addProduct(MenuItem baseProduct) {
        assert baseProduct != null;
        menu.add(baseProduct);
    }

    /**
     * Metoda pentru stergerea unui produs din menu de pe un anumit index
     * @param index
     */
    public void deleteProduct(int index) {
        assert index >= 0;
        menu.remove(index);
        assert invariant();
    }

    /**
     * Metoda pentru modificarea unui produs existent in menu pe baza unui index
     * @param modifyBy
     * @param index
     * @param modifiedValue
     */
    public void modifyProduct(String modifyBy, int index, String modifiedValue) {
        assert modifyBy != null;
        assert index >= 0;
        assert modifiedValue != null;
        if(modifyBy.equals("Nume"))
            menu.get(index).setTitle(modifiedValue);
        if(modifyBy.equals("Rating"))
            menu.get(index).setRating(Float.parseFloat(modifiedValue));
        if(modifyBy.equals("Calorii"))
            menu.get(index).setCalories(Integer.parseInt(modifiedValue));
        if(modifyBy.equals("Proteine"))
            menu.get(index).setProteins(Integer.parseInt(modifiedValue));
        if(modifyBy.equals("Grasimi"))
            menu.get(index).setFats(Integer.parseInt(modifiedValue));
        if(modifyBy.equals("Sodiu"))
            menu.get(index).setSodium(Integer.parseInt(modifiedValue));
        if(modifyBy.equals("Pret"))
            menu.get(index).setPrice(Float.parseFloat(modifiedValue));
        assert invariant();
    }

    /**
     * Metoda pentru crearea unui produs
     * @param title
     * @param index
     * return
     */
    public MenuItem createProduct(String title, int[] index) {
        assert title != null;
        assert index.length != 0;
        List<MenuItem> menuItems = new ArrayList<>();
        for (int i : index) {
            menuItems.add(menu.get(i));
        }
        MenuItem newCompositeProduct = new CompositeProduct(title, 0, 0, 0, 0, 0, 0, menuItems);
        menu.add(newCompositeProduct);
        return newCompositeProduct;
    }

    /**
     * Metoda pentru generarea unui raport continand comenzile care s-au creat intr-un anumit interval orar
     * @param d1
     * @param d2
     */
    public void generateReports1(int d1, int d2) throws IOException {
        assert d1 >= 0 && d1 < 25;
        assert d2 >= 0 && d2 < 25;
        List<Order> o = new ArrayList<>();
        for (Map.Entry<Order, List<MenuItem>> entry : delivery.entrySet())
            o.add(entry.getKey());
        o.stream().filter(or -> or.getData().getHour() < d1 && or.getData().getHour() > d2).forEach(o::remove);
        DataFileWriter dfw = new DataFileWriter();
        dfw.generateReport1(o);
    }

    /**
     * Metoda pentru generarea unui raport continand produsele care s-au comandat de mai mult de n ori
     * @param n
     */
    public void generateReports2(int n) throws IOException {
        assert n > 0;
        List<MenuItem> menuItems;
        List<MenuItem> result;
        Map<MenuItem, Integer> aparitii = new HashMap<>();
        for (Map.Entry<Order, List<MenuItem>> entry : delivery.entrySet()) {
            menuItems = entry.getValue();
            for (MenuItem mi : menuItems) {
                if (aparitii.containsKey(mi))
                    aparitii.put(mi, aparitii.get(mi) + 1);
                else
                    aparitii.put(mi, 1);
            }
        }
        result = aparitii.entrySet().stream().filter(e -> e.getValue() > n).map(Map.Entry::getKey).collect(Collectors.toList());
        DataFileWriter dfw = new DataFileWriter();
        dfw.generateReport2(n, result);
    }

    /**
     * Metoda pentru generarea unui raport continand clientii care au comandat de un nr minim de ori si comanda are o valoare minima
     * @param nrMinComenzi
     * @param valoareMinima
     */
    public void generateReports3(int nrMinComenzi, int valoareMinima) throws IOException {
        assert nrMinComenzi > 0;
        assert valoareMinima > 0;
        List<Integer> result1;
        List<Integer> result2;
        Map<Integer, Integer> list1 = new HashMap<>();
        Map<Integer, Float> list2 = new HashMap<>();

        for (Map.Entry<Order, List<MenuItem>> entry : delivery.entrySet()) {
            Order o = entry.getKey();
            float price = 0;
            for (MenuItem mi : entry.getValue())
                price += mi.computePrice();
            if (list1.containsKey(o.getClientID())) {
                list1.put(o.getClientID(), list1.get(o.getClientID()) + 1);
                list2.put(o.getClientID(), list2.get(o.getClientID()) + price);
            }
            else {
                list1.put(o.getClientID(), 1);
                list2.put(o.getClientID(), price);
            }
            result1 = list1.entrySet().stream().filter(e -> e.getValue() > nrMinComenzi).map(Map.Entry::getKey).collect(Collectors.toList());
            result2 = list2.entrySet().stream().filter(e -> e.getValue() > valoareMinima).map(Map.Entry::getKey).collect(Collectors.toList());
            DataFileWriter dfw = new DataFileWriter();
            dfw.generateReport3(result1, result2, nrMinComenzi, valoareMinima);
        }
    }

    /**
     * Metoda pentru generarea unui raport continand produsele care s-au comandat intr-o anumita zi
     * @param n
     */
    public void generateReports4(int n) throws IOException {
        assert n > 0 && n < 32;
        Map<MenuItem, Integer> aparitii = new HashMap<>();
        List<MenuItem> menuItems;

        List<Order> orders = delivery.entrySet().stream().filter(e -> e.getKey().getData().getDayOfMonth() == n).map(Map.Entry::getKey).collect(Collectors.toList());
        for (Order o : orders) {
            menuItems = delivery.get(o);
            for (MenuItem mi : menuItems)
                if (aparitii.containsKey(mi))
                    aparitii.put(mi, aparitii.get(mi) + 1);
                else
                    aparitii.put(mi, 1);
        }
        DataFileWriter dfw = new DataFileWriter();
        dfw.generateReport4(aparitii, n);
    }

    /**
     * Metoda pentru cautarea unui produs in menu
     * @param searchBy
     * @param searchValue
     * return
     */
    public DefaultListModel searchProduct(String searchBy, String searchValue) {
        assert searchBy != null;
        assert searchValue != null;
        DefaultListModel list = new DefaultListModel();
        if(searchBy.equals("Nume")) {
            menu.stream().filter(mi -> mi.getTitle().matches("(.*)" + searchValue + "(.*)")).forEach(mi -> addElementToList(mi, list));
        }
        if(searchBy.equals("Rating")) {
            menu.stream().filter(mi -> mi.getRating() == Float.parseFloat(searchValue)).forEach(mi -> addElementToList(mi, list));
        }
        if(searchBy.equals("Calorii")) {
            menu.stream().filter(mi -> mi.getCalories() == Integer.parseInt(searchValue)).forEach(mi -> addElementToList(mi, list));
        }
        if(searchBy.equals("Proteine")) {
            menu.stream().filter(mi -> mi.getProteins() == Integer.parseInt(searchValue)).forEach(mi -> addElementToList(mi, list));
        }
        if(searchBy.equals("Grasimi")){
            menu.stream().filter(mi -> mi.getFats() == Integer.parseInt(searchValue)).forEach(mi -> addElementToList(mi, list));
        }
        if(searchBy.equals("Sodiu")) {
            menu.stream().filter(mi -> mi.getSodium() == Integer.parseInt(searchValue)).forEach(mi -> addElementToList(mi, list));
        }
        if(searchBy.equals("Pret")) {
            menu.stream().filter(mi -> mi.getPrice() == Float.parseFloat(searchValue)).forEach(mi -> addElementToList(mi, list));
        }
        return list;
    }

    /**
     * Metoda pentru crearea unei comenzi
     * @param index
     * @param client
     */
    public void createOrder(int[] index, Client client) throws IOException {
        assert client != null;
        assert index.length != 0;
        List<MenuItem> mi = new ArrayList<>();
        for (int i : index) {
            mi.add(menu.get(i));
        }
        Order newOrder = new Order(delivery.size() + 1, client.getId());
        delivery.put(newOrder, mi);
        DataFileWriter dfw = new DataFileWriter();
        dfw.generateBill(newOrder, mi);
        obs = new EmployeeGui();
        obs.update(delivery.size());
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addElementToList(MenuItem menuItem, DefaultListModel list) {
        String[] data = new String[8];
        data[1] = menuItem.getTitle();
        data[2] = String.valueOf(menuItem.computeRating());
        data[3] = String.valueOf(menuItem.computeCalories());
        data[4] = String.valueOf(menuItem.computeProteins());
        data[5] = String.valueOf(menuItem.computeFats());
        data[6] = String.valueOf(menuItem.computeSodium());
        data[7] = String.valueOf(menuItem.computePrice());
        list.addElement(data[1] + " " + data[2]+ " " + data[3]+ " " + data[4]+ " " + data[5]+ " " + data[6]+ " " + data[7]);
    }
}
