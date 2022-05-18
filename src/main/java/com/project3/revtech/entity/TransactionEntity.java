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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction_details")
public class TransactionEntity {

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
	private CartEntity cartEntity;

	@OneToMany(mappedBy = "transactionEntity")
	@JsonIgnore
	private List<PurchasedItemEntity> purchasedItems;


	public TransactionEntity(int transactionId, @NotNull Timestamp transactionDate, int cartId, CartEntity cartEntity) {
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.cartId = cartId;
		this.cartEntity = cartEntity;
	}

	public TransactionEntity(int transactionId, Timestamp transactionDate, int cartId) {
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.cartId = cartId;
	}

	public TransactionEntity(int cartId) {
		this.cartId = cartId;
	}

}
