package com.commonutilities;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakerData {

	public Faker faker;
	public FakeValuesService fakeValueService = new FakeValuesService(new Locale("en-GB"), new RandomService());
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String address_firstname;
	private String address_lastname;
	private Company address_company;
	private String address_address;
	private String city;
	private String zipcode;
	private PhoneNumber mobile;
	private String alternateAddress;
	private String state;

	public String getState() {
		return state;
	}

	public void setState() {
		this.state = faker.address().state();
	}

	public Faker getFaker() {
		return faker;
	}

	public void setFaker(Faker faker) {
		this.faker = faker;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname() {
		this.firstname = faker.address().firstName();
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname() {
		this.lastname = faker.address().lastName();
	}

	public String getEmail() {

		return email;

	}

	public void setEmail() {

		this.email = fakeValueService.bothify("????##@gmail.com");

	}

	public String getPassword() {
		return password;
	}

	public void setPassword() {
		this.password = "Pass1234";
	}

	public String getAddress_firstname() {
		return address_firstname;
	}

	public void setAddress_firstname() {
		this.address_firstname = faker.address().firstName();
	}

	public String getAddress_lastname() {
		return address_lastname;
	}

	public void setAddress_lastname() {
		this.address_lastname = faker.address().lastName();
	}

	public Company getAddress_company() {
		return address_company;
	}

	public void setAddress_company() {
		this.address_company = faker.company();
	}

	public String getAddress_address() {
		return address_address;
	}

	public void setAddress_address() {
		this.address_address = faker.address().fullAddress();
	}

	public String getCity() {
		return city;
	}

	public void setCity() {
		this.city = faker.address().city();
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode() {
		this.zipcode = "35005";
	}

	public PhoneNumber getMobile() {
		return mobile;
	}

	public void setMobile() {
		this.mobile = faker.phoneNumber();
	}

	public String getAlternateAddress() {
		return alternateAddress;
	}

	public void setAlternateAddress() {
		this.alternateAddress = faker.address().streetAddress();
	}

	public FakerData() {
		faker = new Faker();
		setState();
		setFirstname();
		setAddress_firstname();
		setLastname();
		setAddress_lastname();
		setPassword();
		setEmail();
		setMobile();
		setAlternateAddress();
		setZipcode();
		setCity();
		setAddress_company();
		setAddress_address();
		

	}

}
