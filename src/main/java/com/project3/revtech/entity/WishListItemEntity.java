package com.project3.revtech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="wish_items")
public class WishListItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wish_item_id")
	private int wishItemId;
	
	@Column(name = "wish_list_id")
	private int wishListId;
	
	@Column(name = "product_id")
	private int productId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wish_list_id", nullable = false, insertable = false, updatable = false)
	private WishListEntity wishListEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	private ProductEntity productEntity;

	@Column(name = "wish_item_qty")
	private int wishListQty;

	public WishListItemEntity(int wishItemId, int wishListId, int productId, int wishListQty) {
		super();
		this.wishItemId = wishItemId;
		this.wishListId = wishListId;
		this.productId = productId;
		this.wishListQty = wishListQty;
	}

	public WishListItemEntity(int wishListId, int productId, int wishListQty) {
		super();
		this.wishListId = wishListId;
		this.productId = productId;
		this.wishListQty = wishListQty;
	}

	public WishListItemEntity(int i, int j, WishListEntity wishListTestObj, int k, int l,
			ProductEntity productTestObj) {
		// TODO Auto-generated constructor stub
	}
	
	
}
