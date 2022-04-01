package com.project3.revtech.joinedpojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListAndItemPojo {

	public WishListAndItemPojo(int wishListId2, int userId2, int wishListTotal2,
			List<ItemProductDiscountPojo> wishListItems) {
		// TODO Auto-generated constructor stub
	}
	private int wishListId;
	private int userId;
	private int wishListTotal;
	private List<WishItemDiscountPojo> wishItems;
	private int wishListTotal;
	
	
	
}