package exam.Test2Refactor;

public class SolutionCaller {
	public static void main(String[] args) {
		Test2Solution test2Solution = new Test2Solution();

		Pizza[] menu = {
			new Pizza("margherita", 90, 80, 100),
			new Pizza("hawaii", 80, 90, 120),
			new Pizza("capricciosa", 50, 70, 130),
			new Pizza("greek", 50, 70, 130)
		};

		OrderItem[] order = {
			new OrderItem("greek", "Small", 5),
			new OrderItem("margherita", "Small", 4),
			new OrderItem("hawaii", "Large", 1),
			new OrderItem("margherita", "Medium", 2),
			new OrderItem("capricciosa", "Small", 7)
		};

		System.out.println(test2Solution.solution(menu, order));
	}
}
