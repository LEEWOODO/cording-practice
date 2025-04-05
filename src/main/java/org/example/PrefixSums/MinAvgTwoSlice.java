package org.example.PrefixSums;

// Find the minimal average of any slice containing at least two elements.
//슬라이스 구간 (P~Q)	                평균
//          (1, 2)	            (2+2)/2 = 2.0
//          (3, 4)	            (5+1)/2 = 3.0
//          (1, 4)	            (2+2+5+1)/4 = 2.5
//          (4, 5)	            (1+5)/2 = 3.0
//          (2, 4)	            (2+5+1)/3 = 2.66...
//        ➡ 가장 작은 평균은 2.0, 구간은 (1,2)
//📌 따라서 정답은 1
public class MinAvgTwoSlice {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

    private static int solution(int[] A) {
        int N = A.length;
        int minStartIndex = 0;
        double minAvg = Double.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            int sum = A[i];
            for (int j = i + 1; j < N; j++) {
                if (j - i > 2) break;

                sum += A[j];
                double avg = (double) sum / (j - i + 1);

                if (avg < minAvg) {
                    minAvg = avg;
                    minStartIndex = i;
                }
            }
        }

        return minStartIndex;
    }
}
