package org.example.countingElements;

import java.util.HashSet;
import java.util.Set;

/*
해당 배열이 순열인지 찾는 문제임

A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].


* */
public class PermCheck {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{4, 1, 3, 2}));
	}

	private static int solution(int[] A) {
		int N = A.length;
		long expectedSum = (long) N * (N + 1) / 2; // 오버플로우 방지
		long actualSum = 0;
		boolean[] seen = new boolean[N + 1]; // 등장한 숫자를 기록

		for (int num : A) {
			if (num < 1 || num > N || seen[num]) {
				return 0; // 범위를 벗어나거나 중복된 숫자가 있으면 순열이 아님
			}
			seen[num] = true;
			actualSum += num;
		}

		return actualSum == expectedSum ? 1 : 0;
	}
}
