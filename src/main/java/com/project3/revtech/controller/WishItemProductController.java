package com.project3.revtech.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.joinedpojo.WishListAndItemPojo;
import com.project3.revtech.service.WishListItemProductServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("api/wishList-and-items")
public class WishItemProductController {
	
    @Autowired
    WishListItemProductServiceImpl wishListItemProductService;

    @GetMapping("wishList/{bid}/get")
    WishListAndItemPojo getWishList(@PathVariable("bid") int wishListId) throws ApplicationException {
        return wishListItemProductService.getAllWishListItemProducts(wishListId);
    }

//    @GetMapping("user/{bid}/get")
//    WishListAndItemPojo getWishListByUser(@PathVariable("bid") int userId)throws ApplicationException  {
//        return wishListItemProductService.getAllWIshListItemProductsForUser(userId);
//    }

}
