package sort;

import java.util.Scanner;

public class SelectionSort01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();		//정렬할 수 
		int[] A = new int[str.length()];	//자릿수별로 구분해 저장할 배열
		for (int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i+1));		//자릿수별로 구분해 데이터 저장
		}
		for (int i = 0; i < str.length(); i++) {
			int max = i;
			for (int j = i + 1; j < str.length(); j++) {
				if (A[j] > A[max]) {	//내림차순이므로 최댓값을 찾음
					max = j;
				}
			}
			if (A[i] < A[max]) {	//현재 i의 값과 max값 중 max값이 더 크면 swap하기
				int temp = A[i];
				A[i] = A[max];
				A[max] = temp;
			}
		}
		//출력
		for (int i = 0; i < str.length(); i++) {
			System.out.print(A[i]);
		}
	}

}
