package org.example.stack;

/*

Cover "Manhattan skyline" using the minimum number of rectangles.

You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant;
however, it should have different heights in different places.
The height of the wall is specified by an array H of N positive integers.
H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

class Solution { public int solution(int[] H); }

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
*
* */


//  해당 문제는 그림이 잘 이해가 가지 않는다 ...
import java.util.Stack;

public class StoneWall {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
	}

	private static int solution(int[] H) {
		Stack<Integer> stack = new Stack<>();
		int blockCount = 0;

		for (int height : H) {
			// 현재 높이가 스택의 맨 위보다 낮은 경우
			while (!stack.isEmpty() && stack.peek() > height) {
				stack.pop();
			}

			// 현재 높이가 스택의 맨 위와 같지 않은 경우
			if (stack.isEmpty() || stack.peek() < height) {
				stack.push(height);
				blockCount++;
			}
			// 현재 높이가 스택의 맨 위와 같은 경우, 아무것도 하지 않음
		}

		return blockCount;
	}
}
