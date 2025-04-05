package org.example.PrefixSums;

import java.util.Arrays;

// Find the minimal nucleotide from a range of sequence DNA.
//Index:     0   1   2   3   4   5   6
//S:         C   A   G   C   C   T   A
//Impact:    2   1   3   2   2   4   1


public class GenomicRangeQuery {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
    }

    private static int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int[] prefixA = new int[N + 1];
        int[] prefixC = new int[N + 1];
        int[] prefixG = new int[N + 1];

        for (int i = 0; i < N; i++) {
            prefixA[i + 1] = prefixA[i];
            prefixC[i + 1] = prefixC[i];
            prefixG[i + 1] = prefixG[i];

            char nucleotide = S.charAt(i);
            if (nucleotide == 'A') prefixA[i + 1]++;
            else if (nucleotide == 'C') prefixC[i + 1]++;
            else if (nucleotide == 'G') prefixG[i + 1]++;
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;

            if (prefixA[end] - prefixA[start] > 0) result[i] = 1;
            else if (prefixC[end] - prefixC[start] > 0) result[i] = 2;
            else if (prefixG[end] - prefixG[start] > 0) result[i] = 3;
            else result[i] = 4;
        }

        return result;
    }
}
