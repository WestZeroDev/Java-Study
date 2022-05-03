package simple_program;

import java.util.Scanner;

public class Kimbap_Heaven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = 0;
		int i = 0;

		for(;;) {
			if(i == 0) {
				System.out.print("얼마 갖고 있니? : ");
				money = sc.nextInt();
			}
			
			if(money < 0) {
				System.out.println("[에러] 잘못된 입력입니다.");
				continue;
			}
			
			if(money < 2500) {
				System.out.println("[종료] 주문 가능한 메뉴가 없습니다.");
				return;
			}

			i++;
			
			System.out.println("===== MENU =====");
			System.out.println("1. 김밥 2500원");
			System.out.println("2. 라면 3000원");
			System.out.println("3. 떡볶이 4000원");
			System.out.println("4. 돈까스 5000원");
			System.out.println("5. 종료");
			System.out.println("================");
			System.out.print("메뉴 번호 : ");
			int menuChoice = sc.nextInt();
			int price = 0;
			String menuName = "";

			if(menuChoice == 1) {
				price = 2500;
				menuName = "김밥";
			}
			else if(menuChoice == 2) {
				price = 3000;
				menuName = "라면";
			}
			else if(menuChoice == 3) {
				price = 4000;
				menuName = "떡볶이";
			}
			else if(menuChoice == 4) {
				price = 5000;
				menuName = "돈까스";
			}
			else if(menuChoice == 5) {
				System.out.printf("[종료] 잔돈은 %d원입니다.\n", money);
				return;
			}
			else {
				System.out.println("[에러] 유효하지 않은 메뉴입니다.");
				continue;
			}

			if(money >= price) {
				System.out.printf("%s 선택하셨습니다.\n", menuName);
				money -= price;
				System.out.printf("잔돈은 %d원입니다.\n", money);
				continue;
			}

			if(money < price) {
				System.out.println("잔액이 부족합니다.\n다시 선택해주세요.");
			}
		}
		
	}

}
