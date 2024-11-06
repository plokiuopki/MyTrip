//hotel class used for hashmap in accommendation.java
public class Hotel {
    private String name;
    private double distance;
    private double price;
    private double review;

    public Hotel(String name, double distance, double price, double review) {
        this.name = name;
        this.distance = distance;
        this.price = price;
        this.review = review;
    }

    public String theName() {
        return name;
    }

    public double theDist() {
        return distance;
    }

    public double thePrice() {
        return price;
    }

    public double theReview() {
        return review;
    }

    public String toString() {
        return String.format("%s (%.1f miles, $%.2f, %.1f/10)", name, distance, price, review);
    }
}
