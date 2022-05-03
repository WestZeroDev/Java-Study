package project;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Customers {
	
	// �ʵ�
	private Customer[] customers;

	// ������
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

	// �迭 ����(��ü) ����
	public void init() {
		for(int i = 0; i < customers.length; i++) {
			customers[i] = new Customer(i + 1);
		}
	}
	
	// �迭�� ����
	public int length() {
		return customers.length;
	}
	
	// �� ���� ���� �޴�
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
	
	// �� ���� �Է�
	public void setCustomerData() throws InputMismatchException {
		// ���� �߰��� �Է��� ��� ������ �ִ� ���� copy�� �����Ѵ�.
		Customers copy = new Customers();
		if(Customer.getCount() != 0) {
			copy.customers = Arrays.copyOf(customers, customers.length);
		}
		
		// �Է��� �� �� �Է�
		System.out.println();
		System.out.println("** Press -1, if you want to exit! **");
		System.out.print("How many customers to input? ");
		int n = AI_Solution.sc.nextInt();
		if(n == -1) return;
		
		// �Է��� �� ����ŭ �迭 ����
		customers = new Customer[n];
		init();
		
		// �� ���� �Է�
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
			// ���� �߰� �Է� �� ��� ���� �߰� �� ���� add�� �����Ѵ�.
			Customers add = new Customers();
			add.customers = Arrays.copyOf(customers, customers.length);
			// ���� ���� ���� �� copy�� add�� ���� customers�� �����.
			customers = Arrays.copyOf(copy.customers, copy.length() + add.length());
			System.arraycopy(add.customers, 0, customers, copy.length(), add.length());
			for(int i = 0; i < customers.length; i++) {
				customers[i].setIndex(i + 1);
			}
		}
	}

	// ��ü �� ���� ���
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

	// ��ü �� �� �� ���� �����Ͽ� �� ���� ����
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

	// ��ü ���� �׷캰�� �з� �� ��� ���
	public void summary(Groups groups) {
		classify(groups);
		for(int i = 0; i < 3; i++) {
			viewbyGroup(groups.getGroups()[i]);
		}
		viewOthers();
	}
	
	// ��ü ���� �׷캰�� �з��Ͽ� ���� �׷� Ÿ�� ����
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
	
	// ��ü ���� �˻��ϸ� �ش� �׷쿡 ���ϴ� �� ���
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

	// ��ü ���� �˻��ϸ� �ش� �׷쿡 ���ϴ� �� �� ��ȯ
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
	
	// ��ü ���� �˻��ϸ� ��� �׷쿡�� ������ �ʴ� �� ���
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
