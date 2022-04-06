package com.project3.revtech.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bunlde_details")
public class BundleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bundle_id")
	private int bundleId;
	
	@Column(name = "bundle_name")
	private String bundleName;

	@Column(name = "bundle_percentage")
	private BigDecimal bundlePercentage;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_one_id")
	private ProductEntity productOneEntity;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_two_id")
	private ProductEntity productTwoEntity;
	
	
	public BundleEntity(int bundleId, String bundleName,
			BigDecimal bundlePercentage) {
		super();
		this.bundleId = bundleId;
		this.bundleName = bundleName;
		this.bundlePercentage = bundlePercentage;
	}
	
	public BundleEntity(boolean isNull) {
		if(isNull) {
			this.bundleId = -1;
			this.bundleName =  "N/A";
			this.bundlePercentage = new BigDecimal("0.0");
		}
	}

}
