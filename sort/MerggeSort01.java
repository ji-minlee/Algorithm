package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MerggeSort01 {
	public static int[] A, tmp;
	public static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());	//정렬할 수 개수
		A = new int[N + 1];		//정렬할 배열 선언
		tmp = new int[N + 1];	//정렬할 때 사용할 임시 배열 선언
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());		//A배열에 데이터 저장
		}
		mergeSort(1, N);	//병합 정렬 수행하기
		for (int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	//병합 정렬 수행하기
	private static void mergeSort(int s, int e) {
		if (e - s < 1) {
			return;
		}
		int m = s + (e - s) / 2;
		//재귀함수 형태로 구현
		mergeSort(s, m);
		mergeSort(m+1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];	//임시 배열 데이터 저장
		}
		int k = s;
		int index1 = s;		//앞 그룹 시작점
		int index2 = m + 1;	//뒷 그룹 시작점
		
		//두 그룹을 병합하는 로직
		while (index1 <= m && index2 <= e) {	
			//양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동
			if (tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) {	//한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while (index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}

}
