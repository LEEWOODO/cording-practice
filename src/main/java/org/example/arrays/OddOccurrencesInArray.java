package org.example.arrays;

import java.util.HashMap;
import java.util.Map;/*
    A non-empty array A consisting of N integers is given.
    The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

    For example, in array A such that:

      A[0] = 9  A[1] = 3  A[2] = 9
      A[3] = 3  A[4] = 9  A[5] = 7
      A[6] = 9
    the elements at indexes 0 and 2 have value 9,
    the elements at indexes 1 and 3 have value 3,
    the elements at indexes 4 and 6 have value 9,
    the element at index 5 has value 7 and is unpaired.
    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

    For example, given array A such that:

      A[0] = 9  A[1] = 3  A[2] = 9
      A[3] = 3  A[4] = 9  A[5] = 7
      A[6] = 9
    the function should return 7, as explained in the example above.

    Write an efficient algorithm for the following assumptions:

    N is an odd integer within the range [1..1,000,000];
    each element of array A is an integer within the range [1..1,000,000,000];
    all but one of the values in A occur an even number of times.


-> 📌 문제 해석
주어진 배열 A에는 **홀수 개(N)**의 요소가 존재하며, 대부분의 요소들은 쌍을 이루지만 한 요소만 혼자 남는다.
그 쌍을 이루지 못한 요소를 찾아 반환하는 함수를 작성해야 한다.


* */

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }

    public static int solution(int[] A) {
        // 1단계: 숫자의 등장 횟수를 저장할 Map을 만든다.
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : A) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 2단계: 등장 횟수가 홀수인 숫자를 찾는다.
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 != 0 ){
                return entry.getKey(); // 홀수 번 등장한 숫자를 반환
            }
        }

        return -1;
    }
}
