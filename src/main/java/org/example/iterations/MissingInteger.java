package org.example.iterations;


/*
*
* Write a function:
    class Solution { public int solution(int[] A); }
    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
    Given A = [1, 2, 3], the function should return 4.
    Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
    Copyright 2009–2025 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*
* */

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2})); // 5
		System.out.println(solution(new int[]{1, 2, 3})); // 4
		System.out.println(solution(new int[]{-1, -3})); // 1
	}

	public static int solution(int[] n) {
		// 1단계: 양수만 저장할 자료구조 선택
		// 음수와 0은 고려할 필요가 없으므로, 양수만 저장할 자료구조(Set, boolean 배열 등)를 선택해야 합니다.
		Set<Integer> set = new HashSet<>();

		// 2단계: 중복 제거 후 정렬 또는 해시 테이블 사용
		// 배열에서 중복된 값을 제거하고 빠르게 조회할 수 있는 방법을 적용해야 합니다.
		for (int i : n) {
			if (i > 0) {
				set.add(i);
			}
		}
		System.out.println("set = " + set);

		// 3단계: 1부터 순차적으로 탐색
		// 1부터 시작해서 존재하지 않는 가장 작은 수를 찾으면 됩니다.
		int minPositive = 1;
		while (set.contains(minPositive)){
			minPositive++;
		}


		return minPositive;
	}
}