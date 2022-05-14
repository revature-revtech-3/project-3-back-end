package com.project3.revtech.service;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.NotificationPojo;

public interface NotificationService {
  
  	NotificationPojo addNotification(NotificationPojo Notification) throws ApplicationException;

	NotificationPojo getListByUserId(int userId) throws ApplicationException;

	boolean removeNotification(NotificationPojo Notification) throws ApplicationException;

}
