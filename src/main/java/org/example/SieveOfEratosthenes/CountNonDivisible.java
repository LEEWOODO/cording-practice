package org.example.SieveOfEratosthenes;

import java.util.Arrays;

// Calculate the number of elements of an array that are not divisors of each element.

/* 전체 시각 요약
        인덱스	값 A[i]	    약수들	    약수 등장합	        전체 5개 - 약수등장합 = Non-divisors
        0	    3	        1, 3	    1 + 2 = 3	        5 - 3 = 2
        1	    1	        1	        1	                5 - 1 = 4
        2	    2	        1, 2	    1 + 1 = 2	        5 - 2 = 3
        3	    3	        1, 3	    1 + 2 = 3	        5 - 3 = 2
        4	    6	        1, 2, 3, 6	1 + 1 + 2 + 1 = 5	5 - 5 = 0
*/
public class CountNonDivisible {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 1, 2, 3, 6})));
    }

    private static int[] solution(int[] A) {
        int N = A.length;
        int max = 2 * N;
        int[] count = new int[max + 1];

        // step1. 숫자 등장 횟수 세기
        for (int num : A) {
            count[num]++;
        }

//        count[1] = 1
//        count[2] = 1
//        count[3] = 2
//        count[6] = 1


        int[] result = new int[N];

        // step2. 각 숫자에 대해 약수의 등장 횟수를 더하고, 전체에서 빼기
        for (int i = 0; i < N; i++) {
            int num = A[i];
            int divisorsCount = 0;
            int sqrt = (int) Math.sqrt(num);

            for (int d = 1; d <= sqrt; d++) {
                if (num % d == 0) {
                    int other = num / d;

                    // 약수 d가 존재한다면 등장 횟수 더함
                    divisorsCount += count[d];
                    if (other != d) {
                        divisorsCount += count[other];
                    }

                }

                result[i] = N - divisorsCount;
            }

        }

        return result;
    }
}
