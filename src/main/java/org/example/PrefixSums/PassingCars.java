package org.example.PrefixSums;

/*

A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.

지나가는 총 차량을 구하는 문제

문제 분석
✅ A[i] = 0이면 동쪽(East)으로 가는 차
✅ A[i] = 1이면 서쪽(West)으로 가는 차
✅ (P, Q) 쌍이 성립하려면 A[P] = 0, A[Q] = 1 (P < Q)
✅ 즉, 0이 나오면 이후 나오는 모든 1과 짝을 이룬다
* */
public class PassingCars {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 0, 1, 1}));

    }

    private static int solution(int[] A) {
        int eastCars = 0; // 동쪽(East)으로 가는 차의 개수
        int count = 0;    // 지나가는 차의 총 개수

        for (int num : A) {
            if (num == 0 ){
                eastCars++;
            }else{
                count = count + eastCars; // 현재까지의 모든 동쪽 차들과 페어 형성
                if (count > 1_000_000_000){
                    return -1;
                }

            }
        }

        return count;
    }

}
