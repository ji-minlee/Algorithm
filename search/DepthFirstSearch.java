package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DepthFirstSearch {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//노드 갯수
		int m = Integer.parseInt(st.nextToken());	//에지 갯수
		A = new ArrayList[n + 1];	//그래프 데이터 저장 인접 리스트
		visited = new boolean[n + 1];	//방문 기록 저장 배열
		for (int i = 1; i < n + 1; i++) {
			A[i] = new ArrayList<Integer>();	//A인접 리스트의 각 ArrayList 초기화
		}
		for (int i = 0; i < m; i++) {	//A 인접 리스트에 그래프 데이터 저장
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);	//양방향 에지이므로 양쪽에 에지를 더하기
			A[e].add(s);
		}
		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {	// 방문하지 않은 노드가 있으면
				count++;	//연결 요소 갯수 ++
				DFS(i);		//DFS 실행
			}
		}
		System.out.println(count);
	}
	
	//DFS 구현
	static void DFS(int v) {
		if (visited[v]) { 	//현재 노드 == 방문 노드 > return
			return;
		}
		visited[v] =  true;		//visited 배열에 현재 노드 방문 기록하기
		for (int i : A[v]) {	
			if (visited[i] == false) {	//현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행 > 재귀함수 형태
				DFS(i);
			}
		}
	}

}
