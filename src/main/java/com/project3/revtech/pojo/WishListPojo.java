package com.project3.revtech.pojo;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListPojo {
	
	private int wishListId;
	private int userId;
	private int wishListTotal;
	
	
	public WishListPojo(int wishListId, int userId) {
		this.wishListId = wishListId;
		this.userId = userId;
	}
	
	

}