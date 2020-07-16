package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private Customer customer;
    private List<Goods> goodsList;
    private double totalSalesTax;
    private double totalAmount;
    private final static double TAX = 0.10;

    public Order(String customerName, String customerAddress, List<Goods> goodsList) {
        this.customer = new Customer(customerName, customerAddress);
        this.goodsList = goodsList;
    }

    public String getCustomerInfo() {
        return customer.getIntroduce();
    }

    public String getGoodsListInfo() {
        return goodsList.toString();
    }

    public Double getTotalSalesTax() {
        return totalSalesTax;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void calculateTotalTaxAndAmount() {
        for (Goods goods : goodsList) {
            this.totalSalesTax += goods.getTotalAmount() * TAX;
            this.totalAmount += goods.getTotalAmount() * (1 + TAX);
        }
    }

    private void getReceiptHeader(StringBuilder receipt) {
        receipt.append("======Printing Orders======\n");
    }

    public void getReceiptFooter(StringBuilder receipt) {
        receipt.append("Sales Tax").append('\t').append(getTotalSalesTax());

        receipt.append("Total Amount").append('\t').append(getTotalAmount());
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        getReceiptHeader(receipt);

        receipt.append(getCustomerInfo());

        receipt.append(getGoodsListInfo());

        calculateTotalTaxAndAmount();

        getReceiptFooter(receipt);
        return receipt.toString();
    }
}
