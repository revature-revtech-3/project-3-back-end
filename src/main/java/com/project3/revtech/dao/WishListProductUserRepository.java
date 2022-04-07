package com.project3.revtech.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.WishListEntity;

//think this will be better merged with wishList
@Repository
public interface WishListProductUserRepository extends JpaRepository<WishListEntity, Integer>{

	//List<WishListEntity> findByProductId(int productID);
	
	
}
