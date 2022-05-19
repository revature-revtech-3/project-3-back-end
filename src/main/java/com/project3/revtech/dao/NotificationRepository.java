package com.project3.revtech.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project3.revtech.entity.NotificationEntity;
import com.project3.revtech.pojo.NotificationPojo;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Integer> {

	NotificationEntity findByNotificationId(int NotificationId);
	
	@Query("SELECT wl FROM NotificationEntity wl WHERE wl.userEntity.userId=:userWlId")
	NotificationEntity getNotificationByUserId(@Param("userWlId") int userId);

	//NotificationEntity findByUserId(int userId);

	//NotificationEntity findByUserIdAndNotificationRemovedFalse(int userId);


	
}
