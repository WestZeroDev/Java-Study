package algorithm;

import java.util.Scanner;

public class BJ_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Q. 30�� �� �ð� ���ϱ�
		// ���� ���� : 0 ~ 23, ���� ���� : 0 ~ 59
		System.out.println("�ð��� �Է��ϼ���. (����� ����)");
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		
		if(minute < 30) {
			hour -= 1;
			minute += 30;
		}
		else minute -= 30;
		
		System.out.printf("30�� ���� %d�� %d���Դϴ�.\n", hour, minute);
		
		
		// Q2438. ù° �ٿ��� �� 1��, ��° �ٿ��� �� 2��, N��° �ٿ��� �� N���� ���
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {

			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
		
		
		// Q2439. �� ������ ���ķ� ���
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
		
		
		// Q10871. ���� N���� �̷���� ���� A�� ���� X�� �־�����.
		// �̶�, A���� X���� ���� ���� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		System.out.print("N (N >= 1) : ");
		int num = sc.nextInt();
		System.out.print("X (X <= 10,000) : ");
		int x = sc.nextInt();
		System.out.print("������ �Է��ϼ���. : ");
		int[] sequence = new int[num];
		
		for(int i = 0; i < num; i++) {
			sequence[i] = sc.nextInt();
		}
		
		for(int k = 0; k < num; k++) {
			if (sequence[k] < x) System.out.print(sequence[k] + " ");
		}
		
		
		// Q10818. N���� ������ �־�����. �̶�, �ּڰ��� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		System.out.print("N : ");
		int nn = sc.nextInt();
		System.out.print("N���� ������ �Է��ϼ���. : ");
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
		
		
		// Q. OX���� ���� ���ϱ�
		System.out.println("���� ��� �Է� : ");
		String result = sc.next().toUpperCase();
		char[] check = result.toCharArray();
		int score = 0;
		
		for(int i = 0; i < result.length(); i++) {
			if (check[i] == 'O') score += 1;
		}
		
		System.out.println(score + "��");
		
		
		// Q1157. ���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
		// �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.
		// ���� ���� ���� ���ĺ��� �빮�ڷ� ����Ѵ�. ��, ���� ���� ���� ���ĺ��� ���� �� �����ϴ� ��쿡�� ?�� ����Ѵ�.
		String str = sc.next().toUpperCase();
		int[] count = new int[26]; // �� ���ĺ� ������ ������ �迭
		int max2 = 0; // ������ �ִ�
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
		
		
		/* Q1152. ���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����. �� ���ڿ����� �� ���� �ܾ ������?
		 * �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.
		 * ù �ٿ� ���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����.
		 * �ܾ�� ���� �� ���� ���еǸ�, ������ �����ؼ� ������ ���� ����.
		 * ���� ���ڿ��� �������� �����ϰų� ���� �� �ִ�.
		 */
		String sentence = sc.nextLine();
		int space = 0;
		
		for(int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) == ' ') space++;
		}
		
		if(sentence.charAt(0) == ' ') space--;
		if(sentence.charAt(sentence.length() - 1) == ' ') space--;

		System.out.println(space + 1);
		
		
		/* Q1712. �������ڴ� ��Ʈ���� �����ϰ� �Ǹ��ϴ� ȸ���̴�.
		 * ��Ʈ�� �Ǹ� ����� ������� A������ ���� ����� ���,
		 * �� ���� ��Ʈ���� �����ϴ� ������ ����� �ΰǺ� �� �� B������ ���� ����� ��ٰ� �Ѵ�.
		 * ���� ��� A=1,000, B=70�̶�� ����. �� ��� ��Ʈ���� �� �� �����ϴ� ���� �� 1,070������ ���,
		 * �� �� �����ϴ� ���� �� 1,700������ ���.
		 * ��Ʈ�� ������ C�������� å���Ǿ��ٰ� �Ѵ�.
		 * �Ϲ������� ���� ����� �÷� ���� ���� ��� ���� �� ����(�Ǹź��)�� �� ���(=�������+�������)���� �������� �ȴ�.
		 * ���ʷ� �� ������ �� ��뺸�� ������ ������ �߻��ϴ� ������ ���ͺб���(BREAK-EVEN POINT)�̶�� �Ѵ�.
		 * A, B, C�� �־����� ��, ���ͺб����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. (A, B, C�� 21�� ������ �ڿ���)
		 * ù ��° �ٿ� ���ͺб��� �� ���ʷ� ������ �߻��ϴ� �Ǹŷ��� ����Ѵ�. ���ͺб����� �������� ������ -1�� ����Ѵ�.
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
