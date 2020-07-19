package cc.xpbootcamp.warmup.cashier;

public class LineItems {
    private String name;
    private double price;
    private int number;
    private double totalAmount;

    public LineItems(String name, Double price, Integer number) {
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
        return name + ',' +
                price + " * " +
                number + ',' +
                totalAmount + '\n';
    }
}
