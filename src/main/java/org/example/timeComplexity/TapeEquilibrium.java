package org.example.timeComplexity;


/*
    A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

    Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

    The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

    In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

    For example, consider array A such that:

      A[0] = 3
      A[1] = 1
      A[2] = 2
      A[3] = 4
      A[4] = 3
    We can split this tape in four places:

    P = 1, difference = |3 − 10| = 7
    P = 2, difference = |4 − 9| = 5
    P = 3, difference = |6 − 7| = 1
    P = 4, difference = |10 − 3| = 7
    Write a function:

    class Solution { public int solution(int[] A); }

    that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

    For example, given:

      A[0] = 3
      A[1] = 1
      A[2] = 2
      A[3] = 4
      A[4] = 3
    the function should return 1, as explained above.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [2..100,000];
    each element of array A is an integer within the range [−1,000..1,000].



* */

public class TapeEquilibrium {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 4, 3}));
    }

    private static int solution(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num; // 전체 배열의 합 계산
        }


        int leftSum = 0;
        int minDifference = Integer.MAX_VALUE; // 최소 차이 값을 초기화

        for (int P = 1; P < A.length; P++) {
            leftSum += A[P - 1]; // 첫 번째 부분의 합 누적
            int rightSum = totalSum - leftSum; // 두 번째 부분의 합은 전체 합에서 첫 번째 부분의 합을 뺀 값

            int difference = Math.abs(leftSum - rightSum); // 차이의 절댓값
            minDifference = Math.min(minDifference, difference); // 최소 차이 갱신
        }

        return minDifference;
    }
}
