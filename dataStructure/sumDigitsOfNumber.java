package dataStructure;

import java.util.Scanner;

public class sumDigitsOfNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환 > String.toCharArray()활용
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		
		int sum = 0;
		
		for (int i = 0; i < cNum.length; i++) {
			sum += cNum[i] - '0';	//cNum[i]를 정수형으로 변환하면서 sum에 더해 누적하기
			//문자열을 숫자형으로 변경 : 아스키코드 활용 (문자와 숫자의 차이는 48) > '1' - 48 or '1' - '0'
		}

		System.out.println(sum);
	}

}
