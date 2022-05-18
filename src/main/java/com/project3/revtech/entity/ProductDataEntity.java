package com.project3.revtech.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_data")
public class ProductDataEntity {
	@Id
	@Column(name = "product_name")
	private String name;
	@Column(name = "sum")
	private int sum;
	
	public ProductDataEntity(int sum) {
		super();
		this.sum = sum;
	}
}
