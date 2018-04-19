package edu;

import java.util.Stack;

public class InverseString {
	
	public static String strReverseWithArray0(String str) {
		if (str == null || str.length() == 0)
			return str;
		int length = str.length();
		char[] arr = str.toCharArray();
		for (int i = 0; i < length; i++) {
			arr[i] = str.charAt(str.length()-1-i);
		}
		return new String(arr);
	}
	
	public static String strReverseWithArray1(String str) {
		if (str == null || str.length() == 0)
			return str;
		int length = str.length();
		char[] arr = str.toCharArray();
		for (int i = 0; i < length / 2; i++) {
			arr[i] = str.charAt(length-1-i);
			arr[length-1-i] = str.charAt(i);
		}
		return new String(arr);
	}
	
	public static String strReverseWithStack(String str) {
		if (str == null || str.length() == 0)
			return str;
		
		Stack<Character> strStack = new Stack<>();
		char[] arr = str.toCharArray();
		for (Character c : arr) {
			strStack.push(c);
		}
		
		int length = str.length();
		for (int i = 0; i < length; i++) {
			arr[i] = strStack.pop();
		}
		return new String(arr);
	}
	
	public static String strReverseWithReverseLoop(String str) {
		if (str == null || str.length() == 0)
			return str;
		
		StringBuilder sb = new StringBuilder();
		for (int i = str.length()-1; i >=0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static String strReverseWithXor(String str) {
		if (str == null || str.length() == 0)
			return str;
		
		char[] arr = str.toCharArray();
		
		int length = str.length()-1;
		for (int i=0; i<length;i++,length--) {
			arr[i]^=arr[length];
			arr[length]^=arr[i];
			arr[i]^=arr[length];
		}
		return new String(arr);
	}
	
	public static String strReverseWithRecursive(String str) {
		if (str == null || str.length() == 0)
			return str;
		int length = str.length();
		if (length == 1) {
			return str;
		} else {
			return strReverseWithRecursive(str.substring(1))+str.charAt(0);
		}
	}
}
