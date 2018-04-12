package org.ibm.service;

import javax.xml.ws.Endpoint;

public class RunService {

	public static void main(String[] args) {
		System.out.println("Function Web Service started.");
		Endpoint.publish("http://localhost:8088/WebServices", new Function());
	}
}
