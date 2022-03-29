package com.project3.revtech.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@NotBlank
	@Size(max = 20)
	private String first_name;

	@NotBlank
	@Size(max = 20)
	private String last_name;

	@NotBlank
	@Size(max = 200)
	private String address;

	@NotBlank
	@Size(min = 10)
	private String contact;

	@OneToMany(mappedBy = "product")
	private List<Review> reviews;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(  name = "user_roles", 
	joinColumns = @JoinColumn(name = "uid"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User(String username, String email, String password, String first_name, String last_name, String address, String contact) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.contact = contact;

	}

}
