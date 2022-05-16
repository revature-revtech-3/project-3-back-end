package com.project3.revtech.joinedpojo;

import com.project3.revtech.pojo.ProductPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedItemProduct {

    private int itemId;
    private int transactionId;
    private int userId;
    private int cartId;
    private int productId;
    private int itemQty;
    private BigDecimal purchaseCost;
    private Date purchaseDate;
    private ProductPojo product;

}
