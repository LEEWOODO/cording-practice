package exam.Test2Refactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// 할인 전략 1: Buy 3, Cheapest one free
public class Buy3Get1FreeDiscount implements DiscountStrategy{
	@Override
	public boolean isApplicable(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
		int totalQuantity = orderItems.stream().mapToInt(item -> item.quantity).sum();
		return totalQuantity >= 3;
	}

	@Override
	public int apply(List<OrderItem> orderItems, Map<String, Pizza> menuMap, int originalTotal) {
		List<Integer> prices = new ArrayList<>();
		for (OrderItem item : orderItems) {
			int price = item.getPrice(menuMap);
			for (int i = 0; i < item.quantity; i++) {
				prices.add(price);
			}
		}
		return originalTotal - Collections.min(prices);
	}
}
