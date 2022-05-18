package com.project3.revtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;
import com.project3.revtech.pojo.NotificationPojo;
import com.project3.revtech.service.NotificationServiceImpl;

@RestController
@RequestMapping("api/Notification")
@CrossOrigin
public class NotificationController {

	@Autowired
	NotificationServiceImpl NotificationService;

	// add Notification when an user registers an account
	@PostMapping("add/Notifications")
	ResponseEntity<NotificationPojo> addNotification(@RequestBody NotificationPojo Notification) throws ApplicationException {
		return ResponseEntity.ok().header("Content-type", "application/json")
				.body(NotificationService.addNotification(Notification));

	}

	@GetMapping("user/{bid}/get")
	NotificationPojo getNotification(@PathVariable("bid") int userId) throws ApplicationException {
		return NotificationService.getListByUserId(userId);
	}
}
