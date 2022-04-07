package com.project3.revtech.joinedpojo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// only exists to have a return type to test

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class SentEmailsPojo {
	int productId;
	int discountId;
	int userId;
	String Email;
	BigDecimal discount;
	String productName;
	

}
