package simple_program;

import java.util.Scanner;

public class Seat_Reservation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] seats = new char[10];
		for(int i = 0; i < 10; i++) {
			seats[i] = 'O';
		}

		boolean isFull = true;

		for(;;) {
			System.out.println("======= SEATS =======");
			System.out.println("1 2 3 4 5 6 7 8 9 10");
			System.out.println("=====================");
			for(int i = 0; i < 10; i++) {
				System.out.printf("%c ", seats[i]);
			}
			System.out.println();
			System.out.println("�����Ϸ��� -1�� �Է��ϼ���.");
			System.out.print("�¼��� �����ϼ���. : ");
			int choice = sc.nextInt();

			if(choice == -1) {
				System.out.println("����Ǿ����ϴ�.");
				return;
			}

			if(choice < 1 || choice > 10) {
				System.out.println("��ȿ���� ���� �¼��Դϴ�.");
				System.out.println("1 ~ 10�� �¼��� �����ϼ���.\n");
				continue;
			}

			if(seats[choice - 1] == 'X') {
				System.out.println("�̹� ����� �¼��Դϴ�.");
				System.out.println("�ٸ� �¼��� �������ּ���.\n");
				continue;
			}

			for(int j = 1; j < 11; j++) {
				if(choice == j) {
					System.out.println("����Ǿ����ϴ�!\n");
					seats[j-1] = 'X';
					continue;
				}
			}

			for(int i = 0; i < 10; i++) {
				if(seats[i] == 'O') {
					isFull = false;
					break;
				}
			}

			if(isFull == true) {
				System.out.println("��� �¼��� �� á���ϴ�!");
				System.out.println("����˴ϴ�.");
				return;
			}

			isFull = true;
		}
	}

}
