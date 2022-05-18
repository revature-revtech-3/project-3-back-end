package com.project3.revtech.pojo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnalyticsPojo {
	
	private String productName;
	private  int productQty;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public AnalyticsPojo(String productName, int productQty) {
		super();
		this.productName = productName;
		this.productQty = productQty;
	}
	@Override
	public String toString() {
		return "AnalyticsPojo [productName=" + productName + ", productQty=" + productQty + "]";
	}
	
	
	
	
}
