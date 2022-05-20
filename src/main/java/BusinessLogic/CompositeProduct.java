package BusinessLogic;

import java.util.List;

public class CompositeProduct extends MenuItem{
    List<MenuItem> menuItems;

    public CompositeProduct(String title, float rating, int calories, int proteins, int fats, int sodium, float price, List<MenuItem> menuItems) {
        super(title, rating, calories, proteins, fats, sodium, price);
        this.menuItems = menuItems;
    }

    public float computeRating() {
        float sum = 0;
        for (MenuItem mi : menuItems)
            sum += mi.computeRating();
        super.setRating(sum / menuItems.size());
        return rating;
    }

    public int computeCalories() {
        int sum = 0;
        for (MenuItem mi : menuItems)
            sum += mi.computeCalories();
        super.setCalories(sum);
        return calories;
    }

    public int computeProteins() {
        int sum = 0;
        for (MenuItem mi : menuItems)
            sum += mi.computeProteins();
        super.setProteins(sum);
        return proteins;
    }

    public int computeFats() {
        int sum = 0;
        for (MenuItem mi : menuItems)
            sum += mi.computeFats();
        super.setFats(sum);
        return fats;
    }

    public int computeSodium() {
        int sum = 0;
        for (MenuItem mi : menuItems)
            sum += mi.computeSodium();
        super.setSodium(sum);
        return sodium;
    }

    public float computePrice() {
        float sum = 0;
        for (MenuItem mi : menuItems)
            sum += mi.computePrice();
        super.setPrice(sum);
        return price;
    }
}
