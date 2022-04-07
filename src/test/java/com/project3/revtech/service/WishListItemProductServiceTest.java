package com.project3.revtech.service;


import static org.junit.Assert.assertEquals;



import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.project3.revtech.dao.DiscountRepository;
import com.project3.revtech.dao.ProductRepository;
import com.project3.revtech.dao.WishItemRepository;
import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.exception.ApplicationException;

import com.project3.revtech.joinedpojo.WishListAndItemPojo;
import com.project3.revtech.pojo.WishListItemPojo;

import static com.project3.revtech.prototype.WishListAndItemPojoPrototype.*;
@ContextConfiguration(classes = {   WishListItemProductServiceImpl.class,
        							WishListItemServiceImpl.class,
        							ProductDiscountServiceImpl.class,
        							ProductServiceImpl.class,
        							WishListServiceImpl.class})
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
public class WishListItemProductServiceTest {
	
	@MockBean
	private WishListRepository wishListRepository;
	@MockBean
	private WishItemRepository wishItemRepository;
	@MockBean
	private ProductRepository productRepository;
	@MockBean
	private DiscountRepository discountRepository;
	@Autowired
	WishListItemProductServiceImpl wishListItemProductService;
	@Autowired
	WishListItemServiceImpl wishListItemService;
	@Autowired
	ProductServiceImpl productService;
	@Autowired
	WishListService wishListService;
	
	
	
	@Before
    public void beforeClass() {}
		
//	    @Test
//	    public void testGetWishListItemProductServiceByUser() throws ApplicationException {
//	        when(wishListRepository.findByUserIdAndWishListRemovedFalse(eq(1))).thenReturn(wishListTestObj());
//	        WishListAndItemPojo wishListAndItems = wishListItemProductService.getAllWIshListItemProductsForUser(1);
//	        WishListAndItemPojo testObj = wishListAndItemsTestObj();
//	        assertNotNull(wishListAndItems);
//	        assertEquals(1, wishListAndItems.getUserId());
//	        assertEquals(testObj.toString(), wishListAndItems.toString());
//
//	    }
	
	


//		@Test
//	    public void testGetWishListItemProductService() throws ApplicationException {
//	        when(wishListRepository.getById(eq(1))).thenReturn(wishListTestObj());
//	        WishListAndItemPojo wishListAndItems = wishListItemProductService.getAllWishListItemProducts(1);
//	        WishListAndItemPojo testObj = wishListAndItemsTestObj();
//	        assertNotNull(wishListAndItems);
//	        assertEquals(1, wishListAndItems.getUserId());
//	        assertEquals(testObj.toString(), wishListAndItems.toString());
//	    }

  
	
	

}
