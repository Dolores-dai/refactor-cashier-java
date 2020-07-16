package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        getReceiptHeader(receipt);

        receipt.append(order.getCustomer().getIntroduce());

        receipt.append(order.getGoodsList().toString());

        order.calculateTotalTaxAndAmount();

        receipt.append("Sales Tax").append('\t').append(order.getTotalSalesTax());

        receipt.append("Total Amount").append('\t').append(order.getTotalAmount());
        return receipt.toString();
    }

    private void getReceiptHeader(StringBuilder receipt) {
        receipt.append("======Printing Orders======\n");
    }
}
