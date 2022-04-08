package com.project3.revtech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project3.revtech.dao.BundleRepository;
import com.project3.revtech.entity.BundleEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.BundlePojo;

import org.springframework.boot.test.mock.mockito.MockBean;


@ContextConfiguration(classes= {BundleServiceImpl.class})
@ExtendWith(SpringExtension.class)

public class BundleServiceImplTest {
	
	@MockBean
	BundleRepository bundleRepository;
	
	@Autowired
	BundleServiceImpl bundleServiceImpl;
	
	@Test
	public void testGetAllBundles() throws ApplicationException {
		List<BundleEntity> bundleEntity= new ArrayList<>();
		BundleEntity bundleTest1 = new BundleEntity();
		bundleTest1.setBundleId(1);
		bundleTest1.setBundleName("mensfashion");
		bundleTest1.setBundlePercentage(BigDecimal.valueOf(15L));
		//bundleTest1.setProductOneEntity(null);
	
		BundleEntity bundleTest2 = new BundleEntity();
		bundleTest2.setBundleId(2);
		bundleTest2.setBundleName("womenfashion");
		bundleTest2.setBundlePercentage(BigDecimal.valueOf(30L));
		//bundleTest2.setProductOneEntity(null);
		
		
		bundleEntity.add(bundleTest2);
		bundleEntity.add(bundleTest1);
		
		when(this.bundleRepository.findAll()).thenReturn(bundleEntity);
		
		List<BundlePojo> actualResult = this.bundleServiceImpl.getAllBundles();
		assertEquals(2,actualResult.size());
		
	}

//    @Test
//    public void testGetAllBundles()throws ApplicationException {
//        when(this.bundleRepository.findAll()).thenReturn(new ArrayList<>());
//        assertTrue(this.bundleServiceImpl.getAllBundles().isEmpty());
//        verify(this.bundleRepository).findAll();
//    }

}
