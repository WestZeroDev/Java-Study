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
			System.out.println("종료하려면 -1을 입력하세요.");
			System.out.print("좌석을 선택하세요. : ");
			int choice = sc.nextInt();

			if(choice == -1) {
				System.out.println("종료되었습니다.");
				return;
			}

			if(choice < 1 || choice > 10) {
				System.out.println("유효하지 않은 좌석입니다.");
				System.out.println("1 ~ 10번 좌석을 선택하세요.\n");
				continue;
			}

			if(seats[choice - 1] == 'X') {
				System.out.println("이미 예약된 좌석입니다.");
				System.out.println("다른 좌석을 선택해주세요.\n");
				continue;
			}

			for(int j = 1; j < 11; j++) {
				if(choice == j) {
					System.out.println("예약되었습니다!\n");
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
				System.out.println("모든 좌석이 꽉 찼습니다!");
				System.out.println("종료됩니다.");
				return;
			}

			isFull = true;
		}
	}

}
