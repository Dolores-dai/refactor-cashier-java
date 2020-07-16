package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Order {
    private Customer customer;
    private List<Goods> goodsList;
    private double totalSalesTax;
    private double totalAmount;
    private LocalDate localDate;
    private final static double TAX = 0.10;

    public Order(String customerName, String customerAddress, List<Goods> goodsList, LocalDate localDate) {
        this.customer = new Customer(customerName, customerAddress);
        this.goodsList = goodsList;
        this.localDate = localDate;
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
        receipt.append("======老王超市，值得信赖======\n");
    }

    private void getReceiptFooter(StringBuilder receipt) {
        receipt.append("Sales Tax").append('\t').append(getTotalSalesTax());

        receipt.append("Total Amount").append('\t').append(getTotalAmount());
    }

    String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        getReceiptHeader(receipt);

        getDate(receipt);

        receipt.append(getCustomerInfo());

        receipt.append(getGoodsListInfo());

        calculateTotalTaxAndAmount();

        getReceiptFooter(receipt);
        return receipt.toString();
    }

    private void getDate(StringBuilder receipt) {
        receipt.append(localDate.format(DateTimeFormatter.ofPattern("yyyy年M月dd日，EEE").withLocale(Locale.CHINA)));
    }
}
