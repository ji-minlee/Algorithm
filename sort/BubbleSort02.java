package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort02 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		mData[] A = new mData[N];	//데이터 배열 (클래스를 데이터로 담는 배열)
		for (int i = 0; i < N; i++) {
			A[i] = new mData(Integer.parseInt(bf.readLine()), i);
		}
		Arrays.sort(A);		//A배열 정렬
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max < A[i].index - i) {		//정렬 전 index 정렬 후 index 계산의 최댓값 저장
				max = A[i].index - i;
			}
		}
		//안쪽 for문이 몇 번 수행 되었는가?
		//데이터의 정렬 전 index와 정렬 후 index를 비교해 왼쪽으로 가장 많이 이동한 값
		//swap이 일어나지 않는 반복문이 한 번 더 실행되는 것을 감안해 최댓값 + 1
		System.out.println(max + 1);
	} 
}
//Comparable : 자기 자신과 매개변수 객체를 비교
class mData implements Comparable<mData> {
	int value;
	int index;
	
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	
	@Override
	public int compareTo(mData o) {		//value 기준 오름차순 정렬하기 > 매개변수(mData)와의 비교
		return this.value - o.value;
		//같으면 return 0, this가 크면 return 1, this가 작으면 return -1
	}
	
}