package BusinessLogic;

public abstract class MenuItem {
    String title;
    float rating;
    int calories;
    int proteins;
    int fats;
    int sodium;
    float price;

    public MenuItem(String title, float rating, int calories, int proteins, int fats, int sodium, float price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public abstract float computeRating();
    public abstract int computeCalories();
    public abstract int computeProteins();
    public abstract int computeFats();
    public abstract int computeSodium();
    public abstract float computePrice();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getSodium() {
        return sodium;
    }

    public float getPrice() {
        return price;
    }
}
