package org.example.stack;


import java.util.Stack;

// N voracious fish are moving along a river. Calculate how many fish are alive.
public class Fish {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    }

    private static int solution(int[] A, int[] B) {
        // 스택을 사용하여 현재 살아있는 물고기들을 저장
        // 각 원소는 물고기의 인덱스를 저장
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            int size = A[i];
            int direction = B[i];

            // 현재 물고기가 상류로 이동(0)하는 경우
            if (direction == 0) {
                // 스택에 있는 하류(1)로 이동하는 물고기들과 싸움
                while (!stack.isEmpty()) {
                    // 스택의 맨 위 물고기가 하류로 이동하는지 확인
                    int topFishIndex = stack.peek();

                    // 스택의 맨 위 물고기가 하류로 이동하지 않으면 싸울 필요 없음
                    if (B[topFishIndex] == 0) {
                        break;
                    }

                    // 싸움: 크기 비교
                    if (A[topFishIndex] > size) {
                        // 스택의 물고기가 승리, 현재 물고기는 사망
                        break;
                    } else {
                        // 현재 물고기가 승리, 스택의 물고기는 사망
                        stack.pop();
                    }
                }

                // 현재 물고기가 모든 싸움에서 살아남았으면 스택에 추가
                if (stack.isEmpty() || B[stack.peek()] == 0) {
                    stack.push(i);
                }
            } else {
                // 하류로 이동하는 물고기는 그냥 스택에 추가
                stack.push(i);
            }
        }

        // 스택에 남아있는 물고기 수가 정답
        return stack.size();
    }
}
