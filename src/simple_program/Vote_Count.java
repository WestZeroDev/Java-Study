package simple_program;

import java.util.Scanner;

public class Vote_Count {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� ���� �ĺ��� �ֽ��ϱ�? ");
		int n = sc.nextInt();
		int[] vote_count = new int[n];
		System.out.println();

		for(;;) {
			System.out.println("�����Ϸ��� -1�� �Է��ϼ���.");
			System.out.printf("1 ~ %d �ĺ��ڰ� �ֽ��ϴ�.\n", n);
			System.out.print("�� �� �ĺ��� �����Ͻðڽ��ϱ�? ");
			int vote = sc.nextInt();
			System.out.println();

			if(vote == -1) {
				System.out.println("���α׷��� ����˴ϴ�.");
				return;
			}

			if(vote < 1 || vote > n) {
				System.out.println("��ȿ�� ��ȣ�� �ƴմϴ�!");
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
