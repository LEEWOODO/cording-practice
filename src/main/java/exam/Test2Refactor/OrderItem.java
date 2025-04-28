package exam.Test2Refactor;

import java.util.Map;

public class OrderItem {
	public String name, size;
	public int quantity;

	public OrderItem(String name, String size, int quantity) {
		this.name = name;
		this.size = size;
		this.quantity = quantity;
	}

	public int getPrice(Map<String, Pizza> menuMap) {
		Pizza p = menuMap.get(name);
		switch (size) {
			case "Small": return p.price_S;
			case "Medium": return p.price_M;
			case "Large": return p.price_L;
			default: throw new IllegalArgumentException("Invalid size: " + size);
		}
	}
}
