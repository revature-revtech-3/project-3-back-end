package com.project3.revtech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;

//@ContextConfiguration(classes = {WishListService.class})
public class WishListServiceTest {

	@MockBean
	private WishListRepository wishListRepo;
	
	@Autowired
	private WishListServiceImpl wishListServiceImpl;
	

	
//	@Test
//	public void testTotalWishList() {
//		
//		WishListAndItemPojo expectResult = new WishListAndItemPojo(1, 1, 
//											new ArrayList<WishItemPojo>() {
//			{add(new WishItemPojo(1, 1, 1, new ProductAndDiscountPojo(1, "", "", BigDecimal.valueOf(1), "", "", 1, "", true, 1, "", BigDecimal.valueOf(1))));
//			}});
//		
//		
//		WishListAndItemPojo actualResult = wishListService.getWishListByUserId(1);
//
//		assertEquals(expectResult, actualResult);
//	}
	

}
