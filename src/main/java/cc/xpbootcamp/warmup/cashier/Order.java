package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order {
    private List<Goods> goodsList;
    private double totalSalesTax;
    private double totalAmount;
    private double discount;
    private LocalDate localDate;
    private final static double TAX = 0.10;
    private final static double DISCOUNT = 0.02;

    public Order(List<Goods> goodsList, LocalDate localDate) {
        this.goodsList = goodsList;
        this.localDate = Objects.isNull(localDate) ? LocalDate.now() : localDate;
        calculateTotalTaxAndAmount();
    }

    public List<Goods> getGoodsList() {
        return goodsList;
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
        for (Goods goods : goodsList) {
            this.totalSalesTax += goods.getTotalAmount() * TAX;
            this.totalAmount += goods.getTotalAmount() * (1 + TAX);
        }
        if (Objects.equals(localDate.getDayOfWeek(), DayOfWeek.WEDNESDAY)) {
            this.discount = this.totalAmount * DISCOUNT;
            this.totalAmount *= 1 - DISCOUNT;
        }
    }
}
