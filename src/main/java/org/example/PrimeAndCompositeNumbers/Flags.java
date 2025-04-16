package org.example.PrimeAndCompositeNumbers;

import java.util.ArrayList;
import java.util.List;

//Find the maximum number of flags that can be set on mountain peaks.
public class Flags {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }

    private static int solution(int[] A) {
        int N = A.length;
        List<Integer> peaks = new ArrayList<>();

        // Step 1: 피크 위치 찾기
        for (int i = 1; i < N - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        if (peaks.size() <= 1) return peaks.size();

        // Step 2: 이분 탐색으로 최대 깃발 개수 찾기
        int left = 1;
        int right = peaks.size();
        int result = 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canPlaceFlags(peaks, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static boolean canPlaceFlags(List<Integer> peaks, int K) {
        int used = 0;
        int lastPlaced = -K;

        for (int peak : peaks) {
            if (peak - lastPlaced >= K) {
                used++;
                lastPlaced = peak;
                if (used == K) return true;
            }
        }

        return false;
    }
}
