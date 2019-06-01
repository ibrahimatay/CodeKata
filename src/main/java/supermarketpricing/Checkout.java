package supermarketpricing;

import java.util.*;
import java.util.stream.*;

public class Checkout {

    private final List<Product> products = new ArrayList<>();
    private final List<PricingRule> pricingRules = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException();
        products.add(product);
    }

    public void addPricingRule(PricingRule pricingRule) {
        if (pricingRule == null) throw new IllegalArgumentException();
        pricingRules.add(pricingRule);
    }

    public float getTotalPrice() {
        if (products.isEmpty()) return 0;
        float totalPrice = 0;

        var productList = products.stream().distinct().collect(Collectors.toList());
        for (var product: productList){
            var productCount = products.stream()
                    .filter(current -> current.getName().equals(product.getName()))
                    .count();

            var rules = pricingRules.stream().filter(pricingRule -> pricingRule.getProduct().getName().equals(product.getName()))
                    .sorted(Comparator.comparing(pricingRule -> pricingRule.getPriority()))
                    .collect(Collectors.toList());

            totalPrice += productCount * product.getPrice();

            for (var rule : rules){
                if (productCount == rule.getProductCount())
                {
                    totalPrice -= (totalPrice * rule.getPercentDiscount());
                    break;
                }

                if (productCount > rule.getProductCount())
                {
                    long mod = productCount % rule.getProductCount();
                    totalPrice -= ((productCount - mod) / rule.getProductCount()) * rule.getProductCount();
                    break;
                }
            }
        }

        return totalPrice;
    }
}
