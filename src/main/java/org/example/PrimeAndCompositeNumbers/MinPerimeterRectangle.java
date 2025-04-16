package org.example.PrimeAndCompositeNumbers;


// Find the minimal perimeter of any rectangle whose area equals N.
public class MinPerimeterRectangle {
    public static void main(String[] args) {
        System.out.println(solution(30));
    }

    private static int solution(int N) {
        int min = Integer.MAX_VALUE;
        int sqrt = (int) Math.sqrt(N);  // √N을 미리 계산

        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                int div = N / i;
                int perimeter = 2 * (i + div);
                min = Math.min(min, perimeter);
            }
        }
        return min;
    }
}
