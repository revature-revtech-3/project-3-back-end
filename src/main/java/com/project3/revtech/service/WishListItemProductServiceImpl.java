package com.project3.revtech.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.WishListRepository;


import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.ItemProductDiscountPojo;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;

import com.project3.revtech.joinedpojo.WishListAndItemPojo;

@Service
@Transactional
public class WishListItemProductServiceImpl implements WishListItemProductService {

	@Autowired
	WishListRepository wishListRepository;

	@Autowired
	WishListServiceImpl wishListService;

	@Override
	public WishListAndItemPojo getAllWishListItemProducts(int wishListId) throws ApplicationException{

		WishListEntity wishListEntity = wishListRepository.getById(wishListId);

		return getWishListAndItemPojo(wishListEntity);
	}

//	@Override
//	public WishListAndItemPojo getAllWIshListItemProductsForUser(int userId) {
//		WishListEntity wishListEntity = wishListRepository.findByUserIdAndWishListRemovedFalse(userId);
//		if (wishListEntity == null) {
//			wishListEntity = new WishListEntity(userId, 0);
//			wishListEntity = wishListRepository.saveAndFlush(wishListEntity);
//		}
//		return getWishListAndItemPojo(wishListEntity);
//	}

	@NotNull
	private WishListAndItemPojo getWishListAndItemPojo(WishListEntity wishListEntity) {
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

			ItemProductDiscountPojo tempIPD = new ItemProductDiscountPojo(tempItem.getWishItemId(),
					tempItem.getProductId(), tempItem.getWishListId(), 0, tempPAD);
			joinedDataItems.add(tempIPD);
		}
		return new WishListAndItemPojo();
	}

}
