package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String cName;
    String addr;
    List<Goods> goodsList;

    public Order(String cName, String addr, List<Goods> goodsList) {
        this.cName = cName;
        this.addr = addr;
        this.goodsList = goodsList;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<Goods> getLineItems() {
        return goodsList;
    }
}
