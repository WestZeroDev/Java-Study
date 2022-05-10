package algorithm;

import java.util.Scanner;

public class BJ_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* Q1110. 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고,
		 * 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
		 * 26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
		 * 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
		 * N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
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
		

		// Q1274. 소수란, 약수가 1과 자기 자신 두 개 뿐인 수를 말한다.
		// 어떤 수가 입력되면 그 수가 소수인지 판단하시오.
		// 2 이상의 자연수가 입력으로 주어진다.
		// 소수이면 "prime"을 출력, 소수가 아니면 "not prime"을 출력한다.
		int p = sc.nextInt();
		boolean isPrime = true;

		for(int i = 2; i < p; i++) {
			if(p % i == 0) {
				isPrime = false;
				break;
			}
		}

		System.out.println(isPrime ? "Prime" : "Not Prime");
		
		
		// Q1275. 어떤 수 n과 k가 있다. n^k는 n을 k번 곱한 것을 말한다.
		// 공백을 기준으로 n과 k가 주어진다. (n은 0이 아닌 정수, k >= 0)
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
		
		
		// Q1929. M 이상 N 이하의 소수를 모두 출력하는 프로그램을 작성하시오.
		// 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)
		// M 이상 N 이하의 소수가 하나 이상 있는 입력만 주어진다.
		// 에라토스테네스의 체로 풀어 봅시다.
		int m = sc.nextInt();
		int n = sc.nextInt();

		boolean[] prime = new boolean[n + 1];
		// false = 소수, true = 소수 아님
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			for(int j = i * i; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}
		
		for(int i = m; i <= n; i++) {
			if(!prime[i]) System.out.println(i);
		}
		
		
		/* Q8958. "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
		 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
		 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다. OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
		 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다.
		 * 문자열은 O와 X만으로 이루어져 있다. 각 테스트 케이스마다 점수를 출력한다.
		 */
		System.out.print("N : ");
		int resultN = sc.nextInt();
		String[] result = new String[resultN];
		System.out.printf("%d개의 퀴즈 결과를 입력하세요.\n", resultN);
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
		
		
		/* Q2577. 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를
		 * 구하는 프로그램을 작성하시오. 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300,
		 * 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
		 * 첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.
		 * 첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다.
		 * 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
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
		
		
		/* Q10809. 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는
		 * 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
		 * 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
		 * 각각의 알파벳에 대해서, a 첫 등장 위치, b 첫 등장 위치, ... z 첫 등장 위치를 공백으로 구분해서 출력한다.
		 * 만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다.
		 * 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
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
		
		
		/* Q1316. 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
		 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
		 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
		 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
		 * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
		 * 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
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
		
		
		/* Q2908.상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다.
		 * 이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다.
		 * 상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
		 * 상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
		 * 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
		 * 두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
		 * 첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
		 */
//		수학으로 풀기
//		int aa = sc.nextInt();
//		int bb = sc.nextInt();
//		
//		int inverse_aa = (aa % 10) * 100 + ((aa % 100) / 10) * 10 + (aa / 100);
//		int inverse_bb = (bb % 10) * 100 + ((bb % 100) / 10) * 10 + (bb / 100);
//		
//		System.out.println(inverse_aa > inverse_bb ? inverse_aa : inverse_bb);
		
//		문자열로 풀기
		String aa = sc.next();
		String bb = sc.next();
		
		String new_aa = String.valueOf(aa.charAt(2)) + aa.charAt(1) + aa.charAt(0);
		String new_bb = String.valueOf(bb.charAt(2)) + bb.charAt(1) + bb.charAt(0);
		
		System.out.println(Integer.parseInt(new_aa) > Integer.parseInt(new_bb) ? new_aa : new_bb);
	}

}
