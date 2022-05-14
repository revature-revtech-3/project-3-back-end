package com.project3.revtech.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project3.revtech.dao.UserRepository;
import com.project3.revtech.dao.NotificationRepository;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.entity.NotificationEntity;
import com.project3.revtech.entity.NotificationItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.ProductAndDiscountPojo;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.UserPojo;
import com.project3.revtech.pojo.NotificationItemPojo;
import com.project3.revtech.pojo.NotificationPojo;


@Service
@Transactional

public class NotificationServiceImpl implements NotificationService {	

	@Autowired
	NotificationRepository NotificationRepository;
	
	@Autowired
	UserRepository userRepository;
  
	@Override
	public NotificationPojo addNotification(NotificationPojo Notification) throws ApplicationException {
		
		List<NotificationEntity> allNotification = NotificationRepository.findAll();  // fetches all Notification and check if a Notification exist in the for loop
		for(NotificationEntity aNotification : allNotification) {					  // if it does then it will just return the exisiting Notification
			if(aNotification.getUserEntity().getUserId() == Notification.getUserPojo().getUser_id()) {
				BeanUtils.copyProperties(aNotification, Notification);
				BeanUtils.copyProperties(aNotification.getUserEntity(), Notification.getUserPojo());
				return Notification;
			}
		}
		
		UserEntity user = userRepository.findById(Notification.getUserPojo().getUser_id()).get();
		System.out.println(user);
		NotificationEntity NotificationEntity = new NotificationEntity(user);
		NotificationEntity returnNotification = NotificationRepository.saveAndFlush(NotificationEntity);
		
		Notification.setNotificationId(returnNotification.getNotificationId());
		BeanUtils.copyProperties(returnNotification.getUserEntity(), Notification.getUserPojo());
	
		return Notification;
	}

	@Override
	public NotificationPojo getListByUserId(int userId) throws ApplicationException {
		
		NotificationEntity NotificationEntity = NotificationRepository.getNotificationByUserId(userId);  //getting Notification by userid
		
		NotificationPojo Notification = new NotificationPojo();
		UserPojo user = new UserPojo();
		
		Notification.setNotificationId(NotificationEntity.getNotificationId());
		Notification.setNotificationTotal(NotificationEntity.getNotificationTotal());
		BeanUtils.copyProperties(NotificationEntity.getUserEntity(), user);
		user.setUser_id(userId);
		Notification.setUserPojo(user);

		List<NotificationItemPojo> wishItemPojo = new ArrayList<NotificationItemPojo>();
		
		for(NotificationItemEntity wishItem : NotificationEntity.getNotificationItems()) {
			NotificationItemPojo items = new NotificationItemPojo();
			BeanUtils.copyProperties(wishItem, items);
			
			ProductAndDiscountPojo product = new ProductAndDiscountPojo();
			BeanUtils.copyProperties(wishItem.getProductEntity(), product);
			items.setProductAndDiscountPojo(product);
			
			if(wishItem.getProductEntity().getDiscountEntity() != null) {
				items.getProductAndDiscountPojo().setDiscountId(wishItem.getProductEntity().getDiscountEntity().getDiscountId());
				items.getProductAndDiscountPojo().setDiscountDescription(wishItem.getProductEntity().getDiscountEntity().getDiscountDescription());
				items.getProductAndDiscountPojo().setDiscountPercentage(wishItem.getProductEntity().getDiscountEntity().getDiscountPercentage());
			}
			wishItemPojo.add(items);
		}
		
		Notification.setNotificationItems(wishItemPojo);
		return Notification;
	}

	@Override
	public boolean removeNotification(NotificationPojo NotificationPojo) throws ApplicationException {
		NotificationRepository.deleteById(NotificationPojo.getNotificationId());
		return true;
	}

}

