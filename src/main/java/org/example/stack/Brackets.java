package org.example.stack;

// Determine whether a given string of parentheses (multiple types) is properly nested.
// A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
//
// S is empty;
// S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// 	For example, the string "{[()()]}" is properly nested but "([)()]" is not.
//
// Write a function:
//
// class Solution { public int solution(String S); }
//
// that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
//
// 	For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
//
// Write an efficient algorithm for the following assumptions:
//
// N is an integer within the range [0..200,000];
// string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.

import java.util.Stack;

public class Brackets {
	public static void main(String[] args) {
		System.out.println(solution("([)()]"));
	}

	private static int solution(String S) {
		// Stack을 사용하여 괄호를 검사
		Stack<Character> stack = new Stack<>();
		for (char c : S.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c); // 여는 괄호는 Stack에 추가
			} else {
				if (stack.isEmpty()) {
					return 0; // 닫는 괄호가 먼저 나오는 경우
				}
				char top = stack.pop(); // Stack에서 가장 위의 여는 괄호를 꺼냄
				if (!isMatchingPair(top, c)) {
					return 0; // 쌍이 맞지 않는 경우
				}
			}
		}

		// Stack이 비어있으면 모든 괄호가 잘 맞춰진 것
		if (stack.isEmpty()) {
			return 1; // Properly nested
		} else {
			return 0; // Not properly nested
		}
	}

	private static boolean isMatchingPair(char top, char c) {

		// 여는 괄호와 닫는 괄호가 쌍을 이루는지 확인
		if (top == '(' && c == ')') {
			return true;
		} else if (top == '{' && c == '}') {
			return true;
		} else if (top == '[' && c == ']') {
			return true;
		}

		return false;
	}
}
