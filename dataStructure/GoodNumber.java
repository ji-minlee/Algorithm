package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int result = 0;
		long A[] = new long[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		//A 배열에 데이터 저장
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		//A 배열 오름차순 정렬
		Arrays.sort(A);
		for (int k = 0; k < N; k++) {
			//변수 초기화 
			//찾으려 하는 값 : find 
			//포인터를 양 끝에 위치
			long find = A[k];
			int i = 0;
			int j = N - 1;
			// 투 포인터 알고리즘
			//A[i] + A[j] > K : j--
			//A[i] + A[j] < K : i++
			//A[i] + A[j] == K : i++; j--; count++;
			while (i < j) {
				if (A[i] + A[j] == find) {	//찾고자 하는 값일 때
					// find는 서로 다른 두 수의 합이여야 함을 체크
					if (i != k && j != k) { //두 포인터가 k가 아닐 때 결과값에 반영, while문 종료
						result++;
						break;
					} else if (i == k) {	//포인터가 k와 같을 때 포인터 변경
						i++;
					} else if (j == k) {	//포인터가 k와 같을 때 포인터 변경
						j--;
					}
				} else if (A[i] + A[j] < find) {	//합이 찾고자 하는 값보다 작을 때 포인터 i 증가
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(result);
		bf.close();
	}

}
