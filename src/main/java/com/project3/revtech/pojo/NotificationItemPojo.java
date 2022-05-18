package com.project3.revtech.pojo;

import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationItemPojo {
	
	private int NotificationItemId;
	private NotificationPojo NotificationPojo;
	private ProductAndDiscountPojo productAndDiscountPojo;
	
}
