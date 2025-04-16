package org.example.PrimeAndCompositeNumbers;

public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solution(24));
    }

    private static int solution(int N) {
        int count = 0;
        int sqrt = (int) Math.sqrt(N);  // √N을 미리 계산
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                int div = N / i;
                if (i == div) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
