package simple_program;

import java.util.Scanner;

public class Vote_Count {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 명의 후보가 있습니까? ");
		int n = sc.nextInt();
		int[] vote_count = new int[n];
		System.out.println();

		for(;;) {
			System.out.println("종료하려면 -1을 입력하세요.");
			System.out.printf("1 ~ %d 후보자가 있습니다.\n", n);
			System.out.print("몇 번 후보를 선택하시겠습니까? ");
			int vote = sc.nextInt();
			System.out.println();

			if(vote == -1) {
				System.out.println("프로그램이 종료됩니다.");
				return;
			}

			if(vote < 1 || vote > n) {
				System.out.println("유효한 번호가 아닙니다!");
				System.out.println();
				continue;
			}

			for(int i = 1; i <= n; i++) {
				if(vote == i) {
					vote_count[i - 1]++;
					System.out.println("==== Voting Result ====");
					for(int j = 1; j <= n; j++) {
						System.out.printf("%7d %7d\n", j, vote_count[j - 1]);
					}
					System.out.println("=======================");
					System.out.println();
				}
			}
		}

	}

}
