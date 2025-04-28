package exam.Test2Refactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 할인 전략 3: Large -> Small 무료
public class LargeFreeSmallDiscount implements DiscountStrategy {
	@Override
	public boolean isApplicable(List<OrderItem> orderItems, Map<String, Pizza> menuMap) {
		Set<String> smalls = new HashSet<>();
		Set<String> larges = new HashSet<>();
		for (OrderItem item : orderItems) {
			if (item.size.equals("Small")) smalls.add(item.name);
			if (item.size.equals("Large")) larges.add(item.name);
		}

		System.out.println("smalls = " + smalls);
		System.out.println("larges = " + larges);
		System.out.println("Collections.disjoint(smalls, larges) = " + Collections.disjoint(smalls, larges));
		return !Collections.disjoint(smalls, larges);
	}

	public int apply(List<OrderItem> orderItems, Map<String, Pizza> menuMap, int originalTotal) {
		Map<String, Integer> smallCount = new HashMap<>();
		Map<String, Integer> largeCount = new HashMap<>();
		int total = 0;
		for (OrderItem item : orderItems) {
			total += item.getPrice(menuMap) * item.quantity;
			if (item.size.equals("Small")) smallCount.put(item.name, item.quantity);
			if (item.size.equals("Large")) largeCount.put(item.name, item.quantity);
		}
		for (String name : menuMap.keySet()) {
			int free = Math.min(smallCount.getOrDefault(name, 0), largeCount.getOrDefault(name, 0));
			total -= free * menuMap.get(name).price_S;
		}
		return total;
	}
}