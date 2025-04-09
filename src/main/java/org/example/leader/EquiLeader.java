package org.example.leader;


/*
Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.



* */
public class EquiLeader {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 4, 4, 4, 2}));
    }


    private static int solution(int[] A) {
        // 1. 전체 배열의 leader 찾기
        int size = 0;
        int candidate = 0;

        // Boyer-Moore 과반수 투표 알고리즘으로 leader 후보 찾기
        for (int num : A) {
            if (size == 0) {
                candidate = num;
                size++;
            } else if (candidate == num) {
                size++;
            } else {
                size--;
            }
        }

        // 실제로 후보가 전체 배열의 leader인지 확인
        int count = 0;
        for (int num : A) {
            if (num == candidate) {
                count++;
            }
        }

        // leader가 존재하지 않으면 equi leader도 존재하지 않음
        if (count <= A.length / 2) {
            return 0;
        }
        
        int leader = candidate;

        // 2. 각 인덱스에서 equi leader 여부 확인
        int equiLeaders = 0;
        int leadersLeft = 0;  // 왼쪽 부분에서 leader의 개수

        for (int i = 0; i < A.length; i++) {
            // 현재 원소가 leader면 왼쪽 부분의 leader 개수 증가
            if (A[i] == leader) {
                leadersLeft++;
            }
            int leadersRight = count - leadersLeft;  // 오른쪽 부분의 leader 개수

            // 왼쪽 부분의 길이는 i+1, 오른쪽 부분의 길이는 A.length-(i+1)
            if (leadersLeft > (i + 1) / 2 && leadersRight > (A.length - (i + 1)) / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }
}
