package dataStructure;

import java.util.Scanner;
import java.util.Stack;

public class AscendingSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//수열 개수
		int N = sc.nextInt();
		//수열 배열
		int[] A = new int[N];
		//수열 배열 채우기
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		//스택 선언
		Stack<Integer> stack = new Stack<>();
		//StringBuffer 선언 > 임시 저장 공간
		StringBuffer bf = new StringBuffer();
		int num = 1; 	//오름차순 수
		boolean result = true;
		//
		for (int i = 0; i < A.length; i++) {
			int su = A[i];	//현재 수열의 수
			if (su >= num) {	//현재 수열 값 > = 오름차순 자연수 : 값이 같아질 때까지 push 수행 
				while (su >= num) {	//push : top 위치에 새로운 데이터를 삽입
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();	//pop : top 위치에 현재 있는 데이터를 삭제 > 꺼냄
				bf.append("-\n");
			} else {	//현재 수열 값 < 오름차순 자연수 : pop을 수행해 수열 원소를 꺼냄
				int n = stack.pop();
				if (n > su) {	//스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}
		if (result) {	//if(No값을 출력한적이 없으면) 저장한 값 출력
			System.out.println(bf.toString()); 	
		}
	}

}
