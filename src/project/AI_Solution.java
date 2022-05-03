package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AI_Solution {
	public static Scanner sc = new Scanner(System.in);
	public static Groups groups = new Groups();
	public static Customers customers = new Customers();

	public static void main(String[] args) {
		System.out.println("=============================");
		System.out.println("Title : Customer Segmentation");
		System.out.println("=============================");
		while(true) {
			try {
				displayMenu();
				int input = sc.nextInt();

				if(input == 1) {
					groups.enterCustomerParameter();
				}
				else if(input == 2) {
					customers.enterCustomerData();
				}
				else if(input == 3) {
					customers.summary(groups);
				}
				else if(input == 4) {
					System.out.println("Program Finished.");
					return;
				}
				else {
					System.out.println("Invalid input. Please try again.");
				}
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("Invalid input. Please try again.");
			} catch(Exception e) {

			}
		}
	}

	// 초기 메뉴 출력
	public static void displayMenu() {
		System.out.println();
		System.out.println("=============================");
		System.out.println("1. Enter Customer Parameter");
		System.out.println("2. Enter Customer Data");
		System.out.println("3. Summary");
		System.out.println("4. Quit");
		System.out.println("=============================");
		System.out.print("Choose One: ");
	}
	
}
