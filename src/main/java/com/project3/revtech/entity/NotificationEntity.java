package com.project3.revtech.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification_details")
public class NotificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wish_list_id")
	private int notificationId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	@OneToMany(mappedBy = "NotificationEntity")
	private List<NotificationItemEntity> NotificationItems;

	@Column(name = "wish_list_total")
	private int NotificationTotal;

	public NotificationEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public NotificationEntity(int NotificationId, UserEntity userEntity) {
		super();
		this.notificationId = NotificationId;
		this.userEntity = userEntity;
	}

	public NotificationEntity(int NotificationId, UserEntity userEntity, List<NotificationItemEntity> NotificationItems) {
		super();
		this.notificationId = NotificationId;
		this.userEntity = userEntity;
		this.NotificationItems = NotificationItems;
	}

}
