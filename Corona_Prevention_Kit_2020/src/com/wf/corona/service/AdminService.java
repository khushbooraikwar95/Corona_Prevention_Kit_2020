package com.wf.corona.service;

import java.util.List;

import com.wf.corona.exception.CoronaPreventionException;
import com.wf.corona.model.ProductMaster;


public interface AdminService {

	ProductMaster	  validateAndAdd(ProductMaster productMaster) throws CoronaPreventionException;
ProductMaster	  validateAndSave(ProductMaster productMaster) throws CoronaPreventionException;
	  
	  boolean deleteProductMaster(Integer productMasterId) throws CoronaPreventionException;
	  
	  ProductMaster getProductMaster(Integer productMasterId) throws CoronaPreventionException; 
	  List<ProductMaster> getAllProductMasters() throws CoronaPreventionException;
	 
}
