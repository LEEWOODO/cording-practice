package exam;

import java.util.*;

public class Test2 {
    Map<String, Pizza> menuMap;

    protected int solution(Pizza[] menu, OrderItem[] order) {
        menuMap = new HashMap<>();
        for (Pizza p : menu) {
            menuMap.put(p.name, p);
        }

        int originalTotal = calculateOriginalTotal(order);

        int d1 = applyDiscount1(order, originalTotal);
        int d2 = applyDiscount2(order, originalTotal);
        int d3 = applyDiscount3(order);
        int d4 = applyDiscount4(order, originalTotal);

        return Math.min(Math.min(Math.min(originalTotal, d1), d2), Math.min(d3, d4));

    }

    private int calculateOriginalTotal(OrderItem[] order) {
        int total = 0;
        for (OrderItem item : order) {
            int price = getPrice(item);
            total += price * item.quantity;
        }
        return total;
    }

    private int applyDiscount1(OrderItem[] order, int originalTotal) {
        List<Integer> prices = new ArrayList<>();
        for (OrderItem item : order) {
            int price = getPrice(item);
            for (int i = 0; i < item.quantity; i++) {
                prices.add(price);
            }
        }
        if (prices.size() < 3) return originalTotal;
        return originalTotal - Collections.min(prices);
    }

    private int applyDiscount2(OrderItem[] order, int originalTotal) {
        Map<String, List<Integer>> nameToPrices = new HashMap<>();
        for (OrderItem item : order) {
            int price = getPrice(item);
            List<Integer> list = nameToPrices.computeIfAbsent(item.name, k -> new ArrayList<>());
            for (int i = 0; i < item.quantity; i++) {
                list.add(price);
            }
        }

        int best = originalTotal;

        for (List<Integer> prices : nameToPrices.values()) {
            if (prices.size() >= 5) {
                prices.sort(Collections.reverseOrder());
                int top5Sum = 0;
                for (int i = 0; i < 5; i++) top5Sum += prices.get(i);
                int discountedTotal = originalTotal - top5Sum + 100;
                best = Math.min(best, discountedTotal);
            }
        }

        return best;
    }

    private int applyDiscount3(OrderItem[] order) {
        Map<String, Integer> smallCount = new HashMap<>();
        Map<String, Integer> largeCount = new HashMap<>();

        int total = 0;

        for (OrderItem item : order) {
            int price = getPrice(item);
            total += price * item.quantity;

            if (item.size.equals("Small")) {
                smallCount.put(item.name, item.quantity);
            } else if (item.size.equals("Large")) {
                largeCount.put(item.name, item.quantity);
            }
        }

        for (String name : menuMap.keySet()) {
            int free = Math.min(
                    largeCount.getOrDefault(name, 0),
                    smallCount.getOrDefault(name, 0)
            );
            total -= free * menuMap.get(name).price_S;
        }

        return total;
    }

    private int applyDiscount4(OrderItem[] order, int originalTotal) {
        List<int[]> largePrices = new ArrayList<>();

        for (OrderItem item : order) {
            if (item.size.equals("Large")) {
                Pizza p = menuMap.get(item.name);
                for (int i = 0; i < item.quantity; i++) {
                    largePrices.add(new int[]{p.price_L, p.price_M});
                }
            }
        }

        if (largePrices.size() < 3) return originalTotal;

        int minTotal = originalTotal;

        // 모든 조합 3개 선택 (brute force)
        int n = largePrices.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int lSum = largePrices.get(i)[0] + largePrices.get(j)[0] + largePrices.get(k)[0];
                    int mSum = largePrices.get(i)[1] + largePrices.get(j)[1] + largePrices.get(k)[1];
                    int discountedTotal = originalTotal - lSum + mSum;
                    minTotal = Math.min(minTotal, discountedTotal);
                }
            }
        }

        return minTotal;
    }

    private int getPrice(OrderItem item) {
        Pizza p = menuMap.get(item.name);
        switch (item.size) {
            case "Small": return p.price_S;
            case "Medium": return p.price_M;
            case "Large": return p.price_L;
        }
        throw new IllegalArgumentException("Invalid size: " + item.size);
    }

}


// 바깥에 정의된 클래스들
class Pizza {
    public String name;
    public int price_S, price_M, price_L;
    public Pizza(String name, int price_S, int price_M, int price_L) {
        this.name = name;
        this.price_S = price_S;
        this.price_M = price_M;
        this.price_L = price_L;
    }
}

class OrderItem {
    public String name, size;
    public int quantity;
    public OrderItem(String name, String size, int quantity) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
    }
}

