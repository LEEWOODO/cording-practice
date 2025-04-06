package org.example.sorting;

//Determine whether a triangle can be built from a given set of edges.
//1단계: 문제 해석 & 핵심 조건 이해
//❓ 삼각형 조건이 뭐야?
//삼각형이 되기 위해서는 세 변의 길이 a, b, c 가 다음 조건을 모두 만족해야 해:
//
//a + b > c
//b + c > a
//c + a > b
//이 조건은 사실상 정렬 후 하나만 확인해도 충분해:
//정렬한 상태에서 A[i], A[i+1], A[i+2]에 대해
//A[i] + A[i+1] > A[i+2]만 만족하면, 나머지는 자동으로 만족해.

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 2, 5, 1, 8, 20}));
    }

    private static int solution(int[] A) {
        if (A.length < 3) return 0;

        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if ((long) A[i] + A[i + 1] > A[i + 2]) return 1;
        }

        return 0;
    }
}
