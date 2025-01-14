package com.project3.revtech.controller;
import java.math.BigDecimal;
import com.project3.revtech.dao.ProductSortRepository;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.dao.ProductRepository;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path ="api")
public class ProductController {

	//@Autowired
	//ProductSortRepository productSort;
    @Autowired
    ProductService productService;

    // Post endPoint Api
    // http://localhost:7777/api/products
    //@PostMapping(value = "products")
    //For Rowel Team Product -  JWT Specific Mapping
    @PostMapping(value = "products/add")
    // http://localhost:7777/api/products/add
    ProductPojo  addProduct(@Valid @RequestBody ProductPojo productPojo) throws ApplicationException{
        return  productService.addProductService(productPojo);
    }

    // Put endPoint Api - Updating by id
    // http://localhost:7777/api/products/update/2
    //@PutMapping("products/{pid}")
    //For Rowel Team Product - JWT Specific Mapping
    @PutMapping("products/update/{pid}")
    ProductPojo updateProduct(@Valid @RequestBody ProductPojo productPojo) throws ApplicationException {
        return productService.updateProductService(productPojo);
    }

    //  Delete endPoint Api - Delete by id
    // http://localhost:7777/api/products/delete/5
    // @DeleteMapping("products/{pid}")
    //For Rowel Team Product - JWT Specific Mapping
    @DeleteMapping("products/delete/{pid}")
    boolean deleteProduct(@PathVariable("pid") int productId) throws ApplicationException{
        return productService.deleteProductService(productId);
    }

    //  Get endPoint Api - Retrieve One Product by id
    // http://localhost:7777/api/products/getone/8
    //@GetMapping("products/{pid}")
    //For Rowel Team Product  JWT Specific Mapping
    @GetMapping("products/getone/{pid}")
    ProductPojo getAProduct(@PathVariable("pid") int productId) throws ApplicationException{
        return productService.getAProductService(productId);
    }

    //  Get endPoint Api - List All Products
    // http://localhost:7777/api/products/getall
    //@GetMapping("products")
    //For Rowel Team Product - JWT Specific Mapping
    @GetMapping("products/getall")
    List<ProductPojo> getAllProducts() throws ApplicationException{
        return productService.getAllProductService();
    }
    
//    @GetMapping("products/getevery")
//    	List<ProductPojo>getEveryProduct() throws ApplicationException{
//    	return productService.getAllProductService();
//    }

    @GetMapping("products/getsecondary/{pid}")
    List<ProductPojo> getSecondaryProducts(@PathVariable("pid") int productId) throws ApplicationException{
		return productService.getSecondaryProducts(productId);
    }
}
