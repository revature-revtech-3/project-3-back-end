package com.project3.revtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project3.revtech.entity.WishListEntity;


public interface WishListRepository extends JpaRepository<WishListEntity, Integer> {

//	//to fetch wish list of a user and ordered by create date
//	List<WishListEntity> findAllByUserIdOrderByCreatedDateDesc(Integer userId);
}
