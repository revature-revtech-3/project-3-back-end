package com.project3.revtech.joinedpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishItemProductPojo {
	
	private int wishItemId;
	private int wishListId;
	private int productId;
	private ProductAndDiscountPojo productAndDiscount;

}
