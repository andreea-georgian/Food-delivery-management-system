package DataAccess;

import BusinessLogic.BaseProduct;
import BusinessLogic.MenuItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Serializator {
    String line;
    String splitBy = ",";
    private List<MenuItem> menuItems = new ArrayList<>(10);

    public Serializator() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("products.csv"));
            line = br.readLine();
            while((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                MenuItem mi = new BaseProduct(data[0], Float.parseFloat(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]),Integer.parseInt(data[5]), Float.parseFloat(data[6]));
                addToMenu(mi);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addToMenu(MenuItem mi) {
        int ok = 1;
        for (MenuItem aux : menuItems)
            if (aux.getTitle().equals(mi.getTitle()))
                ok = 0;
        if (ok == 1)
            menuItems.add(mi);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
