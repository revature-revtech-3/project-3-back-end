package com.project3.revtech.service;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;
import com.project3.revtech.pojo.WishListPojo;

@ContextConfiguration(classes = {WishListServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class WishListServiceTest {

	@MockBean
	private WishListRepository wishListRepository;
	
	@Autowired
	private WishListServiceImpl wishListServiceImpl;
	
	@Test
	void testAddWishList() throws ApplicationException {
		
		UserEntity user = new UserEntity();
        user.setAddress("42 Main St");
        user.setContact("Contact");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        user.setUserId(1);
        user.setUsername("janedoe");
        
        WishListEntity wishList = new WishListEntity();
        wishList.setWishListId(123);
        wishList.setUserId(1);
        when(this.wishListRepository.saveAndFlush((WishListEntity) any())).thenReturn(wishList);
        WishListPojo wishListPojo = new WishListPojo();
        
        WishListPojo actualAddWishListResult = this.wishListServiceImpl.addWishList(wishListPojo);
        //assertSame(wishListPojo, actualAddWishListResult);
        assertEquals(123, actualAddWishListResult.getWishListId());
        verify(this.wishListRepository).saveAndFlush((WishListEntity) any());
        
	}
	
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
