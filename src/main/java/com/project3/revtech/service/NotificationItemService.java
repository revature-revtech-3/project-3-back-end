package com.project3.revtech.service;

import java.util.List;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.DiscountPojo;
import com.project3.revtech.pojo.NotificationItemPojo;

public interface NotificationItemService {
	
    NotificationItemPojo addItem(NotificationItemPojo NotificationItemPojo) throws ApplicationException;
        
    boolean removeItem(int itemId) throws ApplicationException;
	

}
