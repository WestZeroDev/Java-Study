package project;

import java.util.InputMismatchException;

public class Groups {

	// 필드
	private Group[] groups;

	// 생성자
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

	// 그룹 정보 관리 메뉴
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
	
	// 그룹 하나를 선택하여 그룹 정보 입력
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

	// 그룹 하나를 선택하여 그룹 정보 출력
	public void viewParameter() {
		String str = whichGroup();
		if(str.equals("end")) return;
		int i = getGroupIdx(str);
		
		System.out.println();
		System.out.printf("[GroupType] %s\n", groups[i].getGroupType().toUpperCase());
		System.out.printf("[Parameter] %s\n", groups[i]);
	}

	// 그룹 하나를 선택하여 그룹 정보 수정
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
	
	// 어떤 그룹을 선택할 건지, 혹은 종료할 건지 사용자에게 문자열을 입력받아 반환한다.
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
	
	// 그룹 타입 문자열을 입력하면 해당 그룹이 들어있는 배열의 인덱스로 반환한다.
	public int getGroupIdx(String groupType) {
		if(groupType.equals("ideal")) return 0;
		else if(groupType.equals("likely")) return 1;
		else if(groupType.equals("defect")) return 2;
		else return -1;
	}
	
	// 성별을 female/male로 입력 받아 문자열 반환
	// Customers에서도 사용하기 때문에 static
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
