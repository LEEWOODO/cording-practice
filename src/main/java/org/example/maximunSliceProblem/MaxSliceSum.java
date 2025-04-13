package org.example.maximunSliceProblem;


// Find a maximum sum of a compact subsequence of array elements.
public class MaxSliceSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-3, -1, -7, -5}));
    }

    private static int solution(int[] A) {
        int maxEndingHere = A[0]; // 현재 위치까지 최대 슬라이스 합
        int maxSoFar = A[0];      // 지금까지의 전체 최대값

        for (int i = 1; i < A.length; i++) {
            // 지금 원소를 포함할지, 새로운 슬라이스를 시작할지 선택
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}

