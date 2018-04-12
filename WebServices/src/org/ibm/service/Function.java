package org.ibm.service;

import javax.jws.WebService;

@WebService
public class Function {
	/*
	public String transWords(String words) {
		String res = "";
		for (char ch : words.toCharArray()) {
			res += ch + ",";
		}
		return res;
	}
	
	public static void main (String[] args) {
		Endpoint.publish("http://localhost:8088/service/function", new Function());
		System.out.println("Publish Success");
	}
	*/
	private static final String SALUTATION = "Hello";
	
	public String getGreeting(String name) {
		return SALUTATION + " " + name;
	}
}
