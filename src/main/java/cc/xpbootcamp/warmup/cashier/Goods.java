package cc.xpbootcamp.warmup.cashier;

public class Goods {
    private String name;
    private double price;
    private int number;
    private double totalAmount;

    public Goods(String name, Double price, Integer number) {
        super();
        this.name = name;
        this.price = price;
        this.number = number;
        this.totalAmount = price * number;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return name + '\t' +
                price + '\t' +
                number + '\t' +
                totalAmount + '\n';
    }
}
