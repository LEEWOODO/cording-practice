package org.example.sorting;

import java.util.HashSet;
import java.util.Set;

// Compute number of distinct values in an array.
public class Distinct {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1}));
    }

    private static int solution(int[] A) {

        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }

        return set.size();
    }
}
