package com.project3.revtech.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListItemPojo {
	
	private int wishItemId;
	private WishListPojo wishListPojo;
	private ProductPojo productPojo;
	
}
