package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RadixSort01 {

	public static int[] A;
	public static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());	//정렬할 수 갯수
		A = new int[N];		//정렬할 배열 선언
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());		//A배열 데이터 저장
		}
		br.close();
		RadixSort(A, 5);	//기수 정렬 함수 수행
		//출력
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();

	}
	//기수 정렬 함수 구현
	public static void RadixSort(int[] A, int maxSize) {
		int[] output = new int[A.length];	//임시 정렬을 위한 배열
		int jarisu = 1;		//현재 자릿수를 표현하는 수
		int count = 0;
		//로직 부분
		while (count != maxSize) {	//최대 자릿수만큼 반복
			int[] bucket = new int[10];		//현재 자릿수들의 분포를 합 배열의 형태로 알려주는 배열 ex) bucket[4] > 현재 기준 자릿값이 0~4까지 몇 개의 데이터가 있는지 저장
			for (int i = 0; i < A.length; i++) {	
				bucket[(A[i] / jarisu) % 10]++;
			}
			for (int i = 1; i < 10; i++) {	//합 배열 공식으로 bucket을 합 배열 형태로 변경
				bucket[i] += bucket[i - 1];
			}
			for (int i = A.length - 1; i >= 0; i--) {	//output 배열에 저장하기
				output[bucket[A[i] / jarisu % 10] -1] = A[i];
				bucket[(A[i] / jarisu) % 10]--;
			}
			for (int i = 0; i < A.length; i++) {	//다음 자릿수 이동을 위해 A배열에 output 데이터 저장하기
				A[i] = output[i];
			}
			jarisu = jarisu * 10;
			count++;
		}
	}

}
