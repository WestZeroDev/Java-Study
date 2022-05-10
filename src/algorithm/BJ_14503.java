package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14503 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/* Q14503. �κ� û�ұⰡ �־����� ��, û���ϴ� ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * �κ� û�ұⰡ �ִ� ��Ҵ� N��M ũ���� ���簢������ ��Ÿ�� �� ������,
		 * 1��1ũ���� ���簢�� ĭ���� �������� �ִ�. ������ ĭ�� �� �Ǵ� �� ĭ�̴�.
		 * û�ұ�� �ٶ󺸴� ������ ������, �� ������ ��, ��, ��, ���� �ϳ��̴�.
		 * ������ �� ĭ�� (r, c)�� ��Ÿ�� �� �ְ�, r�� �������κ��� ������ ĭ�� ����,
		 * c�� �������� ���� ������ ĭ�� �����̴�.
		 * �κ� û�ұ�� ������ ���� �۵��Ѵ�.
		 * ���� ��ġ�� û���Ѵ�.
		 * ���� ��ġ���� ���� ������ �������� ���� ������� ���ʴ�� ������ ĭ�� Ž���Ѵ�.
		 * ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
		 * ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
		 * �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
		 * �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
		 * �κ� û�ұ�� �̹� û�ҵǾ��ִ� ĭ�� �� û������ ������, ���� ����� �� ����.
		 * ù° �ٿ� ���� ũ�� N�� ���� ũ�� M�� �־�����. (3 �� N, M �� 50)
		 * ��° �ٿ� �κ� û�ұⰡ �ִ� ĭ�� ��ǥ (r, c)�� �ٶ󺸴� ���� d�� �־�����.
		 * d�� 0�� ��쿡�� ������, 1�� ��쿡�� ������, 2�� ��쿡�� ������, 3�� ��쿡�� ������ �ٶ󺸰� �ִ� ���̴�.
		 * ��° �ٺ��� N���� �ٿ� ����� ���°� ���ʺ��� ���� �������, �� ���� ���ʺ��� ���� ������� �־�����.
		 * �� ĭ�� 0, ���� 1�� �־�����. ������ ù ��, ������ ��, ù ��, ������ ���� �ִ� ��� ĭ�� ���̴�.
		 * �κ� û�ұⰡ �ִ� ĭ�� ���´� �׻� �� ĭ�̴�.
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
