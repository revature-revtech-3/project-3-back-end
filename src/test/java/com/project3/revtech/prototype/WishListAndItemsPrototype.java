package com.project3.revtech.prototype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.project3.revtech.entity.CartEntity;
import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.joinedpojo.CartAndItemsPojo;
import com.project3.revtech.joinedpojo.ItemProductDiscountPojo;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;
import com.project3.revtech.pojo.CartPojo;
import com.project3.revtech.pojo.WishListItemPojo;
import com.project3.revtech.pojo.WishListPojo;

public class WishListAndItemsPrototype {
	
	  public static WishListAndItemPojo wishListAndItemsTestObj() {
	        List<ItemProductDiscountPojo> wishListItems = itemProductDiscountPojoTestList();
	        WishListEntity wishListEntity = wishListTestObj();
	        return new WishListAndItemPojo(
	        		wishListEntity.getWishListId(),
	        		wishListEntity.getUserId(),
	        		wishListEntity.getWishListTotal(),
	        		wishListItems);
	        
	    }
	  
	   public static WishListEntity wishListTestObj() {
		   WishListEntity wishList = new WishListEntity(1,1);
	        wishList.setWishListItems(wishListItemTestList());
	        return wishList;
	    }
	   
	   public static WishListPojo wishListPojoTestObj() {
	        WishListEntity wishListEntity = wishListTestObj();
	        return new WishListPojo(
	        		wishListEntity.getWishListId(),
	        		wishListEntity.getUserId(),
	        		wishListEntity.getWishListTotal());
	        
	        
	    }
	   public static List<WishListItemEntity> wishListItemTestList() {
	        List <WishListItemEntity> items = new ArrayList<WishListItemEntity>();
	        items.add(wishListItemTestObj());
	        return items;
	    }
	   
	   public static WishListItemEntity wishListItemTestObj() {
	        WishListItemEntity item = new WishListItemEntity(1, 1, 1);
	        item.setProductEntity(productTestObj());
	        return item;
	    }
	   
	   public static ProductEntity productTestObj() {
	        ProductEntity product = new ProductEntity(  1, "12345", "iphone",
	                                        new BigDecimal("25.05"), "phones",
	                                        "String productDescription", 5,
	                                        "String imageUrl", false
	        );
	        product.setDiscountEntity(discountTestObj());
	        return product;
	    }
	   
	   public static DiscountEntity discountTestObj() {
	        return new DiscountEntity(1, 1, " discountDescription", new BigDecimal("20.00"));
	    }
	   
	   public static ProductAndDiscountPojo productAndDiscountPojoTestObj() {
	        ProductEntity testProduct = productTestObj();
	        DiscountEntity testDiscount = discountTestObj();
	        return new ProductAndDiscountPojo(  testProduct.getProductId(), testProduct.getProductSku(), testProduct.getProductName(),
	                                            testProduct.getProductCost(), testProduct.getProductCategory(), testProduct.getProductDescription(),
	                                            testProduct.getProductQty(), testProduct.getImageUrl(), testProduct.isProductRemoved(),
	                                            testDiscount.getDiscountId(), testDiscount.getDiscountDescription(), testDiscount.getDiscountPercentage()
	        );
	    }
	   
	    public static ItemProductDiscountPojo itemProductDiscountPojoTestObj() {
	        WishListItemEntity tempItem = wishListItemTestObj();
	        ProductEntity tempProduct = productTestObj();
	        DiscountEntity tempDiscount = discountTestObj();
	        ProductAndDiscountPojo tempPAD = new ProductAndDiscountPojo(tempProduct.getProductId(), tempProduct.getProductSku(),
	                tempProduct.getProductName(), tempProduct.getProductCost(), tempProduct.getProductCategory(),
	                tempProduct.getProductDescription(), tempProduct.getProductQty(), tempProduct.getImageUrl(),
	                tempProduct.isProductRemoved(), tempDiscount.getDiscountId(), tempDiscount.getDiscountDescription(),
	                tempDiscount.getDiscountPercentage()
	        );
	        return new ItemProductDiscountPojo(tempItem.getWishItemId(), tempItem.getWishListId(), tempItem.getProductId(), tempItem.getWishListQty(), tempPAD);
	    }
	    
	    public static List<ItemProductDiscountPojo> itemProductDiscountPojoTestList() {
	        List<ItemProductDiscountPojo> items = new ArrayList<ItemProductDiscountPojo>();
	        items.add(itemProductDiscountPojoTestObj());
	        return items;
	    }
	    
	    
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

	   
	   
	   
	   
	  
	

	   
	   
	   
	   
	  
	  
	
	
	

}
