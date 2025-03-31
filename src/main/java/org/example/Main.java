package org.example;


/*
Abinary gapwithin a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
        For example, number 9 has binary representation1001and contains a binary gap of length 2. The number 529 has binary representation1000010001and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation10100and contains one binary gap of length 1. The number 15 has binary representation1111and has no binary gaps. The number 32 has binary representation100000and has no binary gaps.
Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
        For example, given N = 1041 the function should return 5, because N has binary representation10000010001and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
Write anefficientalgorithm for the following assumptions:


N is an integer within the range [1..2,147,483,647].
*/

public class Main {
    public static void main(String[] args) {
        int result = solution(1041);
        System.out.println("result = " + result);
    }

    public static int solution(int n){
        String binaryString = Integer.toBinaryString(n);
        System.out.println("binaryString = " + binaryString);

        int result = 0;
        int count = 0;
        boolean foundOne = false;

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                result = Math.max(result, count);
                count = 0;
                foundOne = true;
            }else if(foundOne){
                count++;
            }
        }

        return result;
    }
}