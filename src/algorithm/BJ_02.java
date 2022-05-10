package algorithm;

import java.util.Scanner;

public class BJ_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* Q1110. 0���� ũ�ų� ����, 99���� �۰ų� ���� ������ �־��� �� ������ ���� ������ �� �� �ִ�. ���� �־��� ���� 10���� �۴ٸ� �տ� 0�� �ٿ� �� �ڸ� ���� �����,
		 * �� �ڸ��� ���ڸ� ���Ѵ�. �� ����, �־��� ���� ���� ������ �ڸ� ���� �տ��� ���� ���� ���� ������ �ڸ� ���� �̾� ���̸� ���ο� ���� ���� �� �ִ�. ���� ���� ����.
		 * 26���� �����Ѵ�. 2+6 = 8�̴�. ���ο� ���� 68�̴�. 6+8 = 14�̴�. ���ο� ���� 84�̴�. 8+4 = 12�̴�. ���ο� ���� 42�̴�. 4+2 = 6�̴�. ���ο� ���� 26�̴�.
		 * ���� ���� 4������ ���� ���� ���ƿ� �� �ִ�. ���� 26�� ����Ŭ�� ���̴� 4�̴�.
		 * N�� �־����� ��, N�� ����Ŭ�� ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 */
		int n1 = sc.nextInt();
		int userN1 = n1;
		int cycle = 0;

		while(true) {
			n1 = (n1 % 10) * 10 + ((n1 / 10) + (n1 % 10)) % 10;
			cycle++;
			if(n1 == userN1) break;
		}

		System.out.println(cycle);
		

		// Q1274. �Ҽ���, ����� 1�� �ڱ� �ڽ� �� �� ���� ���� ���Ѵ�.
		// � ���� �ԷµǸ� �� ���� �Ҽ����� �Ǵ��Ͻÿ�.
		// 2 �̻��� �ڿ����� �Է����� �־�����.
		// �Ҽ��̸� "prime"�� ���, �Ҽ��� �ƴϸ� "not prime"�� ����Ѵ�.
		int p = sc.nextInt();
		boolean isPrime = true;

		for(int i = 2; i < p; i++) {
			if(p % i == 0) {
				isPrime = false;
				break;
			}
		}

		System.out.println(isPrime ? "Prime" : "Not Prime");
		
		
		// Q1275. � �� n�� k�� �ִ�. n^k�� n�� k�� ���� ���� ���Ѵ�.
		// ������ �������� n�� k�� �־�����. (n�� 0�� �ƴ� ����, k >= 0)
		int n2 = sc.nextInt();
		int k = sc.nextInt();
		int nk = 1;
		
		if(k == 0) nk = 1;
		else {
			for(int i = 0; i < k; i++) {
				nk = nk * n2;
			}
		}
		
		System.out.println(nk);
		
		
		// Q1929. M �̻� N ������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����. (1 �� M �� N �� 1,000,000)
		// M �̻� N ������ �Ҽ��� �ϳ� �̻� �ִ� �Է¸� �־�����.
		// �����佺�׳׽��� ü�� Ǯ�� ���ô�.
		int m = sc.nextInt();
		int n = sc.nextInt();

		boolean[] prime = new boolean[n + 1];
		// false = �Ҽ�, true = �Ҽ� �ƴ�
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			for(int j = i * i; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}
		
		for(int i = m; i <= n; i++) {
			if(!prime[i]) System.out.println(i);
		}
		
		
		/* Q8958. "OOXXOXXOOO"�� ���� OX������ ����� �ִ�. O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�.
		 * ������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�. ���� ���, 10�� ������ ������ 3�� �ȴ�.
		 * "OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�. OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���̰� 0���� ũ�� 80���� ���� ���ڿ��� �־�����.
		 * ���ڿ��� O�� X������ �̷���� �ִ�. �� �׽�Ʈ ���̽����� ������ ����Ѵ�.
		 */
		System.out.print("N : ");
		int resultN = sc.nextInt();
		String[] result = new String[resultN];
		System.out.printf("%d���� ���� ����� �Է��ϼ���.\n", resultN);
		for(int i = 0; i < resultN; i++) {
			result[i] = sc.next().toUpperCase();
		}

		int[] score = new int[resultN];
		int plus = 0;

		for(int i = 0; i < resultN; i++) {
			for(int j = 0; j < result[i].length(); j++) {
				if (result[i].charAt(j) == 'O') plus++;
				else plus = 0;
				score[i] += plus;
			}
			System.out.println(score[i]);
			plus = 0;
		}
		
		
		/* Q2577. �� ���� �ڿ��� A, B, C�� �־��� �� A �� B �� C�� ����� ����� 0���� 9���� ������ ���ڰ� �� ���� ����������
		 * ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ��� A = 150, B = 266, C = 427 �̶�� A �� B �� C = 150 �� 266 �� 427 = 17037300,
		 * ����� ��� 17037300 ���� 0�� 3��, 1�� 1��, 3�� 2��, 7�� 2�� ������.
		 * ù° �ٿ� A, ��° �ٿ� B, ��° �ٿ� C�� �־�����. A, B, C�� ��� 100���� ũ�ų� ����, 1,000���� ���� �ڿ����̴�.
		 * ù° �ٿ��� A �� B �� C�� ����� 0 �� �� �� �������� ����Ѵ�.
		 * ��° �ٺ��� �� ��° �ٱ��� A �� B �� C�� ����� 1���� 9������ ���ڰ� ���� �� �� �������� ���ʷ� �� �ٿ� �ϳ��� ����Ѵ�.
		 */
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int res = a * b * c;
		
		String str_res = Integer.toString(res);
		int[] figure = new int[10];

		for(int i = 0; i < str_res.length(); i++) {
			figure[(str_res.charAt(i) - 48)]++;
		}
		
		for(int i = 0; i < figure.length; i++) {
			System.out.println(figure[i]);
		}
		
		
		/* Q10809. ���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����. ������ ���ĺ��� ���ؼ�, �ܾ ���ԵǾ� �ִ� ��쿡��
		 * ó�� �����ϴ� ��ġ��, ���ԵǾ� ���� ���� ��쿡�� -1�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * ù° �ٿ� �ܾ� S�� �־�����. �ܾ��� ���̴� 100�� ���� ������, ���ĺ� �ҹ��ڷθ� �̷���� �ִ�.
		 * ������ ���ĺ��� ���ؼ�, a ù ���� ��ġ, b ù ���� ��ġ, ... z ù ���� ��ġ�� �������� �����ؼ� ����Ѵ�.
		 * ����, � ���ĺ��� �ܾ ���ԵǾ� ���� �ʴٸ� -1�� ����Ѵ�.
		 * �ܾ��� ù ��° ���ڴ� 0��° ��ġ�̰�, �� ��° ���ڴ� 1��° ��ġ�̴�.
		 */
		String str = sc.nextLine();
		int[] alphabet = new int[26];
		
		for(int j = 0; j < 26; j++) {
			alphabet[j] = -1;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == j + 97) {
					alphabet[j] = i;
					break;
				}
			}
			System.out.print(alphabet[j] + " ");
		}
		
		
		/* Q1316. �׷� �ܾ�� �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ� ��Ÿ���� ��츸�� ���Ѵ�.
		 * ���� ���, ccazzzzbb�� c, a, z, b�� ��� �����ؼ� ��Ÿ����, kin�� k, i, n�� �����ؼ� ��Ÿ���� ������ �׷� �ܾ�������,
		 * aabbbccb�� b�� �������� ��Ÿ���� ������ �׷� �ܾ �ƴϴ�.
		 * �ܾ� N���� �Է����� �޾� �׷� �ܾ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * ù° �ٿ� �ܾ��� ���� N�� ���´�. N�� 100���� �۰ų� ���� �ڿ����̴�.
		 * ��° �ٺ��� N���� �ٿ� �ܾ ���´�. �ܾ�� ���ĺ� �ҹ��ڷθ� �Ǿ��ְ� �ߺ����� ������, ���̴� �ִ� 100�̴�.
		 */
		int wordN = sc.nextInt();
		String[] word = new String[wordN];
		int groupword = wordN;
		
		for(int i = 0; i < wordN; i++) {
			word[i] = sc.next();
		}
		
		for(int i = 0; i < wordN; i++) {
			char[] cnt = new char[26];
			for(int j = 0; j < word[i].length(); j++) {
				if(j == 0) {
					cnt[word[i].charAt(j) - 97]++;
					continue;
				}
				if(word[i].charAt(j) == word[i].charAt(j-1)) continue;
				else {
					cnt[word[i].charAt(j) - 97]++;
					if(cnt[word[i].charAt(j) - 97] == 2) {
						groupword--;
						break;
					}
				}
			}
		}
		
		System.out.println(groupword);
		
		
		/* Q2908.������� ���� ����� ������ ���� ���Ѵ�. ����� ���ڸ� �дµ� ������ �ִ�.
		 * �̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���.
		 * ����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.
		 * ����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. ���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�, ����� �� ���� 437�� 398�� �д´�.
		 * ����, ����� �� ���� ū ���� 437�� ū ����� ���� ���̴�.
		 * �� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * ù° �ٿ� ����̰� ĥ�ǿ� ���� �� �� A�� B�� �־�����. �� ���� ���� ���� �� �ڸ� ���̸�, 0�� ���ԵǾ� ���� �ʴ�.
		 */
//		�������� Ǯ��
//		int aa = sc.nextInt();
//		int bb = sc.nextInt();
//		
//		int inverse_aa = (aa % 10) * 100 + ((aa % 100) / 10) * 10 + (aa / 100);
//		int inverse_bb = (bb % 10) * 100 + ((bb % 100) / 10) * 10 + (bb / 100);
//		
//		System.out.println(inverse_aa > inverse_bb ? inverse_aa : inverse_bb);
		
//		���ڿ��� Ǯ��
		String aa = sc.next();
		String bb = sc.next();
		
		String new_aa = String.valueOf(aa.charAt(2)) + aa.charAt(1) + aa.charAt(0);
		String new_bb = String.valueOf(bb.charAt(2)) + bb.charAt(1) + bb.charAt(0);
		
		System.out.println(Integer.parseInt(new_aa) > Integer.parseInt(new_bb) ? new_aa : new_bb);
	}

}
