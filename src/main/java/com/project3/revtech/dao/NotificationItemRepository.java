package com.project3.revtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.NotificationItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.NotificationItemPojo;

@Repository
public interface NotificationItemRepository extends JpaRepository<NotificationItemEntity, Integer> {
	

	@Query("SELECT wl FROM NotificationItemEntity wl WHERE wl.wishListEntity.wishListId=:wishListId")
	NotificationItemEntity findByWishListId(@Param("wishListId") int wishListId);
	
	@Query("SELECT wl FROM NotificationItemEntity wl WHERE wl.wishListEntity.wishListId=:wishListId")
	List<NotificationItemEntity> findAllByWishListId(@Param("wishListId") int wishListId)throws ApplicationException;
	
	// Used by EmailDiscountService to find wishlists->users whenever a discount/bundle is added
	@Query("SELECT wl FROM NotificationItemEntity wl WHERE wl.productEntity.productId=:productId")
	List<NotificationItemEntity> findAllByProductId(int productId)throws ApplicationException;
	

	@Query("SELECT wl FROM NotificationItemEntity wl WHERE wl.wishListEntity.wishListId=:wishListId AND wl.productEntity.productId=:productId")
	NotificationItemEntity findByWishListIdAndProductId(@Param("wishListId") int wishListId, @Param("productId") int productId)throws ApplicationException;

	//boolean existsByWishListIdAndProductId(int wishListId, int anyInt2)throws ApplicationException;
	
	//boolean existsByWishListQtyIsLessThanAndWishListIdAndProductId(int wishListQty, int wishListId, int productId);

}
