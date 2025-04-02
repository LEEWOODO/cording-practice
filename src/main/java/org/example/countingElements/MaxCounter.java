package org.example.countingElements;

/*

You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].

초기 상태:     [0, 0, 0, 0, 0]

A[0] = 3  →  [0, 0, 1, 0, 0]  (3번 카운터 +1)
A[1] = 4  →  [0, 0, 1, 1, 0]  (4번 카운터 +1)
A[2] = 4  →  [0, 0, 1, 2, 0]  (4번 카운터 +1)
A[3] = 6  →  [2, 2, 2, 2, 2]  (모든 카운터를 최대값(2)로 설정)
A[4] = 1  →  [3, 2, 2, 2, 2]  (1번 카운터 +1)
A[5] = 4  →  [3, 2, 2, 3, 2]  (4번 카운터 +1)
A[6] = 4  →  [3, 2, 2, 4, 2]  (4번 카운터 +1)
*
*
*
* */

import java.util.Arrays;

public class MaxCounter {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[]{3,4,4,6,1,4,4})));
	}

	private static int[] solution(int N, int[] A) {
		// (0 0 0 0 0)
		int[] counters = new int[N];
		// 현재까지의 최대 카운터 값
		int maxCounter = 0;

		// 마지막 max counter 연산에서 설정된 값
		int lastMaxUpdate = 0;

		for (int num : A) {
			// max counter 연산
			if (num == N + 1) {
				lastMaxUpdate = maxCounter;
				System.out.println("lastMaxUpdate = " + lastMaxUpdate);
			} else {
				int index = num - 1;
				// 아직 lastMaxUpdate가 적용되지 않은 경우 업데이트
				if (counters[index] < lastMaxUpdate) {
					counters[index] = lastMaxUpdate;
				}
				// 카운터 증가
				counters[index]++;
				// 최대값 갱신
				maxCounter = Math.max(maxCounter, counters[index]);
			}

			System.out.println("Arrays.toString(counters) = " + Arrays.toString(counters));
		}

		// 마지막 max counter 연산을 적용 (누락된 요소 보정)
		for (int i = 0; i < N; i++) {
			if (counters[i] < lastMaxUpdate) {
				counters[i] = lastMaxUpdate;
			}
		}

		return counters;
	}
}
