package com.project3.revtech.joinedpojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListAndItemPojo {



	private int wishListId;
	private int userId;
	private int wishListTotal;
	private WishItemDiscountPojo wishItems;
	
	
	
	
}