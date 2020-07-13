package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
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

        order.calculateTotalTaxAndAmount();

        // prints the state tax
        receipt.append("Sales Tax").append('\t').append(order.getTotalSalesTax());

        // print total amount
        receipt.append("Total Amount").append('\t').append(order.getTotalAmount());
        return receipt.toString();
    }
}
