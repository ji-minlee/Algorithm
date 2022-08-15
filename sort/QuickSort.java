package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());	//숫자의 갯수
		int K = Integer.parseInt(st.nextToken());	//K번째 수
		st = new StringTokenizer(bf.readLine());
		int[] A = new int[N];	//숫자 데이터 저장 배열
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); //숫자 데이터 저장 배열에 저장하기
		}
		quickSort(A, 0, N - 1, K - 1);	//퀵 소트 실행
		System.out.println(A[K - 1]);	//출력

	}
	//퀵 소트 함수
	public static void quickSort(int[] A, int S, int E, int K) {
		if (S < E) {
			int pivot = partition(A, S, E);
			if (pivot == K) {	//K번째 수가 pivot이면 더이상 구할 필요 없음
				return;
			} else if (K < pivot) {	//K가 피벗보다 작으면 왼쪽 그룹만 정렬 수행
				quickSort(A, S, pivot - 1, K);
			} else {	//K가 피벗보다 크면 오른쪽 그룹만 정렬 수행
				quickSort(A, pivot + 1, E, K);
			}
		}
	}
	//피벗 구하기 함수
	public static int partition(int[] A, int S, int E) {
		if (S + 1 == E) {	//데이터가 2개인 경우는 바로 비교해 정렬
			if (A[S] > A[E]) {
				swap(A, S, E);
				return E;
			}
		}
		int M = (S + E) / 2;	//중앙값
		swap(A, S, M);	//중앙값을 1번째 요소로 이동
		int pivot = A[S];	//피벗을 시작 위치 값 A[S]로 저장
		int i = S + 1, j = E;
		while (i <= j) {
			while (pivot < A[j] && j > 0) {		//피벗보다 작은 수가 나올 때까지
				j--;
			}
			while (pivot > A[i] && i < A.length - 1) {	//피벗보다 큰 수가 나올 때까지
				i++;
			}
			if (i <= j) {
				swap(A, i++, j--);
			}
		}
		// i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정
		A[S] = A[j];
		A[j] = pivot;
		return j;
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;

	}
}
