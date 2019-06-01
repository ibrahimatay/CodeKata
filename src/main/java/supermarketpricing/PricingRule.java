package supermarketpricing;

public class PricingRule {
    private Product product;
    private int productCount;
    private float percentDiscount;
    private int priority;

    public PricingRule(Product product, int productCount, float percentDiscount, int priority) {
        if (priority == 0) throw new IllegalArgumentException("Priority isn't be zero");
        if (productCount == 0) throw new IllegalArgumentException("count");
        if (percentDiscount == 0) throw new IllegalArgumentException("percentDiscount");

        this.product = product;
        this.productCount = productCount;
        this.percentDiscount = percentDiscount;
        this.priority = priority;
    }

    public Product getProduct() {
        return product;
    }

    public long getProductCount() {
        return productCount;
    }

    public float getPercentDiscount() {
        return percentDiscount;
    }

    public int getPriority() {
        return priority;
    }
}