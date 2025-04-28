package exam.Test2Refactor;

import java.util.List;
import java.util.Map;

public interface DiscountStrategy {
	boolean isApplicable(List<OrderItem> orderItems, Map<String, Pizza> menuMap);
	int apply(List<OrderItem> orderItems, Map<String, Pizza> menuMap, int originalTotal);
}
