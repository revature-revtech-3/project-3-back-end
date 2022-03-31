package com.project3.revtech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project3.revtech.dao.WishListProductUserRepository;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.entity.WishlistEntity;
import com.project3.revtech.joinedpojo.SentEmailsPojo;
import com.project3.revtech.pojo.DiscountPojo;

@ContextConfiguration(classes = {EmailDiscountServiceImpl.class})
@ExtendWith(SpringExtension.class )
public class EmailDiscountTest {
	
	@Autowired
	EmailDiscountServiceImpl emailDiscountTest;
	
	@MockBean
	WishListProductUserRepository wlpuRepository;
	
	
	@Test
	void testEmailSendByDiscount() //throws 
	{
		//discount entity
		
		DiscountPojo discount = new DiscountPojo(1,1,"high",new BigDecimal(.5));
		
		WishlistEntity first = new WishlistEntity(1,1,new Date(),1);
		ProductEntity discountedProduct = new ProductEntity();
		discountedProduct.setProductName("Hello");
		discountedProduct.setProductId(1);
		first.setProductEntity(discountedProduct);
		UserEntity emailReciever = new UserEntity();
		//need test email
		emailReciever.setEmail("demoreceiveracct1");
		first.setUserEntity(emailReciever);
		
		List<WishlistEntity> wishlist = new ArrayList<WishlistEntity>();
		wishlist.add(first);
		List<SentEmailsPojo> sentEmails = new ArrayList<SentEmailsPojo>();
		SentEmailsPojo sentEmail = new SentEmailsPojo(1,1,1,"goodday@emailen.com",new BigDecimal(.5),"Hello");
		sentEmails.add(sentEmail);
		
		when(wlpuRepository.findByProductId(1)).thenReturn(wishlist);
		
		List<SentEmailsPojo> actualResult =  this.emailDiscountTest.sendByDiscount(discount);
		
		System.out.println(actualResult);
		assertEquals(actualResult,sentEmails);
	}
	
	
	
}
