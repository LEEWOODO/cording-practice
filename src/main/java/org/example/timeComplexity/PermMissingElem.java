package org.example.timeComplexity;

/*
    An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

    Your goal is to find that missing element.

    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A, returns the value of the missing element.

    For example, given array A such that:

      A[0] = 2
      A[1] = 3
      A[2] = 1
      A[3] = 5
    the function should return 4, as it is the missing element.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [0..100,000];
    the elements of A are all distinct;
    each element of array A is an integer within the range [1..(N + 1)].

 📌 문제 해석
  배열에서 빠진 숫자 찾기 
  
  - 가우스 합 공식 사용하여 구현 : 1부터 (N+1)까지의 합을 계산한 후, 배열의 총합을 빼면 빠진 숫자가 남는다.
* */

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 1, 5}));
    }

    public static int solution(int[] A) {
        int N = A.length;

        long expectedSum = (long) (N + 1) * (1 + N + 1) / 2;

        long actualSum = 0;
        for (int num : A) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }
}
