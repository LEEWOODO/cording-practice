package org.example.leader;

// Find an index of an array such that its value occurs at more than half of indices in the array.

import java.util.HashMap;
import java.util.Map;

/*
An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs.

The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

* */
public class Dominator {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,4,3,2,3,-1,3,3}));

	}

	private static int solution(int[] A) {
		if (A.length == 0) return -1;

		// Step 1: Find a candidate
		int size = 0;
		int value = 0;

		for (int num : A) {
			if (size == 0) {
				value = num;
				size++;
			} else {
				if (value == num) {
					size++;
				} else {
					size--;
				}
			}
		}
		System.out.println("value = " + value);
		System.out.println("size = " + size);

		// Step 2: Verify if it's the dominator
		int candidate = value;
		int count = 0;
		int index = -1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) {
				count++;
				index = i; // save any index of the candidate
			}
		}

		if (count > A.length / 2) {
			return index;
		}

		return -1;
	}
}
