package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class OrderReceipt {
    private Order order;
    private StringBuilder receipt;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
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
                .append(order.getLocalDate().format(DateTimeFormatter.ofPattern("yyyy年M月dd日，EEE\n").withLocale(Locale.CHINA)))
                .append('\n');
    }

    private void getReceiptContent() {
        receipt.append(order.getGoodsList().toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", ""));
    }

    private void getReceiptFooter() {
        receipt.append("\n----------------------\n");

        printTotalSalesTax();

        ifDiscountAmount();

        printTotalAmount();
    }

    private void printTotalSalesTax() {
        receipt.append("税额:").append('\t').append(order.getTotalSalesTax()).append('\n');
    }

    private void ifDiscountAmount() {
        if (Objects.equals(order.getLocalDate().getDayOfWeek(), DayOfWeek.WEDNESDAY)) {
            receipt.append("折扣:").append('\t').append(order.getDiscount()).append('\n');
        }
    }

    private void printTotalAmount() {
        receipt.append("总价:").append('\t').append(order.getTotalAmount()).append('\n');
    }
}
