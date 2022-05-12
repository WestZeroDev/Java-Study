package algorithm;

//탐욕법(Greedy) > 체육복
public class P_02 {
	public int solution(int n, int[] lost, int[] reserve) {
		int[] now = new int[n];
		for(int i = 0; i < n; i++) {
			now[i] = 1;
		}
		for(int i = 0; i < lost.length; i++) {
			now[lost[i] - 1]--;
		}
		for(int i = 0; i < reserve.length; i++) {
			now[reserve[i] - 1]++;
		}

		for(int i = 0; i < now.length; i++) {
			if(now[i] == 2) {
				if(i > 0 && now[i - 1] == 0) {
					now[i] = 1;
					now[i - 1] = 1;
					continue;
				}
				else if(i < now.length - 1 && now[i + 1] == 0) {
					now[i] = 1;
					now[i + 1] = 1;
					continue;
				}
			}
		}

		int answer = 0;
		for(int i = 0; i < now.length; i++) {
			if(now[i] == 1 || now[i] == 2) {
				answer++;
			}
		}
		return answer;
	}
}
