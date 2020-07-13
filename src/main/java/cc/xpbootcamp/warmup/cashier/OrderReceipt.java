package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        // print headers
        receipt.append("======Printing Orders======\n");

        // print date, bill no, customer name
//        receipt.append("Date - " + order.getDate();
        receipt.append(order.getCustomer().getIntroduce());
//        receipt.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        receipt.append(order.getGoodsList().toString());

        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (Goods goods : order.getGoodsList()) {

            // calculate sales tax @ rate of 10%
            double salesTax = goods.getTotalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += goods.getTotalAmount() + salesTax;
        }

        // prints the state tax
        receipt.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        receipt.append("Total Amount").append('\t').append(totalAmount);
        return receipt.toString();
    }
}
