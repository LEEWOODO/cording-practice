package EuclideanAlgorithm;

import java.util.Arrays;

//There are N chocolates in a circle. Count the number of chocolates you will eat.

/* 핵심 아이디어: 유클리드 호제법과 GCD
         초콜릿을 먹는 순서는 다음과 같이 돌아가:

         0 → (0 + M) % N → (0 + 2M) % N → (0 + 3M) % N → ...
         이렇게 먹다 보면 결국 언젠가는 처음에 먹은 0번 초콜릿으로 되돌아오게 돼.

         이게 언제냐면, (k * M) % N == 0인 가장 작은 k > 0일 때야.

         이때의 k는 다음 수학 공식으로 구할 수 있어:

         k = N / gcd(N, M)
         즉, 총 먹는 초콜릿 개수는 N / gcd(N, M)이 된다!
 */
public class ChocolatesByNumbers {
    public static void main(String[] args) {
        System.out.println(solution(10, 4));
    }

    // For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
    private static int solution(int N, int M) {
        return N / gcd(N, M);
    }

    private static int gcd(int a, int b) {
        // 유클리드 호제법
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
