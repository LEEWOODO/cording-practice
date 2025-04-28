package exam.Test2Refactor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2Solution {
	private final List<DiscountStrategy> strategies = List.of(
		new Buy3Get1FreeDiscount(),
		new Buy5For100Discount(),
		new LargeFreeSmallDiscount(),
		new LargeToMediumDiscount()
	);

	public int solution(Pizza[] menu, OrderItem[] order) {
		Map<String, Pizza> menuMap = new HashMap<>();
		for (Pizza p : menu) {
			menuMap.put(p.name, p);
		}
		List<OrderItem> orderItems = Arrays.asList(order);
		int originalTotal = orderItems.stream()
			.mapToInt(item -> item.getPrice(menuMap) * item.quantity)
			.sum();

		int best = originalTotal;
		for (DiscountStrategy strategy : strategies) {
			if (strategy.isApplicable(orderItems, menuMap)) {
				best = Math.min(best, strategy.apply(orderItems, menuMap, originalTotal));
			}
		}
		return best;
	}
}
