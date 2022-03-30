package com.project3.revtech.joinedpojo;

import org.springframework.stereotype.Component;

import com.project3.revtech.pojo.UserSettingsPojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// User class + UserSettings joined, might need to drop this table later
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserUserSettingsPojo {
	
	 private int user_id;
	 private String firstName;
	 private String lastName;
     private String username;
     private String email;
     private String password;
	 private String address;
	 private String contact;
	 private UserSettingsPojo userSettings;
	 

}
