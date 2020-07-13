package cc.xpbootcamp.warmup.cashier;

public class Goods {
	private String name;
	private double price;
	private int number;

	public Goods(String name, double price, int number) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getNumber() {
		return number;
	}

    double totalAmount() {
        return price * number;
    }
}
