package project;

import java.util.InputMismatchException;

public class Groups {

	// �ʵ�
	private Group[] groups;

	// ������
	public Groups() {
		groups = new Group[3];
		groups[0] = new Group("ideal");
		groups[1] = new Group("likely");
		groups[2] = new Group("defect");
	}

	// getter, setter
	public Group[] getGroups() {
		return groups;
	}
	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	// �׷� ���� ���� �޴�
	public void enterCustomerParameter() throws InputMismatchException {
		for(;;) {
			System.out.println();
			System.out.println("=============================");
			System.out.println("1. Set Parameter");
			System.out.println("2. View Parameter");
			System.out.println("3. Edit Parameter");
			System.out.println("4. Back");
			System.out.println("=============================");
			System.out.print("Choose One: ");
			int input = AI_Solution.sc.nextInt();

			if(input == 1) {
				setParameter();
			}
			else if(input == 2) {
				viewParameter();
			}
			else if(input == 3) {
				editParameter();
			}
			else if(input == 4) return;
			else {
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
	
	// �׷� �ϳ��� �����Ͽ� �׷� ���� �Է�
	public void setParameter() throws InputMismatchException {
		String str = whichGroup();
		if(str.equals("end")) return;
		int i = getGroupIdx(str);
		
		for(;;) {
			System.out.println();
			System.out.println("=============================");
			System.out.println("1. Age");
			System.out.println("2. Gender");
			System.out.println("3. Online Spent Time");
			System.out.println("4. Back");
			System.out.println("=============================");
			System.out.print("Choose One: ");
			int input = AI_Solution.sc.nextInt();
			System.out.println();

			if(input == 1) {
				System.out.print("Input Minimum Age: ");
				groups[i].setMinAge(AI_Solution.sc.nextInt());
				System.out.print("Input Maximum Age: ");
				groups[i].setMaxAge(AI_Solution.sc.nextInt());
			}
			else if(input == 2) {
				String gender = inputGender();
				groups[i].setGender(gender);
			}
			else if(input == 3) {
				System.out.print("Input Online Spent Time: ");
				groups[i].setSpentTime(AI_Solution.sc.nextInt());
			}
			else if(input == 4) return;
			else {
				System.out.println("Invalid input. Please try again.");
			}
		}
	}

	// �׷� �ϳ��� �����Ͽ� �׷� ���� ���
	public void viewParameter() {
		String str = whichGroup();
		if(str.equals("end")) return;
		int i = getGroupIdx(str);
		
		System.out.println();
		System.out.printf("[GroupType] %s\n", groups[i].getGroupType().toUpperCase());
		System.out.printf("[Parameter] %s\n", groups[i]);
	}

	// �׷� �ϳ��� �����Ͽ� �׷� ���� ����
	public void editParameter() throws InputMismatchException {
		String str = whichGroup();
		if(str.equals("end")) return;
		int i = getGroupIdx(str);
		
		if(groups[i].noParameter()) {
			System.out.println();
			System.out.println("No parameter. Set the parameter first.");
			return;
		}
		
		System.out.println();
		System.out.printf("[GroupType] %s\n", groups[i].getGroupType().toUpperCase());
		System.out.printf("[Parameter] %s\n", groups[i]);
		
		for(;;) {
			System.out.println();
			System.out.println("=============================");
			System.out.println("1. Age");
			System.out.println("2. Gender");
			System.out.println("3. Online Spent Time");
			System.out.println("4. Back");
			System.out.println("=============================");
			System.out.print("Choose One: ");
			int input = AI_Solution.sc.nextInt();
			System.out.println();

			if(input == 1) {
				System.out.print("Input Minimum Age: ");
				groups[i].setMinAge(AI_Solution.sc.nextInt());
				System.out.print("Input Maximum Age: ");
				groups[i].setMaxAge(AI_Solution.sc.nextInt());
			}
			else if(input == 2) {
				String gender = inputGender();
				groups[i].setGender(gender);
			}
			else if(input == 3) {
				System.out.print("Input Online Spent Time: ");
				groups[i].setSpentTime(AI_Solution.sc.nextInt());
			}
			else if(input == 4) return;
			else {
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
	
	// � �׷��� ������ ����, Ȥ�� ������ ���� ����ڿ��� ���ڿ��� �Է¹޾� ��ȯ�Ѵ�.
	public String whichGroup() {
		for(;;) {
			System.out.println();
			System.out.println("** Press 'end', if you want to exit! **");
			System.out.print("Which group (ideal, likely, defect)? ");
			String str = AI_Solution.sc.next().toLowerCase();
			if(str.equals("end") || str.equals("ideal")
					|| str.equals("likely") || str.equals("defect")) return str;
			else {
				System.out.println();
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
	
	// �׷� Ÿ�� ���ڿ��� �Է��ϸ� �ش� �׷��� ����ִ� �迭�� �ε����� ��ȯ�Ѵ�.
	public int getGroupIdx(String groupType) {
		if(groupType.equals("ideal")) return 0;
		else if(groupType.equals("likely")) return 1;
		else if(groupType.equals("defect")) return 2;
		else return -1;
	}
	
	// ������ female/male�� �Է� �޾� ���ڿ� ��ȯ
	// Customers������ ����ϱ� ������ static
	public static String inputGender() {
		while(true) {
			System.out.print("Input Gender: ");
			String str = AI_Solution.sc.next().toLowerCase();
			if(str.equals("female") || str.equals("male")) return str;
			else {
				System.out.println("Invalid input. Please enter male or female.");
				System.out.println();
			}
		}
	}

}
