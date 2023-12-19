package com.bs.firstboot.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {

	private String userId;
	private String password;
	private String name;
	private int age;
	private String email;
	private String phone;
	private String gender;
	private String address;
	private String hobby;
	private Date enrollDate;
	
	
}
