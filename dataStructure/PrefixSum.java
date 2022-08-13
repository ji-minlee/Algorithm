package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum {

	public static void main(String[] args) throws IOException {
		//bufferedreader, inputstreamreader를 사용해 라인 단위로 데이터 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//읽어온 데이터를 stringtokenizer를 사용해 나누기
		StringTokenizer st = new StringTokenizer(br.readLine());
		//bufferedreader의 기본은 string이므로 int형 변환
		//띄어쓰기 단위로 읽을 때는 nextToken()
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//구간합 공식을 편하게 사용하기 위해 합 배열의 크기는 주어진 숫자 개수 +1
		long[] S = new long[N+1];
		//새로운 줄 읽기 
		st = new StringTokenizer(br.readLine());
		// 합 배열 공식 : S[i] = S[i-1] + A[i]
		for (int i = 1; i <= N; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		//구간 합 공식 : S[j] - S[i-1]
		for (int q = 0; q < M; q++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(S[j] - S[i-1]);
		}
	}

}
