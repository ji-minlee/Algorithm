package sort;

import java.util.Scanner;

public class BubbleSort01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//정렬할 수 갯수
		int[] A = new int[N];	//정렬할 배열 선언
		for (int i = 0; i < N; i++) {	
			A[i] = sc.nextInt();	//정렬할 배열 데이터 저장
		}
		for (int i = 0; i < N - 1; i++) {	//인접한 데이터 값 비교
			for (int j = 0; j < N - 1 - i; j++) {
				if (A[j] > A[j+1]) {	//앞의 데이터가 뒤의 데이터보다 크면
					int temp = A[j];	//앞의 데이터를 temp에 저장
					A[j] = A[j+1];		//앞의 자리에 뒤의 데이터 저장
					A[j+1] = temp;		//뒷 자리에 앞의 데이터 저장
				}
			}
		}
		for (int i = 0; i < N; i++) {	//출력
			System.out.println(A[i]);
		}

	}

}
