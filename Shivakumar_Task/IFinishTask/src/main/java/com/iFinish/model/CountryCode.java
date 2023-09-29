package com.iFinish.model;

import org.springframework.stereotype.Component;

@Component
public class CountryCode {
	
	private String name;
	private String dial_code;
	private String code;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDial_code() {
		return dial_code;
	}
	public void setDial_code(String dial_code) {
		this.dial_code = dial_code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public CountryCode() {
		super();
	}
	@Override
	public String toString() {
		return "CountryCode [name=" + name + ", dial_code=" + dial_code + ", code=" + code + "]";
	}
	public CountryCode(String name, String dial_code, String code) {
		super();
		this.name = name;
		this.dial_code = dial_code;
		this.code = code;
	}
	
	

}
