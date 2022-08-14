package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//문장 단위로 입력 받고 저장
		BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));		
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		//재료 배열 저장
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		//재료 배열 오름차순 정렬
		Arrays.sort(A);
		//양쪽 끝위 위치를 투 포인터로 지정
		int count = 0;
		int i = 0;
		int j = N - 1;
		//투포인터 이동 원칙
		//A[i] + A[j] > M : j--
		//A[i] + A[j] < M : i++
		//A[i] + A[j] == M : i++; j--; count++
 		while (i < j) {
			if (A[i] + A[j] < M) {
				i++;
			} else if (A[i] + A[j] > M) {
				j--;
			} else {
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
		bf.close();
 	}

}
