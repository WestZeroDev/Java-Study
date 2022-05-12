package algorithm;

//깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버
public class P_03 {
	public int solution(int[] numbers, int target) {
		int answer = dfs(numbers, 0, 0, target);
		return answer;
	}
	
	public int dfs(int[] numbers, int n, int sum, int target) {
		if(n == numbers.length) {
			if(sum == target) return 1;
			else return 0;
		}
		return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
	}
}
