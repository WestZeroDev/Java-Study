package algorithm;

import java.util.ArrayList;
import java.util.List;

//완전탐색 > 모의고사
public class P_01 {
	public int[] solution(int[] answers) {
		int[][] pattern = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
		int[] score = new int[3];
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == pattern[0][i % 5]) score[0]++;
			if(answers[i] == pattern[1][i % 8]) score[1]++;
			if(answers[i] == pattern[2][i % 10]) score[2]++;
		}

		int maxScore = -1;
		for(int s : score) {
			if(maxScore < s) maxScore = s;
		}

		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < score.length; i++) {
			if(score[i] == maxScore) {
				list.add(i + 1);
			}
		}

		int[] answer = list.stream().mapToInt(e -> e.intValue()).toArray();
		return answer;
	}
}
