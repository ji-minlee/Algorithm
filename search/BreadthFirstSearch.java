package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//노드 갯수
		int M = sc.nextInt();	//에지 갯수
		int start = sc.nextInt();	//시작점
		A = new ArrayList[N + 1];	//그래프 데이터 저장 인접 리스트
		for (int i = 1; i <= N; i++) {	//A 인접 리스트의 각 ArrayList 초기화
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {	//A 인접 리스트에 그래프 데이터 저장
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		//번호가 작은 것을 먼저 방문하기 위해 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		visited = new boolean[N + 1];	//방문 배열 초기화
		BFS(start);
	}
	
	//BFS 구현
	private static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();	//큐 자료 구조에 시작 노드 삽입
		queue.add(Node);
		visited[Node] = true;	//VISITED 배열에 현재 노드 방문 기록
		
		while (!queue.isEmpty()) {	//큐가 비어 있을 때 까지
			int nowNode = queue.poll();		//큐에서 노드 데이터 가져오기 (poll)
			System.out.print(nowNode + " ");	//출력
			for (int i : A[nowNode]) {	//현재 노드의 연결 중 미방문 노드를 큐에 삽입하고 방문 배열에 기록
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
