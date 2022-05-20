package BusinessLogic;

public class BaseProduct extends MenuItem{
    public BaseProduct(String title, float rating, int calories, int proteins, int fats, int sodium, float price) {
        super(title, rating, calories, proteins, fats, sodium, price);
    }

    public float computeRating() {
        return this.rating;
    }

    public int computeCalories() {
        return this.calories;
    }

    public int computeProteins() {
        return this.proteins;
    }

    public int computeFats() {
        return this.fats;
    }

    public int computeSodium() {
        return this.sodium;
    }

    public float computePrice() {
        return this.price;
    }


}
