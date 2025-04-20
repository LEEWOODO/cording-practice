package org.example.EuclideanAlgorithm;

// Check whether two numbers have the same prime divisors.
// 두 숫자의 소인수 약수가 같은지 확인
public class CommonPrimeDivisors {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{15, 10, 3}, new int[]{75, 30, 5}));
    }

    private static int solution(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (hasSamePrimeDivisors(A[i], B[i])) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasSamePrimeDivisors(int a, int b) {
        int gcd = gcd(a, b);
        return removeOtherPrimeDivisors(a, gcd) == 1 && removeOtherPrimeDivisors(b, gcd) == 1;
    }

    private static int removeOtherPrimeDivisors(int x, int gcdVal) {
        int value;
        while ((value = gcd(x, gcdVal)) != 1) {
            x /= value;
        }
        return x;
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
