package dataStructure;

import java.util.Scanner;

public class DivisionRemainderSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];
		long answer = 0;
		//합 배열 공식으로는 S[0]은 불가능 하므로 직접 저장한다
		S[0] = sc.nextInt();
		//수열 합 배열 만들기
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + sc.nextInt();
		}
		//합 배열의 모든 값에 %연산 수행하기
		for (int i = 0; i < N; i++) {
			int remainder = (int) (S[i] % M);
			//0~i까지의 구간 합 자체가 0일 때 정답에 더하기 > M으로 나누어 떨어진다는 뜻이기 때문
			if (remainder == 0) {
				answer++;
			}
			//나머지가 같은 인덱스의 개수 카운팅 하기
			C[remainder]++;
		}
		
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {
				//나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기 
				//조합 활용 nCm 
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);

	}

}
