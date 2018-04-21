package com.leetcode.easy;

import java.util.Scanner;

public class BinaryNumberWithAlternatingBits {
	
	private static Scanner input;
	public static boolean binaryNumberWithAlternatingBits() {
		input = new Scanner(System.in);
		System.out.print("Please input the number: ");
		int n = input.nextInt();
		
		if (n < 0)
			throw new IllegalArgumentException("It is an illegal number");
		
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length() -1; i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(binaryNumberWithAlternatingBits());
	}
}
