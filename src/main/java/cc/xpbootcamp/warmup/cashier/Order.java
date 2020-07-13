package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private Customer customer;
    private List<Goods> goodsList;

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
}
