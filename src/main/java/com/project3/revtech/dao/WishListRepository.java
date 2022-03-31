package com.project3.revtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project3.revtech.entity.WishListEntity;


public interface WishListRepository extends JpaRepository<WishListEntity, Integer> {

//	WishListEntity findByWishListId(Integer wishListId);
//	
//	WishListEntity findByUserId(Integer userId);
}
