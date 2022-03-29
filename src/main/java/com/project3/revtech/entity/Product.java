package com.project3.revtech.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;


	@OneToOne(mappedBy = "product")
	private Discount discount;

	@OneToMany(mappedBy = "product")
	private List<PurchasedItem> purchasedItem;

	@NotNull
	@Column(name = "product_sku")
	private String productSku;

	@NotNull
	@Column(name = "product_name")
	private String productName;

	@Min(1)
	@Column(name = "product_cost")
	private BigDecimal productCost;

	@NotNull
	@Column(name = "product_category")
	private String productCategory;

	@NotNull
	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_qty")
	private int productQty;

	@NotNull
	@Column(name = "image_url")
	private String imageUrl;

	@OneToMany(mappedBy = "product")
	private List<Image> images;

	@Column(name = "product_removed")
	private boolean productRemoved;

	@OneToMany(mappedBy = "product")
	private List<CartItem> cartItems;


	public Product(int productId, Discount discount, @NotNull String productSku, @NotNull String productName,
				   @Min(1) BigDecimal productCost, @NotNull String productCategory, @NotNull String productDescription,
				   int productQty, @NotNull String imageUrl, List<Image> images, boolean productRemoved,
				   List<CartItem> cartItems, ArrayList<String> getImageUrls) {
		this.productId = productId;
		this.discount = discount;
		this.productSku = productSku;
		this.productName = productName;
		this.productCost = productCost;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productQty = productQty;
		this.imageUrl = imageUrl;
		this.images = images;
		this.productRemoved = productRemoved;
		this.cartItems = cartItems;
	}

	public Product(int productId, String productSku, String productName, BigDecimal productCost, String productCategory, String productDescription, int productQty, String imageUrl, boolean productRemoved) {
		this.productId = productId;
		this.productSku = productSku;
		this.productName = productName;
		this.productCost = productCost;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productQty = productQty;
		this.imageUrl = imageUrl;
		this.productRemoved = productRemoved;
	}

}
