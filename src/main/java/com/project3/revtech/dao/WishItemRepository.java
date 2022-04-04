package com.project3.revtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.exception.ApplicationException;

@Repository
public interface WishItemRepository extends JpaRepository<WishListItemEntity, Integer> {
	
	List<WishListItemEntity> findAllByWishListId(int wishListId)throws ApplicationException;

	WishListItemEntity findByWishListIdAndProductId(int wishListId, int productId)throws ApplicationException;

	boolean existsByWishListIdAndProductId(int wishListId, int anyInt2)throws ApplicationException;
	
	boolean existsByWishListQtyIsLessThanAndWishListIdAndProductId(int wishListQty, int wishListId, int productId);

}
