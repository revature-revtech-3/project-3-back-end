package com.project3.revtech.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hibernate.annotations.CreationTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction_details")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;

	@CreationTimestamp
	@Column(name = "transaction_date")
	private Timestamp transactionDate;

	@Column(name = "cart_id")
	private int cartId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
	private Cart cart;

	@OneToMany(mappedBy = "transaction")
	private List<PurchasedItem> purchasedItems;


	public Transaction(int transactionId, @NotNull Timestamp transactionDate, int cartId, Cart cart) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.cartId = cartId;
		this.cart = cart;
	}

	public Transaction(int transactionId, Timestamp transactionDate, int cartId) {
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.cartId = cartId;
	}

	public Transaction(int cartId) {
		this.cartId = cartId;
	}

}
