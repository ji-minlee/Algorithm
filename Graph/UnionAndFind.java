package Graph;

import java.util.Scanner;

public class UnionAndFind {
	public static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 원소 갯수
		int M = sc.nextInt();	//질의 개수
		parent = new int[N + 1];	//대표 노드 저장 배열
		for (int i = 0; i <= N; i++) {	//대표 노드를 자기 자신으로 초기화
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			int question = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (question == 0) {	//집합 합치기 -> union연산
				union(a, b);
			} else {	//같은 집합의 원소인지 확인
				if (checkSame(a, b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	public static void union(int a, int b) {	//union 연산 : 대표 노드끼리 연결
		a = find(a);
		b = find(b);
		if (a != b) {	
			parent[b] = a;
		}
	}
	
	public static int find(int a) {		//find 연산
		if (a == parent[a]) {	//a가 대표 노드면 리턴
			return a;
		} else {	//재귀함수 형태
			return parent[a] = find(parent[a]);
		}
	}
	
	public static boolean checkSame(int a, int b) {	//CheckSame > 두 원소가 같은 집합인지 확인
		a = find(a);
		b = find(b);
		if (a == b) {
			return true;
		}
		return false;
	}
}
