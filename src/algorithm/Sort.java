package algorithm;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {

		int[] arr = {5, 1, 3, 2, 6, 4};

		// 거품 정렬: O(N^2)
		for(int j = 1; j < arr.length; j++) {
			for(int i = 0; i < arr.length - j; i++) {
				if(arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

		// 선택 정렬: O(N^2)
		for(int i = 0; i < arr.length - 1; i++) {
			int min_idx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min_idx] > arr[j]) {
					min_idx = j;
				}
			}
			int tmp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = tmp;
		}
		System.out.println(Arrays.toString(arr));

		// 삽입 정렬: O(N^2)
		for(int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int j = i - 1;
			for(;j >= 0 && target < arr[j]; j--) {
				arr[j] = arr[j + 1];
			}
			arr[j + 1] = target;	
		}
		System.out.println(Arrays.toString(arr));

	}

}
