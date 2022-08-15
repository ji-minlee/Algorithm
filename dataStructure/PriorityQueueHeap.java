package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class PriorityQueueHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
			int firstAbs = Math.abs(o1);
			int secondAbs = Math.abs(o2);
			if (firstAbs == secondAbs) {
				return o1 > o2 ? 1 : -1;	//절댓값이 같으면 음수 우선 정렬
			} else {	
				return firstAbs - secondAbs;	//절댓값을 기준으로 정렬
			}
		});
		for (int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if (request == 0) {		//x=0이면
				if (MyQueue.isEmpty()) {	//큐가 비어있다면	
					System.out.println("0");	//0을 출력
				} else {	//비어있지 않으면
					System.out.println(MyQueue.poll());	//절댓값이 최소인 값을 출력(음수 우선)
				}
			} else {	//x가 0이 아니면
				MyQueue.add(request);	//새로운 값을 추가하고 정렬한다
			}
		}
	}

}
