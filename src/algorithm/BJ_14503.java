package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14503 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/* Q14503. 로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
		 * 로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며,
		 * 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다.
		 * 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다.
		 * 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수,
		 * c는 서쪽으로 부터 떨어진 칸의 개수이다.
		 * 로봇 청소기는 다음과 같이 작동한다.
		 * 현재 위치를 청소한다.
		 * 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
		 * 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
		 * 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
		 * 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
		 * 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		 * 로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
		 * 첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)
		 * 둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다.
		 * d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
		 * 셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다.
		 * 빈 칸은 0, 벽은 1로 주어진다. 지도의 첫 행, 마지막 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.
		 * 로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.
		 */

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int[][] mapCopy = new int[n][m];

		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int[] robot = {r, c, d};

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				mapCopy[i][j] = map[i][j];
			}
		}
		
		int cleaning = 0;

		mapCopy[robot[0]][robot[1]] = 1;
		cleaning++;
		
		for(;;) {
			if(mapCopy[goStraight(turnLeft(robot))[0]][goStraight(turnLeft(robot))[1]] == 0) {
				mapCopy[goStraight(turnLeft(robot))[0]][goStraight(turnLeft(robot))[1]] = 1;
				robot = goStraight(turnLeft(robot));
				cleaning++;
			}
			else if(mapCopy[robot[0] - 1][robot[1]] == 1 && mapCopy[robot[0] + 1][robot[1]] == 1 
					&& mapCopy[robot[0]][robot[1] - 1] == 1 && mapCopy[robot[0]][robot[1] + 1] == 1) {
				if(map[goBack(robot)[0]][goBack(robot)[1]] == 1) break;
				robot = goBack(robot);
			}
			else robot = turnLeft(robot);
		}
		
		System.out.println(cleaning);
		
	}

	public static int[] turnLeft(int[] robot) {
		int[] tmp = Arrays.copyOf(robot, robot.length);
		if(robot[2] == 0) tmp[2] = 3;
		else tmp[2] = robot[2] - 1;
		return tmp;
	}

	public static int[] goStraight(int[] robot) {
		int[] tmp = Arrays.copyOf(robot, robot.length);
		if(robot[2] == 0) {
			tmp[0] = robot[0] - 1;
		}
		else if(robot[2] == 1) {
			tmp[1] = robot[1] + 1;
		}
		else if(robot[2] == 2) {
			tmp[0] = robot[0] + 1;
		}
		else {
			tmp[1] = robot[1] - 1;
		}
		return tmp;
	}

	public static int[] goBack(int[] robot) {
		int[] tmp = Arrays.copyOf(robot, robot.length);
		if(robot[2] == 0) {
			tmp[0] = robot[0] + 1;
		}
		else if(robot[2] == 1) {
			tmp[1] = robot[1] - 1;
		}
		else if(robot[2] == 2) {
			tmp[0] = robot[0] - 1;
		}
		else {
			tmp[1] = robot[1] + 1;
		}
		return tmp;
	}

}
