package com.project3.revtech.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_item_id")
	private int cartItemId;

	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "product_id")
	private int productId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
	private Cart cart;

	@Column(name = "cart_qty")
	private int cartQty;

	public CartItem(int cartItemId, int cartId, int productId, int cartQty) {
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.productId = productId;
		this.cartQty = cartQty;
	}
	public CartItem( int cartId, int productId, int cartQty) {
		this.cartId = cartId;
		this.productId = productId;
		this.cartQty = cartQty;
	}

}
