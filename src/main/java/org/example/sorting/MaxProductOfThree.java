package org.example.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Compute number of distinct values in an array.
// 세개의 P , Q , R 요소에서 최댓값을 찾는 방법
//✅ 최적화 전략: 정렬 후 두 가지 조합만 비교
//정렬 후 가능한 최대 곱 조합은 두 가지뿐이야:
//
//가장 큰 세 수
//👉 A[N-1] * A[N-2] * A[N-3]
//
//가장 작은 두 수(음수) × 가장 큰 수
//👉 A[0] * A[1] * A[N-1]
public class MaxProductOfThree {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-3, 1, 2, -2, 5, 6}));
    }

    private static int solution(int[] A) {
        int max = Integer.MIN_VALUE;

        Arrays.sort(A);

        if (A.length < 3) {
            return max;
        }

        // 가장 큰 세 수
        int N = A.length;
        max = Math.max(max, A[N-3] * A[N-2] * A[N-1]);

        //가장 작은 두 수(음수) × 가장 큰 수
        max = Math.max(max, A[0] * A[1] * A[N-1]);

        return max;

    }
}
