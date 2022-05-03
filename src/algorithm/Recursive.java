package algorithm;

import java.util.Scanner;

public class Recursive {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		// ��� ���丮��
		System.out.println(factorial(n));
		// ��� �Ǻ���ġ
		System.out.println(fibonacci(n));
		
	}

	public static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		else {
			return n = n * factorial(n - 1);
		}
	}
	
	public static int fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		else if(n < 3) {
			return 1;
		}
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
}
