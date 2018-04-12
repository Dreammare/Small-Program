package com.hand.sorting;

public class Bubble {
	public static void sort(int[] arr){
		if (arr.length == 0)
			return;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}

	public static void swap(int[] arr, int j, int i) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,3,5,7,9,2,4,6,8};
		sort(arr);
		for (int c : arr) {
			System.out.print(c+ " ");
		}
	}
}
