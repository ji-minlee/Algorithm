package numberTheory;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();	//시작 수
		int N = sc.nextInt();	//종료 수
		int[] A = new int[N + 1];	//소수 배열
		for (int i = 2; i <= N; i++) {
			A[i] = i;	//A배열 초기화 > 각각의 인덱스 값으로
		}
		for (int i = 2; i <= Math.sqrt(N); i++) {	//N의 제곱근까지 반복 > N = a * b로 가정했을 때, a와 b 모두 N의 제곱근보다 클 수 없기 때문
			if (A[i] == 0) {	//소수가 아니면 넘어감
				continue;
			}
			for (int j = i + i; j <= N; j = j + i) {	//배수 지우기
				A[j] = 0;
			}
		}
		for (int i = M; i <= N; i++) {	//출력
			if (A[i] != 0) {
				System.out.println(A[i]);
			}
		}

	}

}
