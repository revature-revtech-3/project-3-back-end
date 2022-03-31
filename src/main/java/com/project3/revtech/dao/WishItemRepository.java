package com.project3.revtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project3.revtech.entity.CartItemEntity;
import com.project3.revtech.entity.WishListItemEntity;

public interface WishItemRepository extends JpaRepository<WishListItemEntity, Integer> {
	List<WishListItemEntity> findAllByWishListId(int wishListId);
}
