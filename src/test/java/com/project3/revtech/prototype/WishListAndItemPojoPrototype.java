package com.project3.revtech.prototype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;
import com.project3.revtech.joinedpojo.WishItemDiscountPojo;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;
import com.project3.revtech.pojo.WishListPojo;
public class WishListAndItemPojoPrototype {
	
//	public static WishListAndItemPojo wishListAndItemsTestObj() {
//        List<WishItemDiscountPojo> wishItems = wishItemDiscountPojoTestList();
//        WishListEntity wishListEntity = wishListTestObj();
//        return new WishListAndItemPojo(
//        		wishListEntity.getWishListId(),
//        		wishListEntity.getUserEntity().getUserId(),
//        		wishListEntity.getWishListTotal(),
//        		wishItems);
//    }
	
//    public static WishListEntity wishListTestObj() {
//		UserEntity user = userRepository.findById(wishListPojo.getUserId()).get();
//
//        WishListEntity wishList = new WishListEntity(1, , 100);
//        wishList.setWishListItems(wishListItemTestList());
//        return wishList;
//    }
//    
//    public static WishListPojo wishListPojoTestObj() {
//    	WishListEntity wishListEntity = wishListTestObj();
//        return new WishListPojo(
//        		wishListEntity.getWishListId(),
//        		wishListEntity.getUserId(),
//        		wishListEntity.getWishListTotal());
//    }
    
    public static List<WishListItemEntity> wishListItemTestList() {
        List<WishListItemEntity> items = new ArrayList<WishListItemEntity>();
        items.add(wishListItemTestObj());
        return items;
    }

    public static WishListItemEntity wishListItemTestObj() {
    	WishListItemEntity item = new WishListItemEntity();
    	item.setProductEntity(productTestObj());
    	return item;
    }
    
    public static ProductEntity productTestObj() {
        ProductEntity product = new ProductEntity(
        		1, "12345", "iphone",
                new BigDecimal("25.05"), "phones",
                "String productDescription", 5,
                "String imageUrl", false);
        product.setDiscountEntity(discountTestObj());
        return product;
    }
    
    public static DiscountEntity discountTestObj() {
    	return new DiscountEntity(1, 1, " discountDescription", new BigDecimal("20.00"));
    }
    
    public static ProductAndDiscountPojo productAndDiscountPojoTestObj() {
        ProductEntity testProduct = productTestObj();
        DiscountEntity testDiscount = discountTestObj();
        return new ProductAndDiscountPojo(  
        		testProduct.getProductId(), testProduct.getProductSku(), testProduct.getProductName(),
                testProduct.getProductCost(), testProduct.getProductCategory(), testProduct.getProductDescription(),
                testProduct.getProductQty(), testProduct.getImageUrl(), testProduct.isProductRemoved(),
                testDiscount.getDiscountId(), testDiscount.getDiscountDescription(), testDiscount.getDiscountPercentage());
    }
  
    public static WishItemDiscountPojo wishItemDiscountPojoTestObj() {
    	WishListItemEntity tempItem = wishListItemTestObj();
    	ProductEntity tempProduct = productTestObj();
        DiscountEntity tempDiscount = discountTestObj();
        ProductAndDiscountPojo tempPAD = new ProductAndDiscountPojo(
        		tempProduct.getProductId(), tempProduct.getProductSku(),
                tempProduct.getProductName(), tempProduct.getProductCost(), 
                tempProduct.getProductCategory(), tempProduct.getProductDescription(), 
                tempProduct.getProductQty(), tempProduct.getImageUrl(),
                tempProduct.isProductRemoved(), tempDiscount.getDiscountId(), 
                tempDiscount.getDiscountDescription(), tempDiscount.getDiscountPercentage());
//        return new WishItemDiscountPojo(
//        		tempItem.getWishItemId(),
//        		tempItem.getWishListId(),
//        		tempItem.getProductId(),
//        		tempPAD);
        return null;
    }
    
    public static List<WishItemDiscountPojo> wishItemDiscountPojoTestList() {
    	List<WishItemDiscountPojo> items = new ArrayList<WishItemDiscountPojo>();
    	items.add(wishItemDiscountPojoTestObj());
    	return items;
    }
}
