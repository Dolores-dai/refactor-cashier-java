package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order {
    private List<LineItems> lineItemsList;
    private double totalSalesTax;
    private double totalAmount;
    private double discount;
    private LocalDate localDate;
    private final static double TAX = 0.10;
    private final static double DISCOUNT = 0.02;

    public Order(List<LineItems> lineItemsList, LocalDate localDate) {
        this.lineItemsList = lineItemsList;
        this.localDate = Objects.isNull(localDate) ? LocalDate.now() : localDate;
        calculateTotalTaxAndAmount();
    }

    public List<LineItems> getGoodsList() {
        return lineItemsList;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public double getDiscount() {
        return discount;
    }

    private void calculateTotalTaxAndAmount() {
        for (LineItems lineItems : lineItemsList) {
            totalSalesTax += lineItems.getTotalAmount() * TAX;
            totalAmount += lineItems.getTotalAmount() * (1 + TAX);
        }
        if (Objects.equals(localDate.getDayOfWeek(), DayOfWeek.WEDNESDAY)) {
            discount = totalAmount * DISCOUNT;
            totalAmount *= 1 - DISCOUNT;
        }
    }
}
