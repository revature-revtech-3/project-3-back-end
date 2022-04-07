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
@Table(name = "wish_list_details")
public class WishListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_id")
	private int wishListId;
	
	@Column(name = "user_id")
	private int userId;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false, insertable = false, updatable = false)
    private UserEntity userEntity; 
    
	@OneToMany(mappedBy = "wishListEntity")
    private List<WishListItemEntity> wishListItems;
	
	@Column(name = "wishList_total")
	private int wishListTotal;

	public WishListEntity(int wishListId, UserEntity userEntity) {
		super();
		this.wishListId = wishListId;
		this.userEntity = userEntity;
	}

	public WishListEntity(int wishListId, UserEntity userEntity, List<WishListItemEntity> wishListItems) {
		super();
		this.wishListId = wishListId;
		this.userEntity = userEntity;
		this.wishListItems = wishListItems;
	}

	public WishListEntity(UserEntity userEntity) {
		super();
		this.userEntity = userEntity;
	}

	public WishListEntity(int userId) {
		super();
		this.userId = userId;
	}

	


	
	
}
