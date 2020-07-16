package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        getReceiptHeader(receipt);

        order.printReceipt(receipt);

        return receipt.toString();
    }

    private void getReceiptHeader(StringBuilder receipt) {
        receipt.append("======Printing Orders======\n");
    }
}
