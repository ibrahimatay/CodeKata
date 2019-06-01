package supermarketpricing;

public class Product {
    private String name;
    private float price;

    public Product(String name, float price) {
        if (name.isEmpty()) throw new IllegalArgumentException("name");
        if (price == 0) throw new IllegalArgumentException("price");

        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}