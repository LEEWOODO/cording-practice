package org.example.stack;

import java.util.Stack;

// Nesting
// Determine whether a given string of parentheses (single type) is properly nested.
// Programming language:
// Java 8
// A string S consisting of N characters is called properly nested if:
//
// S is empty;
// S has the form "(U)" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// 	For example, string "(()(())())" is properly nested but string "())" isn't.
//
// Write a function:
//
// class Solution { public int solution(String S); }
//
// that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
//
// 	For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
//
// Write an efficient algorithm for the following assumptions:
//
// N is an integer within the range [0..1,000,000];
// string S is made only of the characters '(' and/or ')'.
// Copyright 2009–2025 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
public class Nesting {
	public static void main(String[] args) {
		System.out.println(solution("(()(())())")); // 1
	}

	private static int solution(String S) {
		int open = 0;

		for (char ch : S.toCharArray()) {
			if (ch == '(') {
				open++;
			} else if (ch == ')') {
				open--;
				if (open < 0) return 0;
			} else {
				// 허용되지 않은 문자가 있음
				return 0;
			}
		}

		return open == 0 ? 1 : 0;
	}

}
