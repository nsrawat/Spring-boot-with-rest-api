package com.neosoft.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="user_details")
public class UserEntity {

	@Id
	@GeneratedValue
	private int userId;

	private String firstName;

	private String lastName;

	private String emailId;

	private String designation;

	private String address;

	@Column(name="date_of_birth")
	private String dob;

	@Column(name="date_of_joining")
	private String joinDate;

	private long contactNo;

	private int pincode;

}