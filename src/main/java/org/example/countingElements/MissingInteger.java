package org.example.countingElements;


/*
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
    }

    private static int solution(int[] A) {
        int N = A.length;
        boolean[] exists = new boolean[N + 1]; // 1~N까지 숫자 체크할 배열

        // 1. 배열 내 존재하는 숫자 체크
        for (int num : A) {
            if (num > 0 && num <= N) { // N보다 큰 값은 어차피 답이 아님
                exists[num] = true;
            }
        }

        // 2. 1부터 N까지 중 빠진 숫자 찾기, 0 인덱스는 제외함
        for (int i = 1; i <= N; i++) {
            if (!exists[i]) {
                return i; // 첫 번째로 없는 숫자 반환
            }
        }

        // 3. 모든 숫자가 존재하면 N+1 반환
        return N + 1;
    }
}
