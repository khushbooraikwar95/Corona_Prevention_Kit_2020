package com.wf.corona.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wf.corona.exception.CoronaPreventionException;
import com.wf.corona.model.ProductMaster;

public class ProductMasterDaoImpl implements ProductMasterDao {
	
	public static final String INS_ITEM_QRY = "INSERT INTO coronaitems(id,productdesc,productname,cost) values(?,?,?,?)";
	public static final String UPD_ITEM_QRY = "UPDATE coronaitems SET productdesc=?,productname=?,cost=? WHERE id=?";
	public static final String DEL_ITEM_QRY = "DELETE FROM coronaitems WHERE id=?";
	public static final String SEL_ITEM_QRY_BY_ID = "SELECT id,productdesc,productname,cost FROM coronaitems WHERE id=?";
	public static final String SEL_ALL_ITEMS_QRY = "SELECT id,productdesc,productname,cost FROM coronaitems";

	@Override
	public ProductMaster add(ProductMaster productMaster) throws CoronaPreventionException {
		System.out.println("in dao");
		if (productMaster != null) 
		{ 
			try (Connection con = ConnectionFactory.getConnection(); 
					PreparedStatement pst =
		  con.prepareStatement(INS_ITEM_QRY)) {
				System.out.println("INS_ITEM_QRY" + INS_ITEM_QRY);
		  
		  pst.setInt(1, productMaster.getId()); 
		  pst.setString(2, productMaster.getProductDescription());
		  pst.setString(3, productMaster.getProductName()); 
		  pst.setDouble(4, productMaster.getCost());
		  
		  pst.executeUpdate();
		  
		  } 
			catch (SQLException  exp) {
				exp.printStackTrace();
				throw new CoronaPreventionException("Saving the product failed!"); } } 
		return productMaster;
	}

	@Override
	public ProductMaster save(ProductMaster productMaster) throws CoronaPreventionException {
		if (productMaster != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_ITEM_QRY);) {
				System.out.println("in update " + productMaster.getId());

				pst.setString(1, productMaster.getProductDescription());
				pst.setString(2, productMaster.getProductName());
				pst.setDouble(3, productMaster.getCost());
				pst.setInt(4, productMaster.getId());
				pst.executeUpdate();

			} catch (SQLException exp) {
				exp.printStackTrace();
				throw new CoronaPreventionException("An error occured, Could not save the loan details!");
			}
		}
		return productMaster;
	}

	@Override
	public boolean deleteById(Integer productMasterdId) throws CoronaPreventionException {
		boolean isDeleted = false;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_ITEM_QRY);) {

			pst.setInt(1, productMasterdId);

			int rowsCount = pst.executeUpdate();
			
			isDeleted= rowsCount>0 ;

		} catch (SQLException exp) {
			throw new CoronaPreventionException("Could not delete the loan details, Please try again!!");
		}

		return isDeleted;
	}

	@Override
	public List<ProductMaster> getAll() throws CoronaPreventionException {
		
		List<ProductMaster> products = new ArrayList<>();
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ALL_ITEMS_QRY);) {		

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				ProductMaster pm = new ProductMaster();
				pm.setId(rs.getInt(1));
				pm.setProductDescription(rs.getString(2));
				pm.setProductName(rs.getString(3));
				pm.setCost(rs.getDouble(4));
				
				products.add(pm);
			}
			
			if(products.isEmpty()) {
				products=null;
			}
		} catch (SQLException exp) {
			throw new CoronaPreventionException("Could not retrive the loan details, Please try again!!");
		}
				
		return products;
	}

	@Override
	public ProductMaster getById(Integer productMasterId) throws CoronaPreventionException {
		
		ProductMaster product=null;
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ITEM_QRY_BY_ID);) {		

			pst.setInt(1, productMasterId);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				product = new ProductMaster();
				product.setId(rs.getInt(1));
				product.setProductDescription(rs.getString(2));
				product.setProductName(rs.getString(3));
				product.setCost(rs.getDouble(4));
			}
			
		} catch (SQLException exp) {
			throw new CoronaPreventionException("Please try again!!");
		}
		
		return product;
	}
}
