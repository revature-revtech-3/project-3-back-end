package com.project3.revtech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
    CartEntity findByCartId(int cartId);
    CartEntity findByCartIdAndCartRemovedFalseAndCartPaidFalse(int cartId);
    CartEntity findByUserIdAndCartRemovedFalseAndCartPaidFalse(int userId);
    CartEntity findByUserId(int userId);
    CartEntity findByCartTotalEquals(int cartTotal);
    
    @Query(value = "SELECT * FROM cart_details WHERE user_id = :userId and cart_paid = true", nativeQuery = true)
    List<CartEntity> findUserOrder(@Param("userId") int usersId);

}
