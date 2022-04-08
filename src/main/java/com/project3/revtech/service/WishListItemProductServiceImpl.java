package com.project3.revtech.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.UserRepository;
import com.project3.revtech.dao.WishItemRepository;
import com.project3.revtech.dao.WishListRepository;


import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.ItemProductDiscountPojo;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;
import com.project3.revtech.joinedpojo.WishItemDiscountPojo;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;
import com.project3.revtech.pojo.ProductPojo;

@Service
@Transactional
public class WishListItemProductServiceImpl implements WishListItemProductService {

	@Autowired
	WishListRepository wishListRepository;
	
	@Autowired
	WishItemRepository wishItemRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	WishListServiceImpl wishListService;

	@Override
	public WishListAndItemPojo getAllWishListItemProducts(int wishListId) throws ApplicationException{

		WishListEntity wishListEntity = wishListRepository.findByWishListId(wishListId);
		//System.out.println("this is getallwishlist wishListEntity: " + wishListEntity);
		return getWishListAndItemPojo(wishListEntity);
	}

	@Override
	public List<WishListAndItemPojo> getAllWishListItemProductsForUser(int userId) throws ApplicationException {
		
		List<WishListAndItemPojo> listAndItems = new ArrayList<WishListAndItemPojo>();
		WishListEntity wishListEntity = wishListRepository.getWishListByUserId(userId);
		
		List<WishListItemEntity> existingItems = wishItemRepository.findAllByWishListId(wishListEntity.getWishListId());
		
		for(WishListItemEntity tempItem : existingItems) {
			WishListAndItemPojo items = new WishListAndItemPojo();
			WishItemDiscountPojo wishItems = new WishItemDiscountPojo();
			ProductPojo products = new ProductPojo();
			
			BeanUtils.copyProperties(tempItem, items);
			BeanUtils.copyProperties(tempItem.getWishListEntity(), wishItems);
			BeanUtils.copyProperties(tempItem.getProductEntity(), products);
			

			items.setWishItems(wishItems);
			items.setUserId(tempItem.getWishListEntity().getUserEntity().getUserId());
		
			listAndItems.add(items);
			
		}
		return listAndItems;

	}

	@NotNull
	private WishListAndItemPojo getWishListAndItemPojo(WishListEntity wishListEntity) {  //getting the items in the wishlist, has return type of joined pojo wishListandItemPojo
		//System.out.println("this is from wishListitemproduct" + wishListEntity);
		
		
		List<WishListItemEntity> wishListItems = wishListEntity.getWishListItems() == null
				? new ArrayList<WishListItemEntity>()
				: wishListEntity.getWishListItems();
		
		List<ItemProductDiscountPojo> joinedDataItems = new ArrayList<ItemProductDiscountPojo>();
		
		for (WishListItemEntity tempItem : wishListItems) {
			ProductEntity tempProduct = tempItem.getProductEntity();
			DiscountEntity tempDiscount = (tempProduct.getDiscountEntity() == null ? new DiscountEntity(true)
					: tempProduct.getDiscountEntity());

			ProductAndDiscountPojo tempPAD = new ProductAndDiscountPojo(tempProduct.getProductId(),
					tempProduct.getProductSku(), tempProduct.getProductName(), tempProduct.getProductCost(),
					tempProduct.getProductCategory(), tempProduct.getProductDescription(), tempProduct.getProductQty(),
					tempProduct.getImageUrl(), tempProduct.isProductRemoved(), tempDiscount.getDiscountId(),
					tempDiscount.getDiscountDescription(), tempDiscount.getDiscountPercentage());

			//ItemProductDiscountPojo tempIPD = new ItemProductDiscountPojo(tempItem.getWishItemId(), tempItem.getWishListId(), 0, tempPAD);
			//joinedDataItems.add(tempIPD);
		}
		
		return new WishListAndItemPojo();
	}

}
