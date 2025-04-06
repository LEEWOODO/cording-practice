package org.example.sorting;


import java.util.Arrays;

//Compute the number of intersections in a sequence of discs.
// 디스크 들의 교차점을 카운팅 하는 함수
public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, 1, 4, 0}));
    }

    private static int solution(int[] A) {
        int N = A.length;
        long[] startJNums = new long[N];
        long[] endJNums = new long[N];

        // 1단계: 각 디스크의 시작점, 끝점 계산
        for (int i = 0; i < N; i++) {
            startJNums[i] = (long) i - A[i];
            endJNums[i] = (long) i + A[i];
        }

        // 2단계: 정렬
        Arrays.sort(startJNums);
        Arrays.sort(endJNums);

//       디스크 인덱스:   1,  0, 2, 4, 3, 5
//       시작점 배열:  [-4, -1, 0, 0, 2, 5]
//       끝점 배열:    [1,  4,  4, 5, 6, 8]

        // 3단계: 스위핑 알고리즘 시작
        int intersections = 0;
        int openDiscs = 0;
        int endIdx = 0;

        for (int i = 0; i < N; i++) {
            // 현재 디스크의 시작점이 이전 디스크의 끝점보다 크거나 같으면 열린 디스크가 줄어듦
            while (endIdx < N && endJNums[endIdx] < startJNums[i]) {
                openDiscs--;
                endIdx++;
            }

            // 현재 열리는 디스크는 기존 열린 디스크와 모두 겹치므로 교차 개수 += openDiscs
            intersections += openDiscs;

            // 새 디스크 열림
            openDiscs++;

            // 조건 초과 시 -1 반환
            if (intersections > 10_000_000) {
                return -1;
            }
        }

        return intersections;
    }
}
