package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Order {
    private List<Goods> goodsList;
    private double totalSalesTax;
    private double totalAmount;
    private LocalDate localDate;
    private final static double TAX = 0.10;
    private final static double DISCOUNT = 0.02;
    private StringBuilder receipt;

    public Order(List<Goods> goodsList, LocalDate localDate) {
        this.goodsList = goodsList;
        this.localDate = Objects.isNull(localDate) ? LocalDate.now() : localDate;
    }

    String printReceipt() {
        receipt = new StringBuilder();

        getReceiptHeader();
        getReceiptContent();
        getReceiptFooter();

        return receipt.toString();
    }

    private void getReceiptHeader() {
        receipt.append("\n======老王超市，值得信赖======\n");
        getDate();
    }

    private void getDate() {
        receipt.append('\n')
                .append(localDate.format(DateTimeFormatter.ofPattern("yyyy年M月dd日，EEE\n").withLocale(Locale.CHINA)))
                .append('\n');
    }

    private void getReceiptContent() {
        receipt.append(goodsList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", ""));
    }

    private void getReceiptFooter() {
        receipt.append("\n----------------------\n");

        calculateTotalTaxAndAmount();

        receipt.append("税额:").append('\t').append(totalSalesTax).append('\n');

        ifDiscountAmount();
    }

    private void calculateTotalTaxAndAmount() {
        for (Goods goods : goodsList) {
            this.totalSalesTax += goods.getTotalAmount() * TAX;
            this.totalAmount += goods.getTotalAmount() * (1 + TAX);
        }
    }

    private void ifDiscountAmount() {
        if (Objects.equals(localDate.getDayOfWeek(), DayOfWeek.WEDNESDAY)) {
            receipt.append("折扣:").append('\t').append(totalAmount * DISCOUNT).append('\n');
            totalAmount *= 1 - DISCOUNT;
        }
        receipt.append("总价:").append('\t').append(totalAmount).append('\n');
    }
}
