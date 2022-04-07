package com.project3.revtech.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.BundlePojo;
import com.project3.revtech.pojo.DiscountPojo;
import com.project3.revtech.service.BundleService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class BundleController {
	
	@Autowired
	BundleService bundleService;
	
	//http://localhost:7777/api/bundles
	@GetMapping("bundles")
	List<BundlePojo> getAllDiscounts() throws ApplicationException{
		return bundleService.getAllBundles();
	}
	
	//http://localhost:7777/api/create/bundles
	@PostMapping("create/bundles")
	BundlePojo createBundle( @Valid @RequestBody BundlePojo bundlePojo) throws ApplicationException{
		return bundleService.createBundle(bundlePojo);
	}

}



