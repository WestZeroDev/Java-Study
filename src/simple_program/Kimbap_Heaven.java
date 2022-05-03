package simple_program;

import java.util.Scanner;

public class Kimbap_Heaven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = 0;
		int i = 0;

		for(;;) {
			if(i == 0) {
				System.out.print("�� ���� �ִ�? : ");
				money = sc.nextInt();
			}
			
			if(money < 0) {
				System.out.println("[����] �߸��� �Է��Դϴ�.");
				continue;
			}
			
			if(money < 2500) {
				System.out.println("[����] �ֹ� ������ �޴��� �����ϴ�.");
				return;
			}

			i++;
			
			System.out.println("===== MENU =====");
			System.out.println("1. ��� 2500��");
			System.out.println("2. ��� 3000��");
			System.out.println("3. ������ 4000��");
			System.out.println("4. ��� 5000��");
			System.out.println("5. ����");
			System.out.println("================");
			System.out.print("�޴� ��ȣ : ");
			int menuChoice = sc.nextInt();
			int price = 0;
			String menuName = "";

			if(menuChoice == 1) {
				price = 2500;
				menuName = "���";
			}
			else if(menuChoice == 2) {
				price = 3000;
				menuName = "���";
			}
			else if(menuChoice == 3) {
				price = 4000;
				menuName = "������";
			}
			else if(menuChoice == 4) {
				price = 5000;
				menuName = "���";
			}
			else if(menuChoice == 5) {
				System.out.printf("[����] �ܵ��� %d���Դϴ�.\n", money);
				return;
			}
			else {
				System.out.println("[����] ��ȿ���� ���� �޴��Դϴ�.");
				continue;
			}

			if(money >= price) {
				System.out.printf("%s �����ϼ̽��ϴ�.\n", menuName);
				money -= price;
				System.out.printf("�ܵ��� %d���Դϴ�.\n", money);
				continue;
			}

			if(money < price) {
				System.out.println("�ܾ��� �����մϴ�.\n�ٽ� �������ּ���.");
			}
		}
		
	}

}
