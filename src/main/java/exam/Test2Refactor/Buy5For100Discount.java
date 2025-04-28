package exam.Test2Refactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 할인 전략 2: Buy 5 for 100
public class Buy5For100Discount implements DiscountStrategy {
	@Override
	public boolean isApplicable(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
		return orderItems.stream()
			.collect(Collectors.groupingBy(item -> item.name, Collectors.summingInt(item -> item.quantity)))
			.values().stream()
			.anyMatch(qty -> qty >= 5);
	}

	public int apply(List<OrderItem> orderItems, Map<String, Pizza> menuMap, int originalTotal) {
		Map<String, List<Integer>> grouped = new HashMap<>();
		for (OrderItem item : orderItems) {
			grouped.computeIfAbsent(item.name, k -> new ArrayList<>())
				.addAll(Collections.nCopies(item.quantity, item.getPrice(menuMap)));
		}
		int best = originalTotal;
		for (List<Integer> prices : grouped.values()) {
			if (prices.size() >= 5) {
				prices.sort(Collections.reverseOrder());
				int top5 = prices.stream().limit(5).mapToInt(Integer::intValue).sum();
				int discounted = originalTotal - top5 + 100;
				best = Math.min(best, discounted);
			}
		}
		return best;
	}
}