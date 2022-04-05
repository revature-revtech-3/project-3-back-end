package com.project3.revtech.service;

import java.util.List;

import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.BundlePojo;

public interface BundleService {
	

	List<BundlePojo> getAllBundles() throws ApplicationException;
	BundlePojo createBundle(BundlePojo bundlePojo) throws ApplicationException;
//	BundlePojo updateBundle(BundlePojo bundlePojo) throws ApplicationException;
//	boolean removeBundle(int bId) throws ApplicationException;

}
