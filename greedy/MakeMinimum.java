package greedy;

import java.util.Scanner;

public class MakeMinimum {
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String example = sc.nextLine();
		String[] str = example.split("-");	//들어온 데이터를 "-" 기호를 기준으로 split
		for (int i = 0; i < str.length; i++) {
			int temp = mySum(str[i]);	//결과값 = mySum 함수 수행
			if (i == 0) {	//가장 앞 데이터일 때
				answer = answer + temp;	//answer에 결괏값 더하기
			} else {
				answer = answer - temp;	//answer에 결괏값 빼기
			}
		}
		System.out.println(answer);	//출력
 
	}
	
	static int mySum(String a) {	//현재 String에 있는 수를 모두 더하는 함수
		int sum = 0;
		String temp[] = a.split("[+]");	//현재 들어온 String값을 "+"기호 기준으로 split 수행
		for (int i = 0; i <temp.length; i++) {
			sum += Integer.parseInt(temp[i]);	//리턴값에 더하기
		}
		return sum;
	}

}
