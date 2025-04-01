package org.example.timeComplexity;

/*
A small frog wants to get to the other side of the road.
The frog is currently located at position X and wants to get to a position greater than or equal to Y.
The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

class Solution { public int solution(int X, int Y, int D); }

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:

  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:

after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Write an efficient algorithm for the following assumptions:

X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.


📌 문제 해석
작은 개구리가 현재 위치 X에서 출발하여 목표 위치 Y 이상으로 이동해야 한다.
개구리는 항상 고정된 거리 D만큼 점프한다.
최소 몇 번의 점프로 도착할 수 있는지를 구하는 문제다.

* * */

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }

    public static int solution(int X, int Y, int D) {
        int count = 0;
        int currentPosition = X;

        while (currentPosition < Y) {
            currentPosition = currentPosition + D;
            count++;
        }

        return count;
    }

}
