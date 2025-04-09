package org.example.maximunSliceProblem;

// Given a log of stock prices compute the maximum possible earning.
// : 언제사고 언제팔아야 가장 큰 수익을 거둘수 있는지 구하는 알고리즘
// 이중 for 문 으로 구하면 overflow 발생함 O(N) 으로 해야함
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
    }

    private static int solution(int[] A) {
        int N = A.length;
        if (N <= 1) return 0;


        int minPrice = A[0];
        int maxProfit = 0;
        
        for (int i = 1; i < N; i++) {
            // 현재 가격에서 판매할 경우의 이익 계산
            int potentialProfit = A[i] - minPrice;

            // 최대 이익 갱신
            maxProfit = Math.max(maxProfit, potentialProfit);

            // 최소 구매 가격 갱신
            minPrice = Math.min(minPrice, A[i]);
        }

        return maxProfit;
    }
}
