package com.iFinish.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="race_register")
public class RaceParticipationRegisterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer participantId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "country_code")
	private String countyCode;
	@Column(name = "mobile_number")
	private Long mobileNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "gender")
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")// form backing purpose we are using it.
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "country")
	private String country;
	
	
	//Generating setters,getters,Arg Constructor and no arg constructor and toString 
	
	public Integer getParticipantId() {
		return participantId;
	}
	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public RaceParticipationRegisterEntity(String firstName, String lastName, String countyCode, Long mobileNumber, String email,
			String gender, LocalDate dob, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.countyCode = countyCode;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.country = country;
	}
	public RaceParticipationRegisterEntity() {
		super();
	}
	@Override
	public String toString() {
		return "RaceParticipationRegisterEntity [participantId=" + participantId + ", FirstName=" + firstName + ", LastName="
				+ lastName + ", countyCode=" + countyCode + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", gender=" + gender + ", dob=" + dob + ", country=" + country + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
