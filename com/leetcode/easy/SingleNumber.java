package com.leetcode.easy;


/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:You algorithm should have a linear runtime complexity.Could you implement it without using extra memory? 
 * @author dream
 *
 */
public class SingleNumber {
	
	public static int singleNumber(int arr[], int n) {
		int result = arr[0];
		for (int i = 1; i< n; i++) {
			result = result^arr[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,2,2,3,3,4};
		System.out.println(singleNumber(arr,7));
	}
}
