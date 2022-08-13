package dataStructure;

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//점수 입력할 배열 선언 후 배열에 점수 넣기
		//배열의 크기는 N의 크기만큼
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		//최댓값, 합계 구하기
		long sum = 0;
		long max = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] > max) {
				max = A[i];
			}
			sum += A[i];
		}
		
		//한 과목과 관련된 수식을 총합한 후 관련된 수식으로 변화해 로직이 간단
		System.out.println(sum * 100.0 / max / N);

		
	}
}
