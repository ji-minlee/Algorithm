package sort;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	
		int[] A = new int[N];	//자릿수별로 구분해 저장한 배열
		int[] S = new int[N];	//A 합 배열
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();	//A배열 저장
		}
		for (int i = 1; i < N; i++) { 	//삽입 정렬
			int insertPoint = i;
			int insertValue = A[i];
			for (int j = i - 1; j >= 0; j--) {	//현재 범위에서 삽입 위치 찾기
				if(A[j] < A[i]) {	
					insertPoint = j  + 1;
					break;
				}
				if (j == 0) {	
					insertPoint = 0;
				}
			}
			for (int j = i; j > insertPoint; j--) {		//삽입을 위해 삽입 위치에서 i까지 데이터를 한 칸씩 뒤로 밀기
				A[j] = A[j-1];
			}
			A[insertPoint] = insertValue;	//삽입 위치에 현재 데이터 삽입
		}
		S[0] = A[0];	//합 배열 만들기
		for (int i = 1; i < N; i++) {
			S[i] = S[i-1] + A[i];	//합 배열 공식
		}
		int sum = 0; 	//합 배열 총합 구하기
		for (int i = 0; i < N; i++) {
			sum = sum + S[i];
		}
		System.out.println(sum);
		
		
	}

}
