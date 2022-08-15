package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StackNGE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] A = new int[n];	//수열 배열 생성
		int[] answer = new int[n];	//정답 배열 생성
		String[] str = bf.readLine().split(" ");	//빈칸을 기준으로 문자열 잘라서 배열 생성 및 저장
		for (int i = 0; i < n; i++) {	//수열 배열에 데이터 저장
			A[i] = Integer.parseInt(str[i]);
		}
		Stack<Integer> myStack = new Stack<>();	//최초 스택 선언
		myStack.push(0); 	//처음에는 항상 스택이 비어 있으므로 최초 값을 push해 초기화
		for (int i = 1; i < n; i++) {
			//스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
			while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
				answer[myStack.pop()] = A[i];	//정답 배열의 오큰수를 현재 수열로 저장하기
			}
			myStack.push(i);	//신규 데이터 push
		}
		while (!myStack.empty()) {
			//반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌 때까지
			answer[myStack.pop()] = -1;		//스택에 쌓인 index에 -1을 넣고
		}
		//출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(answer[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}

}
