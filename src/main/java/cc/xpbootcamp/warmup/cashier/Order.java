package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<Goods> goodsList;

    public Order(String customerName, String customerAddress, List<Goods> goodsList) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.goodsList = goodsList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }
}
