package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private Customer customer;
    private List<Goods> goodsList;
    private double totalSalesTax;
    private double totalAmount;

    public Order(String customerName, String customerAddress, List<Goods> goodsList) {
        this.customer = new Customer(customerName, customerAddress);
        this.goodsList = goodsList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public Double getTotalSalesTax() {
        return totalSalesTax;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void calculateTotalTaxAndAmount() {
        for (Goods goods : goodsList) {
            this.totalSalesTax += goods.getTotalAmount() * .10;
            this.totalAmount += goods.getTotalAmount() + goods.getTotalAmount() * .10;
        }
    }
}
