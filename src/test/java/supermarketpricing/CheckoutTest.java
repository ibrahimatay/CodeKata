package supermarketpricing;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    private Checkout checkout;

    @Before
    public void setUp(){
        checkout = new Checkout();
    }

    @Test
    public void no_Product_No_Rule_TotalPrice0(){
        assertEquals(checkout.getTotalPrice(),0.0f, 0.0f);
    }

    @Test
    public void productA_Unit_4_TotalPrice100_No_Rule(){

        Product productA = new Product("A",25);
        checkout.addProduct(productA);
        checkout.addProduct(productA);
        checkout.addProduct(productA);
        checkout.addProduct(productA);

        assertEquals(checkout.getTotalPrice(),100.0f, 0.0f);
    }

    @Test
    public void productA_Unit_5_TotalPrice246_Rule_2_Product_To_50Percent_Discount(){

        Product productA = new Product("A",50);
        checkout.addProduct(productA);
        checkout.addProduct(productA);
        checkout.addProduct(productA);
        checkout.addProduct(productA);
        checkout.addProduct(productA);

        PricingRule pricingRule = new PricingRule(productA, 2, 0.50f,1);
        checkout.addPricingRule(pricingRule);

        assertEquals(checkout.getTotalPrice(),246, 0.0f);
    }

    @Test
    public void productA_Unit_4_TotalPrice196_2Rule_Run_To_High_Priority_Rule(){

        Product productA = new Product("A",50);
        checkout.addProduct(productA);
        checkout.addProduct(productA);
        checkout.addProduct(productA);
        checkout.addProduct(productA);

        PricingRule pricingRule01 = new PricingRule(productA, 2, 0.10f,1);
        PricingRule pricingRule02 = new PricingRule(productA, 5, 0.40f,2);
        checkout.addPricingRule(pricingRule01);
        checkout.addPricingRule(pricingRule02);

        assertEquals(checkout.getTotalPrice(),196.0f, 0.0f);
    }

    @Test
    public void product_A_And_B_TotalPrice_1Rule_2A_Product_To_50Percent_Discount(){
        Product productA = new Product("A",50);
        checkout.addProduct(productA);
        checkout.addProduct(productA);

        Product productB = new Product("B",20);
        checkout.addProduct(productB);
        checkout.addProduct(productB);
        checkout.addProduct(productB);

        PricingRule pricingRule01 = new PricingRule(productA, 2, 0.50f,1);
        checkout.addPricingRule(pricingRule01);

        assertEquals(checkout.getTotalPrice(),110.0f, 0.0f);
    }

    @Test
    public void product_A_And_B_TotalPrice_2Rule_2A_Product_To_50Percent_Discount_3B_Product_To_30Percent_Discount(){
        Product productA = new Product("A",50);
        checkout.addProduct(productA);
        checkout.addProduct(productA);

        Product productB = new Product("B",20);
        checkout.addProduct(productB);
        checkout.addProduct(productB);
        checkout.addProduct(productB);

        PricingRule pricingRule01 = new PricingRule(productA, 2, 0.50f,1);
        PricingRule pricingRule02 = new PricingRule(productB, 3, 0.30f,1);
        checkout.addPricingRule(pricingRule01);
        checkout.addPricingRule(pricingRule02);

        assertEquals(checkout.getTotalPrice(),77.0f, 0.0f);
    }
}
