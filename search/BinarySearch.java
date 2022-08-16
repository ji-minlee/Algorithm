package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정렬할 수 갯수
		int[] A = new int[N]; // 정렬할 배열
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt(); // A배열 데이터 저장
		}
		Arrays.sort(A); // A배열 정렬하기
		int M = sc.nextInt(); // 탐색할 숫자의 갯수
		for (int i = 0; i < M; i++) {
			boolean find = false;
			int target = sc.nextInt(); // 찾아야 하는 수
			// 이진 탐색 시작
			int start = 0;
			int end = A.length - 1;
			while (start <= end) {

				int midi = (start + end) / 2; // 중간 인덱스
				int midV = A[midi]; // 중앙값
				if (midV > target) { // 중앙값 > target
					end = midi - 1;
				} else if (midV < target) { // 중앙값 < target
					start = midi + 1;
				} else {
					find = true; // 찾았으므로 반복문 종료
					break;
				}
			}
			if (find) { // 찾았으면
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
