package com.project3.revtech.pojo;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationPojo {
	
	private int notificationId;
	private UserPojo userPojo;
	private int notificationTotal;
	private List<NotificationItemPojo> NotificationItems;
	
}