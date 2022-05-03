package project;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Customers {
	
	// 필드
	private Customer[] customers;

	// 생성자
	public Customers() {}
	public Customers(int n) {
		customers = new Customer[n];
	}

	// getter, setter
	public Customer[] getCustomers() {
		return customers;
	}
	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	// 배열 원소(객체) 생성
	public void init() {
		for(int i = 0; i < customers.length; i++) {
			customers[i] = new Customer(i + 1);
		}
	}
	
	// 배열의 길이
	public int length() {
		return customers.length;
	}
	
	// 고객 정보 관리 메뉴
	public void enterCustomerData() throws InputMismatchException {
		for(;;) {
			System.out.println();
			System.out.println("=============================");
			System.out.println("1. Set Customer Data");
			System.out.println("2. View Customer Data");
			System.out.println("3. Edit Customer Data");
			System.out.println("4. Back");
			System.out.println("=============================");
			System.out.print("Choose One: ");
			int input = AI_Solution.sc.nextInt();

			if(input == 1) {
				setCustomerData();
			}
			else if(input == 2) {
				viewCustomerData();
			}
			else if(input == 3) {
				editCustomerData();
			}
			else if(input == 4) return;
			else {
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
	
	// 고객 정보 입력
	public void setCustomerData() throws InputMismatchException {
		// 고객을 추가로 입력할 경우 기존에 있던 고객을 copy에 복사한다.
		Customers copy = new Customers();
		if(Customer.getCount() != 0) {
			copy.customers = Arrays.copyOf(customers, customers.length);
		}
		
		// 입력할 고객 수 입력
		System.out.println();
		System.out.println("** Press -1, if you want to exit! **");
		System.out.print("How many customers to input? ");
		int n = AI_Solution.sc.nextInt();
		if(n == -1) return;
		
		// 입력할 고객 수만큼 배열 생성
		customers = new Customer[n];
		init();
		
		// 고객 정보 입력
		for(int i = 0; i < n;) {
			System.out.println();
			System.out.printf("===== Customer %d Info. ======\n", i + 1);
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
				System.out.print("Input Age: ");
				customers[i].setAge(AI_Solution.sc.nextInt());
			} else if(input == 2) {
				String gender = Groups.inputGender();
				customers[i].setGender(gender);
			} else if(input == 3) {
				System.out.print("Input Online Spent Time: ");
				customers[i].setSpentTime(AI_Solution.sc.nextInt());
			} else if(input == 4) {
				i++;
			} else {
				System.out.println("Invalid input. Please try again.");
			}
		}
		
		if(Customer.getCount() != n) {
			// 고객이 추가 입력 된 경우 새로 추가 된 고객을 add에 복사한다.
			Customers add = new Customers();
			add.customers = Arrays.copyOf(customers, customers.length);
			// 기존 고객이 복사 된 copy와 add를 합쳐 customers를 만든다.
			customers = Arrays.copyOf(copy.customers, copy.length() + add.length());
			System.arraycopy(add.customers, 0, customers, copy.length(), add.length());
			for(int i = 0; i < customers.length; i++) {
				customers[i].setIndex(i + 1);
			}
		}
	}

	// 전체 고객 정보 출력
	public void viewCustomerData() {
		if(Customer.getCount() == 0) {
			System.out.println("No Customer. Set the customer data first.");
			return;
		}
		
		System.out.println();
		System.out.println("======= Customer Info. =======");
		for(int i = 0; i < customers.length; i++) {
			System.out.println(customers[i]);
		}
	}

	// 전체 고객 중 한 명을 선택하여 고객 정보 수정
	public void editCustomerData() throws InputMismatchException {
		if(Customer.getCount() == 0) {
			System.out.println("No customer. Set customer data first.");
			return;
		}
		
		System.out.println();
		System.out.println("======= Customer Info. =======");
		for(int i = 0; i < customers.length; i++) {
			System.out.println(customers[i]);
		}
		
		System.out.println();
		System.out.printf("Which customer do you want to edit? (1 ~ %d) ", customers.length);
		int idx = AI_Solution.sc.nextInt();
		if(!(idx >= 1 && idx <= customers.length)) return;
		
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
				System.out.print("Input Age: ");
				customers[idx - 1].setAge(AI_Solution.sc.nextInt());
			} else if(input == 2) {
				String gender = Groups.inputGender();
				customers[idx - 1].setGender(gender);
			} else if(input == 3) {
				System.out.print("Input Online Spent Time: ");
				customers[idx - 1].setSpentTime(AI_Solution.sc.nextInt());
			} else if(input == 4) return;
			else {
				System.out.println("Invalid input. Please try again.");
			}
		}
	}

	// 전체 고객을 그룹별로 분류 후 결과 출력
	public void summary(Groups groups) {
		classify(groups);
		for(int i = 0; i < 3; i++) {
			viewbyGroup(groups.getGroups()[i]);
		}
		viewOthers();
	}
	
	// 전체 고객을 그룹별로 분류하여 고객의 그룹 타입 설정
	public void classify(Groups groups) {
		if(Customer.getCount() != 0) {
			for(int i = 0; i < customers.length; i++) {
				customers[i].setGroupType("others");
				if(customers[i].classify(groups.getGroups()[2])) customers[i].setGroupType("defect");
				else if(customers[i].classify(groups.getGroups()[1])) customers[i].setGroupType("likely");
				else if(customers[i].classify(groups.getGroups()[0])) customers[i].setGroupType("ideal");
			}
		}
	}
	
	// 전체 고객을 검색하며 해당 그룹에 속하는 고객 출력
	public void viewbyGroup(Group group) {
		System.out.println();
		System.out.println("=============================");
		System.out.printf("%s Group : %d customer(s)\n", group.getGroupType().toUpperCase(), countbyGroup(group.getGroupType()));
		System.out.printf("[Parameter] %s\n", group);
		System.out.println("=============================");
		if(countbyGroup(group.getGroupType()) == 0) System.out.println("No Customer.");
		else {
			for(int i = 0; i < customers.length; i++) {
				if(customers[i].getGroupType().equals(group.getGroupType())) {
					System.out.println(customers[i]);
				}
			}
		}
	}

	// 전체 고객을 검색하며 해당 그룹에 속하는 고객 수 반환
	public int countbyGroup(String groupType) {
		if(Customer.getCount() == 0) return 0;
		else {
			int count = 0;
			for(int i = 0; i < customers.length; i++) {
				if(groupType.equals(customers[i].getGroupType())) {
					count++;
				}
			}
			return count;
		}
	}
	
	// 전체 고객을 검색하며 어느 그룹에도 속하지 않는 고객 출력
	public void viewOthers() {
		System.out.println();
		System.out.println("=============================");
		System.out.printf("Others : %d customer(s)\n", countbyGroup("others"));
		System.out.println("=============================");
		if(countbyGroup("others") == 0) System.out.println("No Customer.");
		else {
			for(int i = 0; i < customers.length; i++) {
				if(customers[i].getGroupType().equals("others")) {
					System.out.println(customers[i]);
				}
			}
		}
	}

}
