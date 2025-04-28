package exam.Test2Refactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 할인 전략 4: 3 Large -> Pay as Medium
public class LargeToMediumDiscount implements DiscountStrategy {
	@Override
	public boolean isApplicable(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
		int largeCount = orderItems.stream().filter(item -> item.size.equals("Large")).mapToInt(item -> item.quantity).sum();
		return largeCount >= 3;
	}

	public int apply(List<OrderItem> orderItems, Map<String, Pizza> menuMap, int originalTotal) {
		List<int[]> prices = new ArrayList<>();
		for (OrderItem item : orderItems) {
			if (item.size.equals("Large")) {
				for (int i = 0; i < item.quantity; i++) {
					prices.add(new int[]{menuMap.get(item.name).price_L, menuMap.get(item.name).price_M});
				}
			}
		}
		int minTotal = originalTotal;
		for (int i = 0; i < prices.size(); i++) {
			for (int j = i+1; j < prices.size(); j++) {
				for (int k = j+1; k < prices.size(); k++) {
					int lSum = prices.get(i)[0] + prices.get(j)[0] + prices.get(k)[0];
					int mSum = prices.get(i)[1] + prices.get(j)[1] + prices.get(k)[1];
					int discounted = originalTotal - lSum + mSum;
					minTotal = Math.min(minTotal, discounted);
				}
			}
		}
		return minTotal;
	}
}