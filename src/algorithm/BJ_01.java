package algorithm;

import java.util.Scanner;

public class BJ_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Q. 30분 전 시각 구하기
		// 시의 범위 : 0 ~ 23, 분의 범위 : 0 ~ 59
		System.out.println("시간을 입력하세요. (띄어쓰기로 구분)");
		int hour = sc.nextInt();
		int minute = sc.nextInt();

		if(minute < 30) {
			hour -= 1;
			minute += 30;
		}
		else minute -= 30;
		System.out.printf("30분 전은 %d시 %d분입니다.\n", hour, minute);


		// Q2438. 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍기
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}


		// Q2439. 별 오른쪽 정렬로 찍기
		int m = sc.nextInt();
		for(int i = 1; i <= m; i++) {
			for(int k = m; k > i; k--) {
				System.out.print(" ");
			}
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}


		// Q10871. 정수 N개로 이루어진 수열 A와 정수 X가 주어진다.
		// 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
		System.out.print("N (N >= 1) : ");
		int num = sc.nextInt();
		System.out.print("X (X <= 10,000) : ");
		int x = sc.nextInt();
		System.out.print("수열을 입력하세요. : ");
		int[] sequence = new int[num];

		for(int i = 0; i < num; i++) {
			sequence[i] = sc.nextInt();
		}

		for(int k = 0; k < num; k++) {
			if (sequence[k] < x) System.out.print(sequence[k] + " ");
		}


		// Q10818. N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
		System.out.print("N : ");
		int nn = sc.nextInt();
		System.out.print("N개의 정수를 입력하세요. : ");
		int[] arr = new int[nn];

		for(int i = 0; i < nn; i++) {
			arr[i] = sc.nextInt();
		}

		int min = arr[0];
		int max = arr[0];

		for(int i = 1; i < nn; i++) {
			if (arr[i] < min) min = arr[i];
			if (arr[i] > max) max = arr[i];
		}
		System.out.println(min + max);


		// Q. OX퀴즈 점수 구하기
		System.out.println("퀴즈 결과 입력 : ");
		String result = sc.next().toUpperCase();
		char[] check = result.toCharArray();
		int score = 0;

		for(int i = 0; i < result.length(); i++) {
			if (check[i] == 'O') score += 1;
		}
		System.out.println(score + "점");


		// Q1157. 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
		// 대문자와 소문자를 구분하지 않는다.
		// 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
		String str = sc.next().toUpperCase();
		int[] count = new int[26]; // 각 알파벳 개수를 저장할 배열
		int max2 = 0; // 개수의 최댓값
		char maxLetter = ' ';

		for(int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 65]++;
		}

		for(int k = 0; k < 26; k++) {
			if(max2 < count[k]) {
				max2 = count[k];
				maxLetter = (char)(k + 65);
			}
			else if(max2 == count[k]) maxLetter = '?';
		}
		System.out.println(maxLetter);


		/* Q1152. 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까?
		 * 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
		 * 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
		 * 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
		 * 또한 문자열은 공백으로 시작하거나 끝날 수 있다.
		 */
		String sentence = sc.nextLine();
		int space = 0;

		for(int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) == ' ') space++;
		}

		if(sentence.charAt(0) == ' ') space--;
		if(sentence.charAt(sentence.length() - 1) == ' ') space--;
		System.out.println(space + 1);


		/* Q1712. 월드전자는 노트북을 제조하고 판매하는 회사이다.
		 * 노트북 판매 대수에 상관없이 A만원의 고정 비용이 들며,
		 * 한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.
		 * 예를 들어 A=1,000, B=70이라고 하자. 이 경우 노트북을 한 대 생산하는 데는 총 1,070만원이 들며,
		 * 열 대 생산하는 데는 총 1,700만원이 든다.
		 * 노트북 가격이 C만원으로 책정되었다고 한다.
		 * 일반적으로 생산 대수를 늘려 가다 보면 어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다.
		 * 최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.
		 * A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오. (A, B, C는 21억 이하의 자연수)
		 * 첫 번째 줄에 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력한다. 손익분기점이 존재하지 않으면 -1을 출력한다.
		 */
		int fixCost = sc.nextInt();
		int varCost = sc.nextInt();
		int price = sc.nextInt();
		int bepoint = 0;

		if(price <= varCost) {
			bepoint = -1;
			System.out.println(bepoint);
			return;
		}

		bepoint = fixCost / (price - varCost) + 1;
		System.out.println(bepoint);
	}

}
