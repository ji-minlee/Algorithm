package dataStructure;

import java.util.Scanner;

public class SumOfConsecutiveNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//사용 변수 초기화
		//N이 15일 때 숫자 15만 뽑는 경우의 수를 미리 넣고 초기화 > count = 1
		int count = 1;
		int startIndex = 1;
		int endIndex = 1;
		int sum = 1;
		
		//투 포인터 이동 원칙
		//sum > N : sum = sum - startIndex; startIndex++
		//sum < N : endIndex++; sum = sum + endIndex
		//sum == N : endIndex++; sum = sum + endIndex; count++
		
		//startIndex를 오른쪽으로 한 칸 이동 : 연속된 자연수에서 왼쪽 값을 삭제
		//endIndex를 오른쪽으로 한 칸 이동 : 연속된 자연수의 범위를 한 칸 더 확장
		//같을 때는 경우의 수를 1증가 > endIndex를 오른쪽으로 한 칸 이동
		while (endIndex != N) {
			if (sum == N) {	//현재 연속 합이 N과 같은 경우
				count++;
				endIndex++;
				sum = sum + endIndex;
			} else if (sum > N) {	//현재 연속 합이 N보다 큰 경우
				sum = sum - startIndex;
				startIndex++;
			} else {	//현재 연속 합이 N보다 작은 경우
				endIndex++;
				sum = sum + endIndex;
			}
		}
		System.out.println(count);
	}

}
