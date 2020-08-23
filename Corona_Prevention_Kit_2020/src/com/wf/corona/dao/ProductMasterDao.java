package com.wf.corona.dao;

import java.util.List;

import com.wf.corona.exception.CoronaPreventionException;
import com.wf.corona.model.ProductMaster;




public interface ProductMasterDao {
	
	ProductMaster add(ProductMaster productMaster) throws CoronaPreventionException;
	ProductMaster save(ProductMaster productMaster) throws CoronaPreventionException;
	boolean deleteById(Integer productMasterdId) throws CoronaPreventionException;
	
	List<ProductMaster> getAll() throws CoronaPreventionException;
	ProductMaster getById(Integer ProductMasterId) throws CoronaPreventionException;
	
	 
	 
}