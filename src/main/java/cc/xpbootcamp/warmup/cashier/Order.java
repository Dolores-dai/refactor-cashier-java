package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String customerAddrress;
    List<Goods> goodsList;

    public Order(String customerName, String customerAddrress, List<Goods> goodsList) {
        this.customerName = customerName;
        this.customerAddrress = customerAddrress;
        this.goodsList = goodsList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddrress;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }
}
