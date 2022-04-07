package com.project3.revtech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.DiscountRepository;
import com.project3.revtech.dao.ProductRepository;
import com.project3.revtech.dao.WishItemRepository;
import com.project3.revtech.dao.WishListRepository;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.DiscountPojo;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.WishListItemPojo;

@Service
@Transactional
public class WishListItemServiceImpl implements WishListItemService {
	
	@Autowired
	WishItemRepository wishItemRepository;
	
	@Autowired
	WishListRepository wishListRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public WishListItemPojo addItem(WishListItemPojo item) throws ApplicationException {
		//System.out.println("this is addItem in wishListItemService" + item);
		
		WishListItemEntity wishItem = new WishListItemEntity();
		wishItem.getWishListEntity().setWishListId(item.getWishListId());
		wishItem.getProductEntity().setProductId(item.getProductId());
		
		WishListItemEntity returningItem = wishItemRepository.saveAndFlush(wishItem);
		item.setWishItemId(returningItem.getWishItemId());
		
		return item;
	}


//	@Override
//	public WishListItemPojo updateItem(WishListItemPojo item) throws ApplicationException {
//		WishListItemEntity existingItem = wishItemRepository.findByWishListIdAndProductId(item.getWishListId(), item.getProductId());
//		
//		if(existingItem == null) return addItem(item);
//		item.setWishItemId(existingItem.getWishItemId());
//		
//		if(this.checkIfNoQty(item.getWishListId(), item.getProductId())) {
//			this.removeItem(item.getWishItemId());
//			item.setWishItemId(-1);
//		} else {
//			WishListItemEntity itemEntity = new WishListItemEntity(item.getWishItemId(), item.getWishListId(), item.getProductId());
//			WishListItemEntity returningItem = wishItemRepository.save(itemEntity);
//		}
//		return item;
//	}

	@Override
	public boolean removeItem(int itemId) throws ApplicationException {
		wishItemRepository.deleteById(itemId);
		return true;
	}

	@Override
	public WishListItemPojo getWishListItem(int wishItemId) throws ApplicationException {
		Optional<WishListItemEntity> optional = wishItemRepository.findById(wishItemId);
		WishListItemPojo wishListItemPojo = null;
		
		if(optional.isPresent()) {
			WishListItemEntity wishListItemEntity = optional.get();
			wishListItemPojo = new WishListItemPojo(
					wishListItemEntity.getWishListEntity().getWishListId(),
					wishListItemEntity.getWishItemId(),
					wishListItemEntity.getProductEntity().getProductId());
		}
		return wishListItemPojo;
	}


	@Override
	public List<WishListItemPojo> getAllItemsOfWishList(WishListItemPojo wishListItemPojo) throws ApplicationException {
		return null;
	}
//
//	@Override
//	public boolean checkIfExistsInWishList(int wishListId, int productId) throws ApplicationException {
//		return wishItemRepository.existsByWishListIdAndProductId(wishListId, productId);
//	}


//	@Override
//	public boolean checkIfNoQty(int wishListId, int productId) throws ApplicationException {
//		return wishItemRepository.existsByWishListQtyIsLessThanAndWishListIdAndProductId(1, wishListId, productId);
//	}
}
