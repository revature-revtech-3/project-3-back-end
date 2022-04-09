package com.project3.revtech.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project3.revtech.dao.ProductRepository;
import com.project3.revtech.dao.WishItemRepository;
import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.UserPojo;
import com.project3.revtech.pojo.WishListItemPojo;
import com.project3.revtech.pojo.WishListPojo;

@ContextConfiguration(classes = { WishListItemServiceImpl.class })
@ExtendWith(SpringExtension.class)
public class WishListItemServiceImplTest {

	@MockBean
	private WishItemRepository wishItemRepository;
	
	@MockBean
	private WishListRepository wishListRepository;

	@MockBean
	private ProductRepository productRepository;
	
	@Autowired
	private WishListItemServiceImpl wishListItemServiceImpl;

	@Test
	void testAddItem() throws ApplicationException {
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
		wishList.setWishListItems(new ArrayList<>());
		wishList.setWishListTotal(1);
		wishList.setUserEntity(user);

		DiscountEntity discount = new DiscountEntity();
		discount.setDiscountDescription("3");
		discount.setDiscountId(3);
		discount.setDiscountPercentage(null);
		discount.setProductEntity(new ProductEntity());
		discount.setProductId(123);

		ProductEntity product = new ProductEntity();
		product.setCartItems(new ArrayList<>());
		product.setDiscountEntity(discount);
		product.setImageUrl("https://example.org/example");
		product.setImages(new ArrayList<>());
		product.setProductCategory("Product Category");
		product.setProductCost(BigDecimal.valueOf(42L));
		product.setProductDescription("Product Description");
		product.setProductId(123);
		product.setProductName("Product Name");
		product.setProductQty(1);
		product.setProductRemoved(true);
		product.setProductSku("Product Sku");

		DiscountEntity discount1 = new DiscountEntity();
		discount1.setDiscountDescription("3");
		discount1.setDiscountId(3);
		discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
		discount1.setProductEntity(product);
		discount1.setProductId(123);

		ProductEntity product1 = new ProductEntity();
		product1.setCartItems(new ArrayList<>());
		product1.setDiscountEntity(discount1);
		product1.setImageUrl("https://example.org/example");
		product1.setImages(new ArrayList<>());
		product1.setProductCategory("Product Category");
		product1.setProductCost(BigDecimal.valueOf(42L));
		product1.setProductDescription("Product Description");
		product1.setProductId(123);
		product1.setProductName("Product Name");
		product1.setProductQty(1);
		product1.setProductRemoved(true);
		product1.setProductSku("Product Sku");

		WishListItemEntity wishListItem = new WishListItemEntity();
		wishListItem.setWishListEntity(wishList);
		wishListItem.setWishItemId(123);
		wishListItem.setProductEntity(product1);
		
		ProductPojo productPojo = new ProductPojo();
		productPojo.setImageUrl("https://example.org/example");
		productPojo.setProductCategory("Product Category");
		productPojo.setProductCost(BigDecimal.valueOf(42L));
		productPojo.setProductDescription("Product Description");
		productPojo.setProductId(123);
		productPojo.setProductName("Product Name");
		productPojo.setProductQty(1);
		productPojo.setProductRemoved(true);
		productPojo.setProductSku("Product Sku");
		
		UserPojo userPojo = new UserPojo();
		userPojo.setAddress("42 Main St");
		userPojo.setContact("Contact");
		userPojo.setEmail("jane.doe@example.org");
		userPojo.setFirstName("Jane");
		userPojo.setLastName("Doe");
		userPojo.setPassword("iloveyou");
		userPojo.setUsername("janedoe");
		userPojo.setUser_id(1);
		
		WishListPojo wishListPojo = new WishListPojo();
		wishListPojo.setWishListId(123);
		wishListPojo.setUserPojo(userPojo);
		wishListPojo.setWishListItems(new ArrayList<>());
		wishListPojo.setWishListTotal(1);
		
		WishListItemPojo wishListItemPojo = new WishListItemPojo();
		wishListItemPojo.setWishItemId(123);
		wishListItemPojo.setWishListPojo(wishListPojo);
		wishListItemPojo.setProductPojo(productPojo);

		doNothing().when(this.wishItemRepository).deleteById((Integer) any());
		when(this.wishListRepository.findByWishListId(anyInt())).thenReturn(wishList);
		when(this.wishItemRepository.findByWishListId(anyInt())).thenReturn(wishListItem);

		WishListItemPojo actualAddItemResult = this.wishListItemServiceImpl.addItem(wishListItemPojo);
		
		assertSame(wishListItemPojo, actualAddItemResult);
		assertEquals(-1, actualAddItemResult.getWishItemId());
//		verify(this.wishItemRepository).deleteById((Integer) any());
//		verify(this.wishItemRepository).existsByWishListIdAndProductId(anyInt(), anyInt());
//		verify(this.wishItemRepository).existsByWishListQtyIsLessThanAndWishListIdAndProductId(anyInt(), anyInt(),
//				anyInt());
//		verify(this.wishItemRepository, atLeast(1)).findByWishListIdAndProductId(anyInt(), anyInt());

	}

	@Test
	void testRemoveItem() throws ApplicationException {
		doNothing().when(this.wishItemRepository).deleteById((Integer) any());
		assertTrue(this.wishListItemServiceImpl.removeItem(123));
		verify(this.wishItemRepository).deleteById((Integer) any());
	}

}
