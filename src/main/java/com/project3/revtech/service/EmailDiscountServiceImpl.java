package com.project3.revtech.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.revtech.dao.WishListProductUserRepository;
import com.project3.revtech.entity.WishlistEntity;
import com.project3.revtech.joinedpojo.SentEmailsPojo;
import com.project3.revtech.pojo.DiscountPojo;





@Service
@Transactional
public class EmailDiscountServiceImpl {
	
//	@Autowired        //will re qutowire later
	EmailService emailService = new EmailService();
	
	// are we taking abbrieviations?
	@Autowired
	WishListProductUserRepository wlpuRepository;
	
	// todo add custom exceptions
	public List<SentEmailsPojo> sendByDiscount(DiscountPojo discount) {
		
		List<SentEmailsPojo> sentEmails = new ArrayList<SentEmailsPojo>();
		List<WishlistEntity> wishedDiscounts = wlpuRepository.findByProductId(discount.getProductId());
			
		for(WishlistEntity wishListEntity : wishedDiscounts)
		{
			String messageText = wishListEntity.getProductEntity().getProductName() + "Just went on Sale \n"
			+ "GET " + discount.getDiscountPercentage() + "% OFF!!!!!";
			
			// not sure if necessary
			try {
				emailService.sendMessage(wishListEntity.getUserEntity().getEmail(),"Discount",messageText);
				SentEmailsPojo sent = new SentEmailsPojo(
						wishListEntity.getProductId(),
						discount.getDiscountId(),
						wishListEntity.getUserId(),
						wishListEntity.getUserEntity().getEmail(),
						discount.getDiscountPercentage(),
						wishListEntity.getProductEntity().getProductName());
				sentEmails.add(sent);
				
				
			} catch(Exception e) {
				SentEmailsPojo sent = new SentEmailsPojo(
						0,
						0,
						0,
						"invalid Email",
						BigDecimal.ZERO,
						"unknown");
				sentEmails.add(sent);
				e.printStackTrace();
				
			}
			
			
			
		}
		
		
		
		return sentEmails;
	}
	
	
	
	// awaiting joined bundle pojo
	public void sendByBundle(int bundleID) {
		
	}

}
