package com.project3.revtech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.DiscountRepository;
import com.project3.revtech.dao.ProductRepository;
import com.project3.revtech.dao.NotificationItemRepository;
import com.project3.revtech.dao.NotificationRepository;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.NotificationEntity;
import com.project3.revtech.entity.NotificationItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.DiscountPojo;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.NotificationItemPojo;

@Service
@Transactional
public class NotificationItemServiceImpl implements NotificationItemService {
	
	@Autowired
	NotificationItemRepository NotificationItemRepository;
	
	@Autowired
	NotificationRepository NotificationRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public NotificationItemPojo addItem(NotificationItemPojo item) throws ApplicationException {
		
		NotificationEntity Notification = NotificationRepository.findByNotificationId(item.getNotificationPojo().getNotificationId());
		ProductEntity productEntity = productRepository.findByProductId(item.getProductAndDiscountPojo().getProductId());
		
		NotificationItemEntity NotificationItem = new NotificationItemEntity();
		NotificationItem.setNotificationEntity(Notification);
		NotificationItem.setProductEntity(productEntity);
		NotificationItem.getNotificationEntity().setNotificationTotal(NotificationItem.getNotificationEntity().getNotificationTotal()+1);
		
		NotificationItemEntity returningItem = NotificationItemRepository.saveAndFlush(NotificationItem);
		item.setNotificationItemId(returningItem.getNotificationItemId());

		BeanUtils.copyProperties(returningItem.getProductEntity(), item.getProductAndDiscountPojo());
		if(returningItem.getProductEntity().getDiscountEntity() != null) {
			item.getProductAndDiscountPojo().setDiscountId(returningItem.getProductEntity().getDiscountEntity().getDiscountId());
			item.getProductAndDiscountPojo().setDiscountDescription(returningItem.getProductEntity().getDiscountEntity().getDiscountDescription());
			item.getProductAndDiscountPojo().setDiscountPercentage(returningItem.getProductEntity().getDiscountEntity().getDiscountPercentage());
		}
		
		BeanUtils.copyProperties(returningItem.getNotificationEntity(), item.getNotificationPojo());
		
		return item;
	}

	@Override
	public boolean removeItem(int itemId) throws ApplicationException {
		NotificationItemRepository.deleteById(itemId);
		return true;
	}
	
}
