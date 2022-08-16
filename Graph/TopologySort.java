package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	//건물 종류의 수
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();	//데이터 저장 인접 리스트
		for (int i = 0; i <= N; i++) {
			A.add(new ArrayList<>());	//건물의 갯수만큼 인접 리스트 초기화
		}
		
		int[] indegree = new int[N + 1];	//진입 차수 배열
		int[] selfBuild = new int[N + 1];	//자기 자신을 짓는데 걸리는 시간
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			selfBuild[i] = Integer.parseInt(st.nextToken());	//건물을 짓는데 걸리는 시간
			while (true) {	//인접 리스트 초기화
				int preTemp = Integer.parseInt(st.nextToken());
				if (preTemp == -1) {
					break;
				}
				A.get(preTemp).add(i);
				indegree[i]++;
			}
		}
		//위상 정렬 수행하기
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if  (indegree[i] == 0) {	//진입 차수 배열 값이 0인 건물(노드)를 큐에 삽입
				queue.offer(i);
			}
		}
		
		int[] result = new int[N + 1];
		while (!queue.isEmpty()) {
			int now = queue.poll();		//현재 노드 
			for (int next : A.get(now)) {
				indegree[next]--;	//타깃 노드 진입 차수 배열--
				//시간 업데이트 하기
				result[next] = Math.max(result[next], result[now] + selfBuild[now]);
				if (indegree[next] == 0) {	//타깃 노드의 진입 차수가 0이면
					queue.offer(next);	//우선 순위 큐에 타깃 노드 추가
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(result[i] + selfBuild[i]);
		}
	}

}
