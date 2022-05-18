package com.project3.revtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.UserEntity;

@Repository
public interface EmailRepository extends JpaRepository<UserEntity, Integer> {

	
	@Query(value = "SELECT email FROM user_details WHERE user_id = :userId", nativeQuery = true)
    String getEmail(@Param("userId") int userId);

}
