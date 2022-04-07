package com.project3.revtech.pojo;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BundlePojo {
	private int bundleId;
	private String bundleName;
	private BigDecimal bundlePercentage;
	private ProductPojo productOnePojo = new ProductPojo();
	private ProductPojo productTwoPojo = new ProductPojo();
	
	
}
