package com.project3.revtech.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.WishlistEntity;

//think this will be better merged with wishList
@Repository
public interface WishListProductUserRepository extends JpaRepository<WishlistEntity, Integer>{

	List<WishlistEntity> findByProductId(int productID);
	
	
}
