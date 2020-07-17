package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    private LocalDate date;

    @BeforeEach
    void setUp() {
        date = LocalDate.of(2020, 2, 17);
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<Goods> goods = new ArrayList<Goods>() {{
            add(new Goods("milk", 10.0, 2));
            add(new Goods("biscuits", 5.0, 5));
            add(new Goods("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(goods, date));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk,10.0 * 2,20.0\n"));
        assertThat(output, containsString("biscuits,5.0 * 5,25.0\n"));
        assertThat(output, containsString("chocolate,20.0 * 1,20.0\n"));
        assertThat(output, containsString("税额:\t6.5"));
        assertThat(output, containsString("总价:\t71.5"));
    }

    @Test
    void shouldPrintSupermarketTitle() {
        Order order = new Order(new ArrayList<Goods>(), date);
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("======老王超市，值得信赖======"));
    }

    @Test
    void shouldPrintDateInfo() {
        Order order = new Order(new ArrayList<Goods>(), date);
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月17日，星期一"));
    }

    @Test
    void shouldPrintDiscountInfoWhenWed() {
        date = LocalDate.of(2020,2,19);
        List<Goods> goods = new ArrayList<Goods>() {{
            add(new Goods("milk", 10.0, 2));
            add(new Goods("biscuits", 5.0, 5));
            add(new Goods("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(goods, date));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk,10.0 * 2,20.0\n"));
        assertThat(output, containsString("biscuits,5.0 * 5,25.0\n"));
        assertThat(output, containsString("chocolate,20.0 * 1,20.0\n"));
        assertThat(output, containsString("税额:\t6.5"));
        assertThat(output, containsString("折扣:\t1.43"));
        assertThat(output, containsString("总价:\t70.07"));
    }

    @Test
    void shouldHandleNullDate() {
        Order order = new Order(new ArrayList<Goods>(), null);
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("======老王超市，值得信赖======"));
    }
}
