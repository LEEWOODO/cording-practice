package org.example.maximunSliceProblem;

import java.util.Arrays;

// Find the maximal sum of any double slice.
public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
    }

    private static int solution(int[] A) {
        int N = A.length;

        int[] maxLeft = new int[N];
        int[] maxRight = new int[N];

        // 왼쪽에서부터 누적합 중 최대값 (단, A[i]가 아닌 A[i] + maxLeft[i - 1])
        for (int i = 1; i < N - 1; i++) {
            maxLeft[i] = Math.max(0, maxLeft[i - 1] + A[i]);
        }

        // 오른쪽에서부터 누적합 중 최대값
        for (int i = N - 2; i > 0; i--) {
            maxRight[i] = Math.max(0, maxRight[i + 1] + A[i]);
        }

        int maxSum = 0;
        for (int i = 1; i < N - 1; i++) {
            // i를 중앙 Y라고 보고, 양쪽 최대 슬라이스 합을 더함
            maxSum = Math.max(maxSum, maxLeft[i - 1] + maxRight[i + 1]);
        }

        return maxSum;
    }
}
