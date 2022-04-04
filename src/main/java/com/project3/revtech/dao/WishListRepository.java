package com.project3.revtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.pojo.WishListPojo;

@Repository
public interface WishListRepository extends JpaRepository<WishListEntity, Integer> {

	WishListEntity findByWishListId(int wishListId);

	WishListEntity findByUserId(int userId);

//	WishListEntity findByUserIdAndWishListRemovedFalse(int userId);

	List<WishListPojo> findAllByUserIdOrderByCreatedDateDesc(int userId);

	WishListItemEntity findByWishListIdAndProductId(int wishListId, int productId);

	WishListItemEntity save(WishListItemEntity itemEntity);

	

//	WishListEntity findByWishListId(Integer wishListId);
//	
//	WishListEntity findByUserId(Integer userId);
}
