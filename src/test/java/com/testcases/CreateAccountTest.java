package com.testcases;

import com.commonutilities.FakerData;

public class CreateAccountTest {

	public static void main(String[] args) {
		
		FakerData f = new FakerData();
		System.out.println("FirstName : "+f.getFirstname());
		System.out.println("LastName : "+f.getLastname());
		System.out.println("Password : "+f.getPassword());
		System.out.println("Email : "+f.getEmail());
	}

}
